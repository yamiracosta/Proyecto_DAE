--APOYO PARA VALIDAR FORMULARIOS:
SELECT column_name, data_type,character_maximum_length, is_nullable 
FROM information_schema.columns 
WHERE table_name = 'empleado';

select * from contrato;

select * from empleado;

--Consulta para ver los datos del contrato:
select 	e.nombres,e.id,
		c.id as codigocontrato,
		tc.nombre as tipocontrato,
		c.fechainicio,
		c.fechatermino,
		pp.nombre as periodopago,
		ht.turno,
		
		concat(
	    to_char(ht.horaentrada,'HH12:MI AM')
	    || ' - ' ||
	    to_char(ht.horasalida,'HH12:MI AM'))
	    as horario_trabajo,
		
		case
		when c.vacacionespagadas = true then 'Sí'
		when c.vacacionespagadas = false then 'No'
		end as derechovacas,
		coalesce(c.responsabilidades,'No especificadas') as responsabilidades,
		c.salarioacordado
		
		from contrato c
inner join periodo_pago pp on c.idperiodopago=pp.id
inner join tipo_contrato tc on tc.id=c.idtipocontrato
inner join horario_trabajo ht on ht.id=c.idhorariotrabajo
inner join empleado e on e.id=c.idempleado
where e.numdocumento=? and e.idtipodocumento=? and c.estado=?;

--Consulta para ver los detalles de retenciones del contrato vigente del empleado:
select td.tipo as tipodeduccion,ded.nombre as retencion, dd.monto as monto_retenido from detalle_deduccion dd
inner join deduccion ded on ded.id=dd.iddeduccion
inner join tipo_deduccion td on td.id=ded.idtipodeduccion
inner join contrato c on dd.idcontrato=c.id
where c.id=1;




--Consulta para ver la lista de pagos pendientes del trabajador (antes de cancelar contrato):---
(select bp.id,to_char(bp.fechapactada,'DD-MM-YYYY') as fechapactada, COALESCE(TO_CHAR(bp.fechapago, 'YYYY-MM-DD'), 'No definida')
AS fechapago,
case
	when bp.estado=true then 'Pagado'
	when bp.estado=false then 'Atrasado'
end as estadopago,
COALESCE(TO_CHAR(bp.montototal, 'FM999999999.00'), 'No registra') AS montototal
from boleta_pago bp inner join contrato c on c.id=bp.idcontrato
inner join periodo_pago pp on pp.id=c.idperiodopago
where c.id=1 and bp.fechapactada<=current_date and bp.estado=false)

union all 

(
SELECT bp.id,
       TO_CHAR(bp.fechapactada, 'DD-MM-YYYY') AS fechapactada,
       COALESCE(TO_CHAR(bp.fechapago, 'YYYY-MM-DD'), 'No definida') AS fechapago,
       CASE
           WHEN bp.estado=true THEN 'Pagado'
           WHEN bp.estado=false THEN 'Pendiente de pago'
       END AS estadopago,
       COALESCE(TO_CHAR(bp.montototal, 'FM999999999.00'), 'No registra') AS montototal
FROM boleta_pago bp inner join contrato c on c.id=bp.idcontrato
inner join periodo_pago pp on pp.id=c.idperiodopago
WHERE c.id=1 and bp.fechapactada>current_date and bp.fechapactada < current_date + INTERVAL '1 month' and bp.estado=false
	limit 1
)
order by fechapactada asc;
--------------------------------------------------------------------------------------------------------------------------------
-------------------------------------
--1 2 y 3
update boleta_pago set sueldopagado=null,montototalbeneficios=null,montototaldescuentos=null,montodiastrabajados=null,
montototal=null,estado=false,
fechapago=null,idoperador=null where id in(1,2,3);

update contrato set estado='V',idoperador=1 where id=1;
update empleado set estado='V' where id=2;

select * from contrato;

---------------------------------------

select to_char(fechapactada,'DD-MM-YYYY') from boleta_pago;

--Consulta para saber los beneficios de ley asignados a ese pago:
select b.nombre as nombre_beneficio,sum(db.monto) as total_beneficio from detalle_beneficio db
inner join beneficio b on b.id=db.idbeneficio
inner join boleta_pago bp on bp.id=db.idpago
where db.idpago=1
group by nombre_beneficio;

