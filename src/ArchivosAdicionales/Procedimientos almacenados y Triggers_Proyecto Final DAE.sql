---------------------------------------------------------------TRIGGERS---------------------------------------------------------------------
--TRIGGER PARA INSERTAR EN LA TABLA ASISTENCIA LUEGO DE REGISTRAR UN CONTRATO DE TRABAJO
create or replace fn_trigger_insert_asistencia() returns trigger AS
$$
declare

idE int;
fechaI date;
fechaF date;
fechaActual date;

begin
	
	--Registrar automáticamente la ficha de asistencia del empleado:
	select idempleado,fechainicio into idE,fechaI from contrato where contrato.id=new.id;
	fechaF := fechaI + INTERVAL '1 year';
	fechaActual := fechaI;
	
	while fechaActual <= fechaF loop
		if extract(DOW from fechaActual) != 0 then
			insert into asistencia(fecha,idempleado) values(fechaActual,idE);
		end if;
		fechaActual := fechaActual + INTERVAL '1 day';
	end loop;
	return new;
end;
$$ language 'plpgsql';

CREATE TRIGGER tr_insert_contrato AFTER INSERT ON public.contrato
FOR EACH ROW EXECUTE FUNCTION fn_trigger_insert_asistencia();

---------------------------------------------------------------------------------------------------------------------------------

--TRIGGER PARA REGISTRAR LA PRIMERA BOLETA DE PAGO DESPUÉS DE REGISTRAR UN NUEVO CONTRATO DE TRABAJO
create or replace function fn_trigger_insert_boleta_pago() RETURNS TRIGGER AS
$$
Declare
	idC int;
	fechaI date;
	periodo varchar(20);
	fechaInsrt date;
Begin
	--Registrar automáticamente en la boleta de pago
	
	select c.id,c.fechainicio,p.nombre
	into idC,fechaI,periodo
	from contrato c
	inner join periodo_pago p on p.id=c.idperiodopago
	where c.id=new.id;
	
	fechaInsrt := fechaI;
	if periodo = 'Mensual' then
		fechaInsrt := fechaInsrt + INTERVAL '1 month';
		insert into boleta_pago(fechapactada,estado,idcontrato) values(fechaInsrt,false,idC);
		
	else
		if periodo = 'Quincenal' then
			fechaInsrt := fechaInsrt + INTERVAL '15 day';
			insert into boleta_pago(fechapactada,estado,idcontrato) values(fechaInsrt,false,idC);
		end if;
	end if;
	return new;
end;
$$ language 'plpgsql';

CREATE TRIGGER trigger_insert_contrato_bp AFTER INSERT ON public.contrato
FOR EACH ROW EXECUTE FUNCTION fn_trigger_insert_boleta_pago();



------------------------------------------------------------PROCEDIMIENTOS ALMACENADOS Y FUNCIONES--------------------------------------------------------------

create or replace function pa_insert_empleado(numdoc varchar(20), tipodoc int, nombres varchar(300), apepat varchar(300), apemat varchar(300), correo varchar(200),
						   tel varchar(20), nomusu varchar(30), contra varchar(255), est char(1), tipoemp int, empemp int, conhijos boolean) returns boolean AS
$$
Declare

Begin
	
	--select md5(nomusu || contra || 'Chamir69') into cont;

	INSERT INTO empleado(numdocumento, idtipodocumento, nombres, ape_paterno,ape_materno, correo, telefono, estado, idtipoempleado,
						 idempleadoempleado,tienehijos) 
	VALUES (numdoc,tipodoc,nombres,apepat,apemat,correo,tel,est,tipoemp,empemp,conhijos);
	return true;
Exception when others then
	return false;
End;
$$ language 'plpgsql';


create or replace function pa_update_empleado(numdoc varchar(20), tipodoc int, nom varchar(300), apepat varchar(300), apemat varchar(300), cor varchar(200), tel varchar(20),
						   nomusu varchar(30), contra varchar(255), est chat(1), tipoemp int, empemp int, conhijos boolean) returns boolean AS
$$
Declare

Begin
	--select md5(nomusu || contra || 'Chamir69') into cont;

	UPDATE public.empleado
	SET
	numdocumento=numdoc,
	idtipodocumento=tipodoc,
	nombres=nom,
	ape_paterno=apepat,
	ape_materno=apemat,
	correo=cor,
	telefono=tel,
	estado=est,
	idtipoempleado=tipoemp,
	idempleadoempleado=empemp,
	tienehijos=conhijos
	WHERE numdocumento=numdoc and idtipodocumento=tipodoc;	
	
	return true;
Exception when others then
	return false;
End;
$$ language 'plpgsql';

---------------------------------------------------------------------------------------------------------------------

--Procedimiento almacenado para registrar credenciales(nombre de usuario y contraseña) en la tabla EMPLEADO
create or REPLACE function pa_registrar_credenciales(usuario varchar(30), contraseña varchar(255), numdoc varchar(20), tipodoc int) returns boolean as
$$
declare
usu varchar(30);
contra varchar(50);
ccifrada varchar(300);
begin
	usu = usuario;
	contra=contraseña;
	select md5(usu || contra || 'Chamir69') into ccifrada;
	
	update public.empleado set
	nombreusuario=usu,
	contraseña=ccifrada
	where numdocumento=numdoc and idtipodocumento=tipdoc;
	return true;
exception when others then
	return false;
end;
$$ language 'plpgsql';

------------------------------------------------------------------------------------------------------------------------------

create or REPLACE function obtener_id_contrato_registrado() returns int as
$$
declare
v_id int;
begin
select id into v_id from contrato where id=new.id;
return v_id;
end;
$$ language 'plpgsql';

--------------------------------------------------------------------------------------------------------------------------------

--Función para verificar si amerita que el contrato de un trabajador caduque (para la transacción CULMINACION DE CONTRATO)
create or REPLACE function fn_amerita_contrato_caducado(idcont integer) returns boolean as
$$
declare
v_codcont int;
v_fechaterm date;
begin
	v_codcont=idcont;
	select fechatermino into v_fechaterm from contrato where id=v_codcont; 
	if v_fechaterm >= current_date then -- 04-24-2025 >= 17-06-2024
		return false; --retorna false si no corresponde culminar el contrato por caducación
	else
		return true; --returna true si el contrato ya amerita terminarlo por caducación
	end if;
end;
$$ language 'plpgsql';

--------------------------------------------------------------------------------------------------------------------------------------------

--Procedimiento almacenado para aprobar una solicitud (se registran cambios en las tablas ASISTENCIA): Transacción GESTION DE PERMISOS
create or REPLACE function fn_aprobar_solicitud(idemp integer, idperm integer) returns void as
$$
declare
	v_id int;
	v_current_date date;
	v_fechaini date;
	v_fechafin date;
	v_fechaactual date;
begin
	
	select id,fechainicio,fechafin into v_id,v_fechaini,v_fechafin from permiso where id=idperm and idempleado=idemp;
	v_fechaactual=v_fechaini;
	
	update permiso set fecharespuesta=current_date,estado='A' where id=v_id;
	
	while v_fechaactual <= v_fechafin loop
		--Actualizar
		if exists(select 1 from asistencia where fecha=v_fechaactual and idempleado=idemp) then
			update asistencia set estado='CP' where fecha=v_fechaactual and idempleado=idemp;
		end if;
		v_fechaactual := v_fechaactual + INTERVAL '1 day';
	end loop;
end;
$$ language 'plpgsql';

-----------------------------------------------------------------------------------------------------------------------------------------------------

--
create or REPLACE function fn_comprobar_fecha_permiso_fecha_contrato(fechafinpermiso date, idemp int) returns boolean as
$$
declare
date_ftc date;
begin
	--Obtenemos la fecha de término de contrato
	select fechatermino into date_ftc from contrato where idempleado=idemp;
	--La comparamos con la fecha que queremos registrar en la interfaz:
	if date_ftc >= fechafinpermiso then
		--Retornamos false si la fecha del permiso no excede la del contrato
		return false;
	else
		--Si excede, retornamos true
		return true;
	end if;