--Consulta para saber los descuentos que esa boleta de pago acredita:
select d.nombre as nombre_descuento,sum(dd.monto) as total_descuento from detalle_descuento dd
inner join descuento d on d.id=dd.iddescuento
inner join boleta_pago bp on bp.id=dd.idpago
where dd.idpago=1
group by nombre_descuento;

------------------------------
select * from boleta_pago; --1,2 y 3
select * from beneficio; --1: grati, 2: asign, 3: cts, 4: utilidades
select * from descuento; --2: serv adic., 3: inasistencia, 4: tardanza

select * from detalle_descuento

--Obtener el salario acordado:----------
select c.salarioacordado from contrato c
where c.id=1;
----------------------------------------

select pp.nombre as periodopago
from contrato c
inner join periodo_pago pp on c.idperiodopago=pp.id
inner join tipo_contrato tc on tc.id=c.idtipocontrato
inner join horario_trabajo ht on ht.id=c.idhorariotrabajo
inner join empleado e on e.id=c.idempleado
where c.id=1;

select * from boleta_pago order by 2; --para comprobar:1,2 y 3

select * from EMPLEADO;

----------------------------------------


--Leslie:
select * from asistencia where idempleado=12; --314 registros

select * from boleta_pago where idcontrato=2; --1 registro

select * from contrato where id=2; --estado:V, motivotermino:null

select estado from empleado where id=12; --V

--delete from detalle_deduccion where idcontrato=2;

--delete from asistencia where idempleado=3;

--delete from boleta_pago where idcontrato=2;

--delete from contrato where id=2;

------------------------------------------------------------------------------------

create or replace function listar_ultimos_pagos(idcont int, periodo varchar(20))
returns table(id integer, fechapactada text, fechapago text, estadopago text, montototal text) as
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

----------------------------------------------------------------------------------------------------------------------------------------
--Mostrar los registros de asistencia de este mes y el mes pasado (como máximo)
select 
CASE
        WHEN to_char(a.fecha, 'Day') = 'Monday   ' THEN 'Lunes'
        WHEN to_char(a.fecha, 'Day') = 'Tuesday  ' THEN 'Martes'
        WHEN to_char(a.fecha, 'Day') = 'Wednesday' THEN 'Miércoles'
        WHEN to_char(a.fecha, 'Day') = 'Thursday ' THEN 'Jueves'
        WHEN to_char(a.fecha, 'Day') = 'Friday   ' THEN 'Viernes'
        WHEN to_char(a.fecha, 'Day') = 'Saturday ' THEN 'Sábado'
    END AS dia_semana, to_char(a.fecha,'dd-MM-yyyy') as fecha,
case when
    	a.horaentrada is null then 'No registra'
		ELSE to_char(a.horaentrada, 'HH24:MI')
	end as horaentrada,
    case when
    	a.horasalida is null then 'No registra'
		ELSE to_char(a.horasalida, 'HH24:MI')
	end as horasalida,
    case
		when a.estado = 'A' then 'Asistió'
		when a.estado = 'T' then 'Tardanza'
		when a.estado = 'F' then 'Faltó'
		when a.estado = 'TJ' then 'Tardanza Justificada'
		when a.estado = 'FJ' then 'Falta justificada'
		when a.estado = 'CP' then 'Con permiso'
		when a.estado = 'V' then 'De vacaciones'
		when a.estado is null then 'Pendiente'
	end as estado
from asistencia a
inner join empleado e on e.id=a.idempleado
inner join contrato c on c.idempleado=e.id
where extract(month from fecha) between extract(month from current_date - INTERVAL '1 month') and extract(month from current_date)
	  and extract(month from fecha) = 6
	  and extract(year from fecha) = extract(year from current_date)
and A.IDEMPLEADO=5
and c.estado='V'
order by a.fecha; --7:00 a.m. a 4:00 p.m.



--Meses actual y anterior del año vigente
select distinct extract(month from a.fecha) as mes from asistencia a
inner join empleado e on e.id=a.idempleado
inner join contrato c on c.idempleado=e.id
where extract(month from fecha) between extract(month from current_date - INTERVAL '1 month') and extract(month from current_date)
	  and extract(year from fecha) = extract(year from current_date) --de este año