end;
$$ language 'plpgsql';

--------------------------------------------------------------------------------------------------------------------------------------------------

--Función que retorna una lista de los últimos pagos pendientes del contrato del empleado (Útil para la transacción: CULMINACION DE CONTRATO)
create or REPLACE function listar_ultimos_pagos(idcont int, periodo varchar(20)) returns TABLE(id integer, fechapactada text, fechapago text, estadopago text, montototal text) as
$$
declare
	v_periodo varchar(20);
begin

	select nombre
	into v_periodo
	from periodo_pago where nombre=periodo;
	
	if v_periodo='Mensual' then
		
		return query
		
		(select bp.id,to_char(bp.fechapactada,'DD-MM-YYYY') as fechapactada, COALESCE(TO_CHAR(bp.fechapago, 'YYYY-MM-DD'), 'No definida')
		AS fechapago,
		case
			when bp.estado=true then 'Pagado'
			when bp.estado=false then 'Atrasado'
		end as estadopago,
		COALESCE(TO_CHAR(bp.montototal, 'FM999999999.00'), 'No registra') AS montototal
		from boleta_pago bp inner join contrato c on c.id=bp.idcontrato
		inner join periodo_pago pp on pp.id=c.idperiodopago
		where c.id=idcont and bp.fechapactada<=current_date and bp.estado=false)

		union all 

		(
		SELECT bp.id,TO_CHAR(bp.fechapactada, 'DD-MM-YYYY') AS fechapactada,COALESCE(TO_CHAR(bp.fechapago, 'YYYY-MM-DD'), 'No definida')
		AS fechapago,
       	CASE
           	WHEN bp.estado=true THEN 'Pagado'
           	WHEN bp.estado=false THEN 'Pendiente de pago'
      	END AS estadopago,
       	COALESCE(TO_CHAR(bp.montototal, 'FM999999999.00'), 'No registra') AS montototal
		FROM boleta_pago bp inner join contrato c on c.id=bp.idcontrato
		inner join periodo_pago pp on pp.id=c.idperiodopago
		WHERE c.id=idcont and bp.fechapactada>current_date and bp.fechapactada < current_date + INTERVAL '1 month' and bp.estado=false
		limit 1
		)
		order by fechapactada asc;
		
	else
		if v_periodo='Quincenal' then
			
			return query

			(select bp.id,to_char(bp.fechapactada,'DD-MM-YYYY') as fechapactada, COALESCE(TO_CHAR(bp.fechapago, 'YYYY-MM-DD'), 'No definida')
			AS fechapago,
			case
				when bp.estado=true then 'Pagado'
				when bp.estado=false then 'Atrasado'
			end as estadopago,
			COALESCE(TO_CHAR(bp.montototal, 'FM999999999.00'), 'No registra') AS montototal
			from boleta_pago bp inner join contrato c on c.id=bp.idcontrato
			inner join periodo_pago pp on pp.id=c.idperiodopago
			where c.id=idcont and bp.fechapactada<=current_date and bp.estado=false)

			union all 

			(
			SELECT bp.id,TO_CHAR(bp.fechapactada, 'DD-MM-YYYY') AS fechapactada,COALESCE(TO_CHAR(bp.fechapago, 'YYYY-MM-DD'), 'No definida')
			AS fechapago,
			CASE
				WHEN bp.estado=true THEN 'Pagado'
				WHEN bp.estado=false THEN 'Pendiente de pago'
			END AS estadopago,
			COALESCE(TO_CHAR(bp.montototal, 'FM999999999.00'), 'No registra') AS montototal
			FROM boleta_pago bp inner join contrato c on c.id=bp.idcontrato
			inner join periodo_pago pp on pp.id=c.idperiodopago
			WHERE c.id=idcont and bp.fechapactada>current_date and bp.fechapactada < current_date + INTERVAL '15 day' and bp.estado=false
			limit 1
			)
			order by fechapactada asc;
			
		end if;
	end if;

end;
$$ language 'plpgsql';

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Función para verificar si una solicitud de permiso se cruza con otros permisos ya existentes(Transacción GESTION DE PERMISOS) 
create or REPLACE function verificar_cruce_permisos(idemp int, fechaini date, fechaf date) returns boolean as
$$
declare
		v_record record;
	begin
	
		for v_record in (select fechainicio,fechafin from permiso p
			inner join empleado e on e.id=p.idempleado
			inner join contrato c on c.idempleado=e.id
			where p.idempleado=idemp and p.estado in ('P','A')
			and c.estado='V') loop
		
			IF (fechaini, fechaf) OVERLAPS (v_record.fechainicio, v_record.fechafin) THEN
            	RETURN TRUE;
        	END IF;
		
		end loop;
		return false;
	end;
$$ language 'plpgsql';

-------------------------------------------------------------------------------------------------------------------------------------------------

--Función que verifica si el número de boletas de pago por contrato, excede el número máximo permitido según el periodo de pago establecido:
create or replace function fn_verificar_num_boletas_pago(idcont int) returns boolean as
$$
--Retorna true si excede, false si no excede
declare
	num_boletas int;
	v_periodo varchar(20);
	v_tope_num_boletas int;
begin
	select pp.nombre into v_periodo from contrato c
	inner join periodo_pago pp on pp.id=c.idperiodopago
	where c.id=idcont;

	select count(*) into num_boletas from boleta_pago bp
	inner join contrato c on bp.idcontrato=c.id
	where c.id=idcont and c.estado='V';
	
	--Validar el máximo número de boletas permitidas por contrato, según el periodo de pago
	if v_periodo = 'Mensual' then
		v_tope_num_boletas = 12;
	else
		if v_periodo = 'Quincenal' then
			v_tope_num_boletas = 24;
		end if;
	end if;
	
	if (num_boletas+1) > v_tope_num_boletas then
		return true; --excede
	else
		return false; --no excede
	end if;
end;
$$ language 'plpgsql';

------------------------------------------------------------------------------------------------------------------------------------------

--Función que calcula y genera la fecha próxima de la siguiente boleta de pago e inserta:
create or replace function pa_insert_prox_boleta_pago(idcont int) returns void as
$$
declare
	v_periodo varchar(20);
	v_fech_max date;
	v_prox_fech_pago date;
	v_diferencia int;
	v_dia_fijo numeric;
begin
	select extract(day from fechainicio) into v_dia_fijo from contrato where id=idcont; --27 de junio 2024

	select pp.nombre into v_periodo from contrato c
	inner join periodo_pago pp on pp.id=c.idperiodopago
	where c.id=idcont;

	select max(fechapactada) into v_fech_max from boleta_pago where idcontrato=idcont; --12 de julio del 2024
	
	if v_periodo = 'Mensual' then
		v_prox_fech_pago := v_fech_max + INTERVAL '1 month';
		--insert:
		insert into public.boleta_pago(fechapactada,estado,idcontrato) values(v_prox_fech_pago,false,idcont);
	else
		if v_periodo = 'Quincenal' then
			v_prox_fech_pago := v_fech_max + INTERVAL '15 day'; --27 de julio de 2024
			v_diferencia := v_dia_fijo - extract(day from v_prox_fech_pago); --puede ser negativo o positivo, dependiendo del mes
			if (v_diferencia > 2) then
				--insert
				insert into public.boleta_pago(fechapactada,estado,idcontrato) values(v_prox_fech_pago,false,idcont);
				else
					if v_diferencia < 0 then --diferencia negativa (caso de febrero)
						v_prox_fech_pago := v_prox_fech_pago - v_diferencia;
						insert into public.boleta_pago(fechapactada,estado,idcontrato) values(v_prox_fech_pago,false,idcont);
					elsif v_diferencia >= 0 then --diferencia positiva (meses con 30 o 31 días)
						v_prox_fech_pago := v_prox_fech_pago + v_diferencia;
						insert into public.boleta_pago(fechapactada,estado,idcontrato) values(v_prox_fech_pago,false,idcont);
					end if;
			end if;
		end if;
	end if;

end;
$$ language 'plpgsql';

----------------------------------------------------------------------------------------------------------------------------------------------------