and A.IDEMPLEADO=5
and c.estado='V'
order by mes;


--Obtener el número de días disponibles de las vacaciones remuneradas
select (regexp_matches(descripcion, '\d+'))[1] from beneficio as maxdias where nombre='Vacaciones remuneradas';

select count(*) from permiso p
inner join empleado e on p.idempleado=e.id
inner join contrato c on e.id=c.idempleado
where e.id=3 and c.estado='V' and p.estado = 'V'; --3: pedro

select to_char(fechainicio,'dd-MM-yyyy') as fechainicio,
to_char(fechatermino,'dd-MM-yyyy') as fechatermino from contrato
where idempleado=3 and vacacionespagadas=true and estado='V';

select * from empleado;

select descripcion as maxdias from beneficio where nombre='Vacaciones remuneradas';

select p.id, p.fechasolicitud,tp.nombre as tipopermiso,p.descripcion,p.fechainicio,p.fechafin as fechatermino,p.fecharespuesta
from permiso p inner join tipo_permiso tp on p.idtipopermiso=tp.id where p.idempleado=3
order by p.fechasolicitud desc;

--Para asignación familiar: 10% de una RMV (S/. 1025):

--Posible consulta para ver los pagos pendientes del trabajador con contrato vigente
SELECT bp.id,TO_CHAR(bp.fechapactada, 'DD-MM-YYYY') AS fechapactada,COALESCE(TO_CHAR(bp.fechapago, 'YYYY-MM-DD'), 'No definida')
AS fechapago,
CASE
WHEN bp.estado=true THEN 'Pagado'
WHEN bp.estado=false THEN 'Pendiente de pago'
END AS estadopago,
COALESCE(TO_CHAR(bp.montototal, 'FM999999999.00'), 'No registra') AS montototal
FROM boleta_pago bp inner join contrato c on c.id=bp.idcontrato
inner join periodo_pago pp on pp.id=c.idperiodopago
inner join empleado e on c.idempleado = e.id
WHERE e.id=3 and c.estado='V' and bp.fechapactada>current_date and bp.fechapactada < current_date + INTERVAL '1 month'
and bp.estado=false


--Ver las deducciones de un trabajador
select d.nombre as retencion,td.tipo as tiporetencion, dd.monto as montoretenido
from detalle_deduccion dd
inner join deduccion d on dd.iddeduccion=d.id
inner join tipo_deduccion td on d.idtipodeduccion=td.id
inner join contrato c on c.id=dd.idcontrato
inner join empleado e on e.id=c.idempleado
where c.estado='V' and e.id=3;

select salarioacordado as salario from contrato where idempleado=5 and estado='V';

select d.nombre from tipo_deduccion td
inner join deduccion d on d.idtipodeduccion=td.id
where td.id=2 and d.nombre!='AFP';


select * from contrato where idempleado=5 and estado='V' --idemp:5

select count(dd.*) from detalle_deduccion dd
inner join deduccion d on dd.iddeduccion = d.id
where idcontrato=4 and d.nombre='EsSalud';


select iddeduccion from detalle_deduccion dd
inner join deduccion d on dd.iddeduccion=d.id
inner join tipo_deduccion td on td.id=d.idtipodeduccion
where idcontrato=4 and td.tipo='Aporte a fondo de pensiones';


--GESTION DE PAGO DE TRABAJADOR:
select bp.id,
case
when bp.montototal is null then 'No registra'
else TO_CHAR(bp.montototal, 'FM99999999999999990.00')
end as montototal,
bp.fechapactada,
coalesce(to_char(bp.fechapago,'dd-mm-YYYY'),'No registra') as fechapago,
case
when bp.estado = true then 'Pagado'
when bp.estado = false then 'No pagado'
end as estadopago
from boleta_pago bp
where idcontrato=8;


select db.* from detalle_beneficio db
inner join beneficio b on db.idbeneficio = b.id
inner join boleta_pago bp on bp.id=db.idpago
inner join contrato c on c.id=bp.idcontrato
where b.nombre='Utilidades' and c.id=4;