--Función que retorna la fecha mínima del próximo pago a efectuar
create or replace function fn_fecha_pago_mas_cercano(idcont int) returns date as
$$
declare
	v_fecha_prox date;
begin
	select min(fechapactada) into v_fecha_prox from boleta_pago where idcontrato=idcont and estado=false;
	return v_fecha_prox;
end;
$$ language 'plpgsql';


---------------------------------------------------------------------------------------------------------------------------------------------------

--Función que calcula el número de tardanzas del control de asistencia entre las fechas correspondientes de una boleta de pago:
create or replace function fn_calcular_num_tardanzas(idcont int, idbp int) returns int as
$$
declare
v_fechaant date;
v_fechadesp date;
v_num_tardanzas int;
begin

WITH Fechas AS (
    SELECT c.fechainicio AS fecha
    FROM contrato c
    WHERE c.id = idcont
    UNION ALL
    SELECT bp.fechapactada AS fecha
    FROM boleta_pago bp
    WHERE bp.idcontrato = idcont and bp.id=idbp
)
,FechasOrdenadas AS (
    SELECT
        fecha,
        LAG(fecha) OVER (ORDER BY fecha) AS fecha_anterior
    FROM Fechas
)

SELECT
fecha_anterior,fecha into v_fechaant,v_fechadesp
FROM FechasOrdenadas
WHERE fecha_anterior IS NOT NULL;

select count(*) into v_num_tardanzas from asistencia a
inner join empleado e on e.id=a.idempleado
inner join contrato c on c.idempleado=e.id
where c.id=idcont and fecha between v_fechaant and v_fechadesp and a.estado='T';

return v_num_tardanzas;

end;
$$ language 'plpgsql';
-----------------------------------------------------------------------------------------------------------------------------------------------------

--Función que calcula el número de inasistencias (o faltas) del control de asistencia entre las fechas correspondientes de una boleta de pago:
create or replace function fn_calcular_num_inasistencias(idcont int, idbp int) returns int as
$$
declare
v_fechaant date;
v_fechadesp date;
v_num_tardanzas int;
begin

WITH Fechas AS (
    SELECT c.fechainicio AS fecha
    FROM contrato c
    WHERE c.id = idcont
    UNION ALL
    SELECT bp.fechapactada AS fecha
    FROM boleta_pago bp
    WHERE bp.idcontrato = idcont and bp.id=idbp
)
,FechasOrdenadas AS (
    SELECT
        fecha,
        LAG(fecha) OVER (ORDER BY fecha) AS fecha_anterior
    FROM Fechas
)

SELECT
fecha_anterior,fecha into v_fechaant,v_fechadesp
FROM FechasOrdenadas
WHERE fecha_anterior IS NOT NULL;

select count(*) into v_num_tardanzas from asistencia a
inner join empleado e on e.id=a.idempleado
inner join contrato c on c.idempleado=e.id
where c.id=idcont and fecha between v_fechaant and v_fechadesp and a.estado='F';

return v_num_tardanzas;

end;
$$ language 'plpgsql';

---------------------------------------------------------------------------------------------------------------------------------

--Función que calcula el monto total de gratificación que le corresponde a un empleado:
create or replace function fn_calcular_monto_grati(idboleta int) returns numeric(9,2) as
$$
declare
v_idboleta int;
v_sueldo_bruto int;
v_num_meses_trabajados int;
v_monto_seguro_salud numeric(9,2);
v_cant_reg_seguro int;
v_monto_grati int;
v_cant_grati_asignadas int;
v_fech_ini date;
v_fech_pact date;
begin
v_idboleta = idboleta;
--Probar con ID: 11

--Obtenemos el salario bruto del trabajador:
select c.salariobruto into v_sueldo_bruto from contrato c
inner join boleta_pago bp on bp.idcontrato=c.id where bp.id=v_idboleta;

--Calcular si el contrato del empleado ya tiene grati pagada en el primer semestre
select count(*) into v_cant_grati_asignadas
from detalle_beneficio db
inner join beneficio b on b.id=db.idbeneficio
inner join boleta_pago bp on bp.id=db.idpago
inner join contrato c on bp.idcontrato=c.id
where b.nombre ilike '%gratificaci' and bp.id=v_idboleta; --cid=4

select c.fechainicio,bp.fechapactada into v_fech_ini,v_fech_pact from boleta_pago bp
inner join contrato c on bp.idcontrato=c.id where bp.id=v_idboleta;

if v_cant_grati_asignadas > 0 then
	if extract(month from v_fech_pact) > extract(month from v_fech_ini) then
		v_fech_ini := v_fech_ini - INTERVAL '5 month';
	else
		v_fech_ini := v_fech_ini - INTERVAL '7 month';
	end if;
else
	v_fech_ini := v_fech_ini;
end if;

--Obtenemos el número de meses trabajados desde la fecha de inicio de su contrato:
SELECT EXTRACT(YEAR FROM age(v_fech_pact::date,v_fech_ini::date)) * 12 +
EXTRACT(MONTH FROM age(v_fech_pact::date,v_fech_ini::date))
into v_num_meses_trabajados
from contrato c
inner join boleta_pago bp on bp.idcontrato=c.id where bp.id=v_idboleta;

--Obtenemos el monto por seguro de salud (si es que tiene)
select count(*) into v_cant_reg_seguro from detalle_deduccion dd
inner join deduccion d on d.id=dd.iddeduccion
inner join tipo_deduccion td on td.id=d.idtipodeduccion
inner join contrato c on c.id=dd.idcontrato
inner join boleta_pago bp on bp.idcontrato = c.id
where bp.id=v_idboleta and td.tipo ilike '%seguro de salud%';

if v_cant_reg_seguro > 0 then
	v_monto_seguro_salud = 0.9 * ((v_sueldo_bruto*v_num_meses_trabajados)/6);
else
	v_monto_seguro_salud = 0;
end if;

--Calculamos el monto total de gratificación:
v_monto_grati = ((v_sueldo_bruto*v_num_meses_trabajados)/6) + v_monto_seguro_salud;

return v_monto_grati;

end;
$$ language 'plpgsql';

---------------------------------------------------------------------------------------------------------------------------------

--Función que calcula el monto total de CTS que le corresponde a un empleado:
create or replace function fn_calcular_monto_CTS(idcont int, idboletap int) returns numeric(9,2) as
$$
declare
	v_cant_cts_asignados int;
	v_monto_cts numeric(9,2);
	v_fecI_cont date;
	v_fech_pact date;
	v_fech_inicio date;
	v_num_meses_trab int;
	v_monto_salario_b numeric(9,2);
begin
	--Calcular el monto del sueldo bruto del empleado
	select salariobruto into v_monto_salario_b from contrato where id=idcont;

	--Calcular si el contrato del empleado ya tiene CTS pagado en el primer semestre
	select count(*) into v_cant_cts_asignados from detalle_beneficio db
	inner join beneficio b on b.id=db.idbeneficio
	inner join boleta_pago bp on bp.id=db.idpago
	inner join contrato c on bp.idcontrato=c.id
	where b.nombre ilike '%cts' and c.id=idcont; --cid=4
	
	select c.fechainicio,bp.fechapactada into v_fecI_cont,v_fech_pact from boleta_pago bp
	inner join contrato c on bp.idcontrato=c.id where bp.id=idboletap;
	
	if v_cant_cts_asignados > 0 then
		v_fech_inicio := v_fecI_cont + INTERVAL '6 month';
	else
		v_fech_inicio := v_fecI_cont;
	end if;
	
	SELECT EXTRACT(YEAR FROM age(v_fech_pact::date,v_fech_inicio::date)) * 12 +
	EXTRACT(MONTH FROM age(v_fech_pact::date,v_fech_inicio::date))
	into v_num_meses_trab
	from contrato c
	inner join boleta_pago bp on bp.idcontrato=c.id where bp.id=idboletap;
	
	--Monto final:
	v_monto_cts = (v_monto_salario_b * v_num_meses_trab)/12;
	
	return v_monto_cts;
end;
$$ language 'plpgsql';