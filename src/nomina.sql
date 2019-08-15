-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-08-2019 a las 19:08:39
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nomina`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `autentificacion` (IN `usua` VARCHAR(20), IN `contra` TEXT)  BEGIN
SELECT username FROM usuarios WHERE username = usua && password = AES_ENCRYPT(contra, 'L4v43xp0rt');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarAsistencia` ()  begin
select * from asistencia;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarCargo` ()  begin
select * from cargo;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarDepartamento` ()  begin
select * from departamento;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarDescuento` ()  begin
select * from descuento;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarEmpleados` ()  begin
select * from empleado;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarExtras` ()  begin
select * from extras;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarHorario` ()  begin
select * from horario;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarNomGen` ()  begin
select * from nomina_general;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarNomInd` ()  begin
select * from nomina_individual;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarPago` ()  begin
select * from pago;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarR_desc_nom` ()  begin
select * from r_desc_nom_i;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarR_extras_nom` ()  begin
select * from r_extrasnom_i;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarAsistencia` (IN `id` INT)  begin
delete from asistencia 
where id_asistencia=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarCargo` (IN `id` INT)  begin
delete from cargo  
where id_cargo=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarDepartamento` (IN `id` INT)  begin
delete from departamento 
where id_departamento=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarDescuento` (IN `id` INT)  begin
delete from descuento
where id_descuento=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarExtras` (IN `id` INT)  begin
delete from extras
where id_extras=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarHorario` (IN `id` INT)  begin
delete from horario
where id_horario=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarNomGen` (IN `id` INT)  begin
delete from nomina_general
where id_nomina_general=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarNomInd` (IN `id` INT)  begin
delete from nomina_individual
where id_nomina_individual=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarPago` (IN `id` INT)  begin
delete from pago
where id_empleado=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarR_desc_nom` (IN `id` INT)  begin
delete from r_desc_nom_i
where id_nomina_individual=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarR_extras_nom` (IN `id` INT)  begin
delete from r_extrasnom_i
where id_nomina_individual=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarAsistencia` (IN `dia1` CHAR(1), IN `dia2` CHAR(1), IN `dia3` CHAR(1), IN `dia4` CHAR(1), IN `dia5` CHAR(1), IN `dia6` CHAR(1), IN `dia7` CHAR(1))  begin
insert into asistencia (dia1,dia2,dia3,dia4,dia5,dia6,dia7)
values (dia1,dia2,dia3,dia4,dia5,dia6,dia7);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarCargo` (IN `descripcion` VARCHAR(50))  begin
insert into cargo (descripcion_cargo)
values (descripcion);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarDepartamento` (IN `area` VARCHAR(50), IN `num_trab` INT)  begin
insert into departamento (area,num_trab)
values (area,num_trab);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarDescuento` (IN `descripcion_descuento` VARCHAR(100))  begin
insert into descuento (descripcion_descuento)
values (descripcion_descuento);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEmpleado` (IN `id_empleado` INT, IN `id_horario` INT, IN `id_cargo` INT, IN `nombre` VARCHAR(50), IN `apellido_paterno` VARCHAR(50), IN `apellido_materno` VARCHAR(50), IN `curp` VARCHAR(50), IN `id_departamento` INT, IN `direccion` VARCHAR(100), IN `salario` DOUBLE(8,2), IN `sexo` INT, IN `estatus` INT, IN `num_seg_social` INT, IN `rfc` VARCHAR(14), IN `gratificacion` DOUBLE(10,2), IN `fecha_nacimiento` DATE, IN `fecha_entrada` DATE)  begin
insert into empleado(id_empleado,id_horario,id_cargo,nombre,apellido_paterno,apellido_materno,curp,id_departamento,direccion,salario,sexo,
estatus,num_seg_social,rfc,gratificacion,fecha_nacimiento,fecha_entrada)
values(id_empleado,id_horario,id_cargo,nombre,apellido_paterno,apellido_materno,curp,id_departamento,direccion,salario,sexo,
estatus,num_seg_social,rfc,gratificacion,fecha_nacimiento,fecha_entrada);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarExtras` (IN `descripcion_extras` VARCHAR(100))  begin
insert into extras (descripcion_extras)
values (descripcion_extras);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarHorario` (IN `hora_llegada` TIME, IN `hora_salida` TIME, IN `turno` VARCHAR(50))  begin
insert into horario (hora_llegada,hora_salida,turno)
values (hora_llegada,hora_salida,turno);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarNomGen` (IN `semana` INT, IN `fecha_inicio` DATE, IN `fecha_fin` DATE, IN `anio` INT, IN `total_extras` DOUBLE(7,2), IN `total_desc` DOUBLE(7,2), `total_nom` INT)  begin
insert into nomina_general (semana,fecha_inicio,fecha_fin,anio,total_extras,total_desc,total_nom)
values (semana,fecha_inicio,fecha_fin,anio,total_extras,total_desc,total_nom);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarNomInd` (IN `id_empleado` INT, IN `id_nomina_general` INT, IN `total_nom_ind` INT, IN `id_asistencia` INT)  begin
insert into nomina_individual (id_empleado,id_nomina_general,total_nom_ind,id_asistencia)
values (id_empleado,id_nomina_general,total_nom_ind,id_asistencia);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarPago` (IN `id_empleado` INT, IN `numero_cuenta` VARCHAR(20), IN `numero_tarjeta` VARCHAR(20), IN `descripcion_pago` VARCHAR(20))  begin
insert into pago (id_empleado,numero_cuenta,numero_tarjeta,descripcion_pago)
values (id_empleado,numero_cuenta,numero_tarjeta,descripcion_pago);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarR_desc_nom` (IN `id_nomina_individual` INT, IN `id_descuento` INT, IN `cantidad` DECIMAL(10,2))  begin
insert into r_desc_nom_i(id_nomina_individual,id_descuento,cantidad)
values (id_nomina_individual,id_descuento,cantidad);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarR_extras_nom` (IN `id_nomina_individual` INT, IN `id_extras` INT, IN `cantidad` DECIMAL(10,2))  begin
insert into r_extrasnom_i(id_nomina_individual,id_extras,cantidad)
values (id_nomina_individual,id_extras,cantidad);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarAsistencia` (IN `dia1` CHAR(1), IN `dia2` CHAR(1), IN `dia3` CHAR(1), IN `dia4` CHAR(1), IN `dia5` CHAR(1), IN `dia6` CHAR(1), IN `dia7` CHAR(1), IN `id` INT)  begin
update asistencia set dia1=dia1,dia2=dia2,dia3=dia3,dia4=dia4,dia5=dia5,dia6=dia6,dia7=dia7
where id_asistencia=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarCargo` (IN `descripcion` VARCHAR(50), IN `id` INT)  begin
update cargo set descripcion_cargo=descripcion 
where id_cargo=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarDepartamento` (IN `area` VARCHAR(50), IN `num_trab` INT, IN `id` INT)  begin
update departamento set area=area, num_trab=num_trab
where id_departamento=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarDescuento` (IN `descripcion_descuento` VARCHAR(100), IN `id` INT)  begin
update descuento set descripcion_descuento = descripcion_descuento
where id_descuento=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarEmpleado` (IN `id_horario` INT, IN `id_cargo` INT, IN `nombre` VARCHAR(50), IN `apellido_paterno` VARCHAR(50), IN `apellido_materno` VARCHAR(50), IN `curp` VARCHAR(50), IN `id_departamento` INT, IN `direccion` VARCHAR(100), IN `salario` DOUBLE(8,2), IN `sexo` INT, IN `estatus` INT, IN `num_seg_social` INT, IN `rfc` VARCHAR(14), IN `gratificacion` DOUBLE(10,2), IN `fecha_nacimiento` DATE, IN `fecha_entrada` DATE, IN `id` INT)  begin
update empleado set 
id_horario=id_horario,
id_cargo=id_cargo ,
nombre=nombre ,
apellido_paterno=apellido_paterno ,
apellido_materno=apellido_materno ,
curp=curp ,
id_departamento=id_departamento ,
direccion=direccion ,
salario=salario ,
sexo=sexo ,
estatus=estatus ,
num_seg_social=num_seg_social ,
rfc=rfc ,
gratificacion=gratificacion,
fecha_nacimiento = fecha_nacimiento ,
fecha_entrada = fecha_entrada
where id_empleado=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarExtras` (IN `descripcion_extras` VARCHAR(100), IN `id` INT)  begin
update extras set descripcion_extras = descripcion_extras
where id_extras=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarHorario` (IN `hora_llegada` TIME, IN `hora_salida` TIME, IN `turno` CHAR(50), IN `id` INT)  begin
update horario set hora_llegada = hora_llegada , hora_salida = hora_salida , turno = turno
where id_horario=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarNomGen` (IN `semana` INT, IN `fecha_inicio` DATE, IN `fecha_fin` DATE, IN `anio` INT, IN `total_extras` DOUBLE(7,2), IN `total_desc` DOUBLE(7,2), `total_nom` INT, IN `id` INT)  begin
update pago set semana = semana, fecha_inicio = fecha_inicio, fecha_fin = fecha_fin , anio = anio , total_extras = total_extras ,total_desc = total_desc , total_nom = total_nom
where id_nomina_general=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarNomInd` (IN `id_empleado` INT, IN `id_nomina_general` INT, IN `total_nom_ind` INT, IN `id_asistencia` INT, IN `id` INT)  begin
update nomina_individual set id_empleado = id_empleado, id_nomina_general = id_nomina_general , total_nom_ind = total_nom_ind , id_asistencia  = id_asistencia 
where id_nomina_individual=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarPago` (IN `numero_cuenta` VARCHAR(20), IN `numero_tarjeta` VARCHAR(20), IN `descripcion_pago` VARCHAR(20), IN `id` INT)  begin
update pago set numero_cuenta = numero_cuenta , numero_tarjeta = numero_tarjeta , descripcion_pago = descripcion_pago
where id_empleado=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarR_desc_nom` (IN `id_descuento` INT, IN `cantidad` DECIMAL(10,2), IN `id` INT)  begin
update r_desc_nom_i set id_descuento = id_descuento , cantidad  = cantidad 
where id_nomina_individual=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarR_extras_nom` (IN `id_extras` INT, IN `cantidad` DECIMAL(10,2), IN `id` INT)  begin
update r_extrasnom_i set id_extras = id_extras , cantidad  = cantidad 
where id_nomina_individual=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `NominaIndividual` (IN `id_empleado_p` INT, IN `idnomi_general` INT, IN `total_nom` DECIMAL, IN `dia1` CHAR(6), IN `dia2` CHAR(6), IN `dia3` CHAR(6), IN `dia4` CHAR(6), IN `dia5` CHAR(6), IN `dia6` CHAR(6), IN `dia7` CHAR(6))  BEGIN

insert into nomina_individual(id_empleado,id_nomina_general,total_nom_ind) VALUES (id_empleado_p,idnomi_general,total_nom);


insert into asistencia(id_nomina_individual, dia1, dia2, dia3, dia4, dia5, dia6, dia7) values (LAST_INSERT_ID(), dia1, dia2, dia3, dia4, dia5, dia6, dia7);


END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `id_nomina_individual` int(11) NOT NULL,
  `dia1` char(6) DEFAULT NULL,
  `dia2` char(6) DEFAULT NULL,
  `dia3` char(6) DEFAULT NULL,
  `dia4` char(6) DEFAULT NULL,
  `dia5` char(6) DEFAULT NULL,
  `dia6` char(6) DEFAULT NULL,
  `dia7` char(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`id_nomina_individual`, `dia1`, `dia2`, `dia3`, `dia4`, `dia5`, `dia6`, `dia7`) VALUES
(623, '1', '1', '1', '1', '1', '1', '1'),
(624, '1', '1', '1', '1', '1', '1', '1'),
(625, '1', '1', '1', '1', '1', '1', '1'),
(626, '1', '1', '1', '1', '1', '1', '1'),
(627, '1', '1', '1', '1', '1', '1', '1'),
(628, '1', '1', '1', '1', 'PT', 'PT', 'PT'),
(629, '1', '1', '1', '1', '1', '1', '1'),
(630, '1', '1', '1', '1', '1', '1', '1'),
(631, '1', '1', '1', '1', '1', '1', '1'),
(632, '1', '1', '1FINJ', '1FINJ', '1', '1', '1'),
(633, '1', '1', '1', '1', '1', 'P', 'P'),
(634, '1', '1', '1', '1', '1', '1', '1'),
(635, '1', '1', '1', '1', '1', '1', '1'),
(636, '1FINJ', '1', '1', '1', '1', '1', '1'),
(637, '1', '1', '1', '1', '1', '1', '1'),
(638, '1', '1', '1', '1', '1', '1', '1'),
(639, '1', '1', '1', '1', '1', '1', '1'),
(640, '1', '1', '1', '1', '1', '1', '1'),
(641, '1', '1', '1', '1FINJ', '1', '1', '1'),
(642, '1', '1', '1', 'P', '1FINJ', '1', '1'),
(643, 'INC', 'INC', 'INC', 'INC', 'INC', 'INC', 'INC'),
(644, '1', '1', '1', '1', '1FINJ', '1FINJ', '1FINJ'),
(645, '1', '1', '1', '1', '1', '1', '1'),
(646, '1', '1', '1', '0.875', '1', '1', '1'),
(647, '1', '1FINJ', '1', '1FINJ', '1', '1', '1'),
(648, 'PT', '1', '1', '1', '1', '1', '1'),
(649, '1', '1', '1', '1', '1', '1', '1'),
(650, '1', '1', '1', '1', '1', '1', '1'),
(651, '1', '1', '1', '1', '1FINJ', '1', '1'),
(652, '1', '1', '1', '1', '1', '1', '1'),
(653, '1', '1', '1', '1', '1', '1', '1'),
(654, '1', '1', '1', '1', '1', '1', '1'),
(655, '1', '1', '1', '1', '1', '1', '1'),
(656, '1', '1', '1', 'P', '1FINJ', '1FINJ', '1FINJ'),
(657, '1', '1', '1', '1', '1', 'PT', 'PT'),
(658, '1', '1', '1', '1', '1', '1', '1'),
(659, '1', '1', '1', '0.62', '1', '1', '1'),
(660, 'PT', '1', '1', '1', '1', '1', '1'),
(661, '1', '1', '1', '1', '1', '1', '1'),
(662, '1', '1', '1', '1FINJ', 'P', '1FINJ', '1FINJ'),
(663, '1', '1', '1', '1', '1', '1', '1'),
(664, '1', '1', '1', '1', '1', '1', '1'),
(665, '1', '1', '1', '1', '1', '1', '1'),
(666, '1FINJ', '1FINJ', '1', '1', '1', '1', '1'),
(667, 'V', 'V', 'V', 'V', 'V', 'V', 'V'),
(668, '1', '1', '1', '1', '1', '1', '1'),
(669, '1', '1', 'PT', '1', '1', 'PT', 'PT'),
(670, 'P', '1', '1', '1', '1FINJ', '1', '1'),
(671, '1', '1', '1', '1FINJ', '1', '1', '1'),
(672, '1', '1', '1', '1', '1', '1', '1'),
(673, '1', '1', '1', '1', '1FINJ', '1', '1'),
(674, '1', '1', '1', '1', '1', '0.49', '0.49'),
(675, '1', '1', '1', '1', '1', '1', '1'),
(676, '1', '1', '1', '1', '1', '1', '1'),
(677, '1', '1', '1', '1', '1', '1', '1'),
(678, '1', '1', '1', '1', '1', '1', '1'),
(679, '1', '1', '1', '1', '1', '1', '1'),
(680, '1', '1', '1', '1', '1', '1', '1'),
(681, '1', '1', '1', '1', '1', '1', '1'),
(682, '1', '1', '1', '1', '1', '1', '1'),
(683, '1', '1', '1', '1', '1', '1', '1'),
(684, '1', '1', '1', '1', '1', '1', '1'),
(685, '1', '1', '1', 'P', '1', '1', '1'),
(686, '1', '1', '1', '1', '1', '1', '1'),
(687, '1', '1', '1', '1', '1', '1', '1'),
(688, '1', '1', 'P', 'P', 'P', 'P', 'P'),
(689, '1', '1', '1', '1', '1', '1FINJ', '1FINJ'),
(690, '1', '1', '1', '1', '1', '1', '1'),
(691, '1', '1', '1', '1', '1', '1', '1'),
(692, '1', '1', '1', '1', '1', '1', '1'),
(693, '1', '1', '1', '1', '1', '1', '1'),
(694, '1', '1', '1', '1', '1', '1', '1'),
(695, '1', '1', '1', '1FINJ', '1', '1', '1'),
(696, '1', '1', '1', '1', '1', '1', '1'),
(697, '1', 'PT', '1', '1', '1', '1', '1'),
(698, '1FINJ', '1FINJ', '1FINJ', '1FINJ', 'P', '1', '1'),
(699, '1', '1', '1', '1', '1', '1', '1'),
(700, '1', '1', '1', '1', '1', '1', '1'),
(701, '1', '1', '1', '1', '1', '1', '1'),
(702, '1', '1', '1', '1', '1', '1', '1'),
(703, '1FINJ', '1', '1', '1', '1', '1', '1'),
(704, '1', '1', '1', '1', 'P', '1', '1'),
(705, '1', '1', '1', '1', '1', '1', '1'),
(706, '1', '1', '1', '1', '1', '1', '1'),
(707, '1', '1', '1', '1', '1', '1', '1'),
(708, '1', '1', '1', '1', '1', '1', '1'),
(709, '0.6', '0.6', '0.6', '0.6', '0.6', '0.6', '0.6'),
(710, '1', '1', '1', '1', '1', '1', '1'),
(711, '1', '1', '1', '1', '1', '1', '1'),
(712, '1', '1', 'PT', '1', 'PT', 'PT', 'PT'),
(713, 'INC', 'INC', 'INC', 'INC', 'INC', 'INC', 'INC'),
(714, '1', '1', '1', '1', '1', '1', '1'),
(715, '1', '1', '1', '1', '1', '1', '1'),
(716, '1', '1', '1', '1', '1', '1', '1'),
(717, '1', '1', '1', '1', 'PT', '1', '1'),
(718, '1', 'P', '1', '1', '1FINJ', '1', '1'),
(719, 'P', '1', '1', '1', '1', '1', '1'),
(720, '1', '1', '1', '1', '1', '1', '1'),
(721, '1', '1', '1', '1', '1FINJ', '1FINJ', '1FINJ'),
(722, '1', '1FINJ', '1', '1', '1', '1', '1'),
(723, '1', '1', '1', '1', '1', '1', '1'),
(724, '1', '1', '1', '1', '1', '1', '1'),
(725, '1', '1', 'PT', '1', '1', 'PT', 'PT'),
(726, '1', '1', '1', '1', '1', '1', '1'),
(727, '1', '1', '1', '1', '1', '1', '1'),
(728, '1', '1', '1', '1', '1', '1', '1'),
(729, '1', '1', '1', '1', '1', '1', '1'),
(730, '1', '1', '1', '1', '1', '1', '1'),
(731, '1FINJ', '1FINJ', '1FINJ', '1FINJ', '1', '1', '1'),
(732, '1', '1', '1', 'P', '1', '1', '1'),
(733, '1', '1', '1', '1', '1', '1', '1'),
(734, '1', '1', '1', '1', '1', '1', '1'),
(735, '1', '1', '1', '1', '1', '1', '1'),
(736, '1', '1', 'PT', '1', '1', 'PT', 'PT'),
(737, '1', '1', '1', '1', '1', '1', '1'),
(738, '1', '1', '1', '1', '1', '1', '1'),
(739, '1', '1', '1', '1', '1', '1', '1'),
(740, '1', '1', '1', '1', '1', '1', '1'),
(741, '1', '1FINJ', '1', '1', '1', '1', '1'),
(742, '1', '1', '1', '0.49', '1', '1', '1'),
(743, '1', '1FINJ', '1', '1', '1', '1', '1'),
(744, '1', '1', '1', '1', '1', '1', '1'),
(745, '1', '1', '1', '1', '1', '1', '1'),
(746, '1', '1', '1', '1', '1', '1', '1'),
(747, '1', '1', '1', '1', '1', '1', '1'),
(748, '1', '1', '1', '1', '1', '1', '1'),
(749, '1', '1', 'PT', '1', 'PT', '1', '1'),
(750, '1', '1', '1', '1', '1', '1', '1'),
(751, '1', '1', '1', '1', '1', '1', '1'),
(752, '1', '1', '1', '1', '1', '1', '1'),
(753, 'P', 'P', '1', '1', '1', '1', '1'),
(754, '1', '1', '1', '1', '1', '1', '1'),
(755, '1', '1', '1', '1', '1', '1', '1'),
(756, '1', '1', '1', '1', '1', '1', '1'),
(757, '1', '1', '1', '1', '1', '1', '1'),
(758, '1', '1', '1', '1', '1', '1', '1'),
(759, '1', '1', '1', '1FINJ', 'P', '1FINJ', '1FINJ'),
(760, '1', '1', '1', '1', '1', '1', '1'),
(761, '1', '1', '1', '1', '1', '1', '1'),
(762, '1', '1', '1', '1', '1', '1', '1'),
(763, '1', '1', '1', '1', '1', '1', '1'),
(764, '1', 'P', '1', '1', 'P', '1', '1'),
(765, '1', '1', '1', '1', '1', '1', '1'),
(766, '1', '1FINJ', '1', '1', '1', '1', '1'),
(767, '1', '1', '1', '1', '1', '1', '1'),
(768, '1', '1', '1', '1FINJ', '1', '1', '1'),
(769, '1', '1', '1', '0.875', '1', '1', '1'),
(770, '1', '1', '1', '1', '1', '1', '1'),
(771, '1', '1', '1', '1', '1', '1', '1'),
(772, '1', '1', '1', '1', '1', 'PT', 'PT'),
(773, '1', '1', '1', '1', '1', '1', '1'),
(774, '1FINJ', '1FINJ', '1FINJ', '1FINJ', '1FINJ', '1', '1'),
(775, '1', 'P', '1', '1', '1', '1', '1'),
(776, '1', '1', '1', '1', '1', '1', '1'),
(777, '1', '1', '1', '1', '1', '1', '1'),
(778, '1', '1', '1', '1', '1', '1', '1'),
(779, '1', '1', '1', '1', '1', '1', '1'),
(780, '1', '1', '1', '1', '1', '1', '1'),
(781, '1', '1', '1', '1', '1FINJ', '1FINJ', '1FINJ'),
(782, '1', '1', '1', '1', '1', '1', '1'),
(783, '1', '1', '1', '1', '1', '1', '1'),
(784, 'INC', 'INC', 'INC', 'INC', 'INC', 'INC', 'INC'),
(785, '1', '1', '1', '1', '1', '1', '1'),
(786, '1', '1', '1', '1', '1', '1', '1'),
(787, 'INC', 'INC', 'INC', 'INC', 'INC', 'INC', 'INC'),
(788, '1', '1', '1', '1', '1', '1', '1'),
(789, '1', '1', '1', '1', '1', '1', '1'),
(790, '1', '1', '1', '1', '1', '1', '1'),
(791, '1', '1', '1', '1', '1', '1', '1'),
(792, '1', '1', '1', '1', '1', '1', '1'),
(793, 'PT', '1', '1', '1', '1', '1', '1'),
(794, '1', '1', '1', '1', '1', '1', '1'),
(795, '1FINJ', '1FINJ', '1FINJ', '1FINJ', '1', '1', '1'),
(796, '1', '1', '1', '1', '1', '1', '1'),
(797, '1', '1', '1', '1', '1', '1', '1'),
(798, '1', '1', '1', '1', '1FINJ', 'P', 'P'),
(799, '1', '1', '1', '1', '1', '1', '1'),
(800, '1', '1', '1', '1', '1', 'PT', 'PT'),
(801, 'P', '1', '1', '1', '1', '1', '1'),
(802, '1', '1', '1', '1', '1', '1', '1'),
(803, '1', '1', '1', '1', '1', '1', '1'),
(804, '1', 'PT', '1', '1', 'PT', '1', '1'),
(805, '1', '1', '1', '1', '1', '1', '1'),
(806, '1', '1', '1', '1', '1', '1', '1'),
(807, '1', 'P', '1', '1', '1', '1', '1'),
(808, '1', '1', '1', '1', '1', '1', '1'),
(809, '1', '1', '1', '1', '1FINJ', '1', '1'),
(810, '1', '1', '1', '1', '1', '1', '1'),
(811, '1', '1', '1', '1', '1', '1', '1'),
(812, '1', '1', '1', '1', '1', '1', '1'),
(813, '1', '1', '1', '1', '1', '1', '1'),
(814, '1', '1', '1', '1', '1', 'PT', 'PT'),
(815, 'P', 'P', 'P', 'P', 'P', 'P', 'P'),
(816, 'P', 'P', 'P', 'P', '1', '1', '1'),
(817, '1', '1', '1', '1', '1', '1', '1'),
(818, '1', '1', '1', '1', 'PT', '1', '1'),
(819, '1', '1', '1', '1', '1', '1', '1'),
(820, '1', '1', '1', '1', 'P', '1', '1'),
(821, '1', '1', '1', '1', '1', '1', '1'),
(822, '1', '1', '1', '1', '1', '1', '1'),
(823, '1', '1', '1', '1', '1', 'PT', 'PT'),
(824, '1', '1', '1', '1', '1FINJ', '1', '1'),
(825, '1FINJ', '1FINJ', '1', '1', '1', '1', '1'),
(826, '1', '1FINJ', '1', '1FINJ', '1', '1FINJ', '1FINJ'),
(827, '1', '1', '1', '1FINJ', '1', '1', '1'),
(828, '1', '1', '1', '1', '1', '1', '1'),
(829, '1', '1', '1', '1', '1', '1', '1'),
(830, '1', '1', '1', '1', '1', '1', '1'),
(831, '1', '1', '1', '1', '1', '1', '1'),
(832, '1', '1', '1', '1', '1', '1', '1'),
(833, '1', '1', '1', '1', '1', '1', '1'),
(834, '1', '1', '1', '1', '1', '1', '1'),
(835, '1', '1', '1FINJ', '1FINJ', '1FINJ', 'B', 'B'),
(836, '1FINJ', '1', '1', '1FINJ', '1FINJ', 'B', 'B'),
(837, '1', '1', '1', '1', '1', '1', '1'),
(838, '1', '1', '1', '1', '1', '1', '1'),
(839, '1', '1', '1', '1', '1', '1', '1'),
(840, '1', '1', '1', '1', '1', '1', '1'),
(841, '1FINJ', '1', '1', '1', '1FINJ', '1', '1'),
(842, '1', '1FINJ', '1', '1', 'P', '1', '1'),
(843, '1', '1', '1', '1FINJ', '1FINJ', '1', '1'),
(844, '1', '1', '1', '1', '1', '1', '1'),
(845, '1', '1', '1', '1', '1', '1', '1'),
(846, '1', '1', '1', '1', '1', '1', '1'),
(847, '1', '1', '1', '1', '1', '1', '1'),
(848, '1FINJ', '1FINJ', '1FINJ', '1FINJ', '1FINJ', '1', '1'),
(849, '1FINJ', '1FINJ', '1FINJ', '1FINJ', '1FINJ', '1', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id_cargo` int(11) NOT NULL,
  `descripcion_cargo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `descripcion_cargo`) VALUES
(1, 'Gerente'),
(2, 'Trabajador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL,
  `area` varchar(50) NOT NULL,
  `num_trab` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`id_departamento`, `area`, `num_trab`) VALUES
(1, 'logistica', 10),
(2, 'confeccion', 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuento`
--

CREATE TABLE `descuento` (
  `id_descuento` int(11) NOT NULL,
  `descripcion_descuento` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `descuento`
--

INSERT INTO `descuento` (`id_descuento`, `descripcion_descuento`) VALUES
(1, 'RETARDO'),
(2, 'OTROS DESCUENTOS'),
(3, 'PANTALONES'),
(4, 'INFONAVIT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL,
  `id_horario` int(11) NOT NULL,
  `id_cargo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `curp` varchar(50) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `salario` double(10,2) NOT NULL,
  `gratificacion` double(10,2) NOT NULL,
  `sexo` int(11) NOT NULL,
  `estatus` int(11) NOT NULL,
  `num_seg_social` int(11) NOT NULL,
  `rfc` varchar(13) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_entrada` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `id_horario`, `id_cargo`, `nombre`, `apellido_paterno`, `apellido_materno`, `curp`, `id_departamento`, `direccion`, `salario`, `gratificacion`, `sexo`, `estatus`, `num_seg_social`, `rfc`, `fecha_nacimiento`, `fecha_entrada`) VALUES
(1, 1, 1, 'Alfredo', 'Ramirez', 'Hernandez', 'RAHA900214HPLMRL09', 1, 'Calle san jose numero 711 colonia ricardo flores magon', 4500.00, 300.45, 1, 1, 154321, 'RAHA900214HPL', '2000-02-15', '2018-01-10'),
(2, 2, 2, 'Gonzalo', 'Martinez', 'Sanchez', 'MASG900214HPLMRL09', 1, 'Calle gabino barreda 809', 2500.00, 100.45, 1, 1, 154321, 'MASG900214HPL', '1998-03-11', '2017-02-13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extras`
--

CREATE TABLE `extras` (
  `id_extras` int(11) NOT NULL,
  `descripcion_extras` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `extras`
--

INSERT INTO `extras` (`id_extras`, `descripcion_extras`) VALUES
(1, 'horas extras'),
(2, 'dias festivos'),
(3, 'PRODUCCION'),
(4, 'VELADA'),
(5, 'VIAJE'),
(6, 'DOMINGO'),
(7, 'VACACIONES'),
(8, 'TIEMPO EXTRA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `id_horario` int(11) NOT NULL,
  `hora_llegada` time NOT NULL,
  `hora_salida` time NOT NULL,
  `turno` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`id_horario`, `hora_llegada`, `hora_salida`, `turno`) VALUES
(1, '08:00:00', '16:00:00', 'matutino'),
(2, '13:00:00', '20:00:00', 'vespertino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina_general`
--

CREATE TABLE `nomina_general` (
  `id_nomina_general` int(11) NOT NULL,
  `semana` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `anio` int(11) NOT NULL,
  `total_extras` double(9,2) DEFAULT NULL,
  `total_desc` double(9,2) DEFAULT NULL,
  `total_nom` decimal(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nomina_general`
--

INSERT INTO `nomina_general` (`id_nomina_general`, `semana`, `fecha_inicio`, `fecha_fin`, `anio`, `total_extras`, `total_desc`, `total_nom`) VALUES
(15, 1, '2019-08-01', '2019-08-13', 2019, 132636.00, 2998.00, '338862.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina_individual`
--

CREATE TABLE `nomina_individual` (
  `id_nomina_individual` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_nomina_general` int(11) NOT NULL,
  `total_nom_ind` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nomina_individual`
--

INSERT INTO `nomina_individual` (`id_nomina_individual`, `id_empleado`, `id_nomina_general`, `total_nom_ind`) VALUES
(623, 1, 15, '1200.00'),
(624, 39, 15, '910.00'),
(625, 163, 15, '3000.00'),
(626, 199, 15, '1150.00'),
(627, 215, 15, '2300.00'),
(628, 221, 15, '1046.00'),
(629, 254, 15, '1485.00'),
(630, 261, 15, '1720.00'),
(631, 303, 15, '701.00'),
(632, 456, 15, '1278.00'),
(633, 463, 15, '1200.00'),
(634, 533, 15, '3126.00'),
(635, 544, 15, '1180.00'),
(636, 545, 15, '973.00'),
(637, 579, 15, '8414.00'),
(638, 601, 15, '950.00'),
(639, 686, 15, '2495.00'),
(640, 717, 15, '823.00'),
(641, 720, 15, '2115.00'),
(642, 728, 15, '1599.00'),
(643, 820, 15, '488.00'),
(644, 833, 15, '964.00'),
(645, 863, 15, '1190.00'),
(646, 906, 15, '2296.00'),
(647, 911, 15, '590.00'),
(648, 953, 15, '1330.00'),
(649, 1016, 15, '1685.00'),
(650, 1110, 15, '1400.00'),
(651, 1282, 15, '2031.00'),
(652, 1302, 15, '744.00'),
(653, 1330, 15, '1040.00'),
(654, 1495, 15, '1350.00'),
(655, 1526, 15, '1120.00'),
(656, 1532, 15, '1915.00'),
(657, 1661, 15, '1479.00'),
(658, 1693, 15, '940.00'),
(659, 1695, 15, '1511.00'),
(660, 1716, 15, '987.00'),
(661, 1763, 15, '970.00'),
(662, 1767, 15, '600.00'),
(663, 1772, 15, '1170.00'),
(664, 1783, 15, '1000.00'),
(665, 1788, 15, '1900.00'),
(666, 1797, 15, '773.00'),
(667, 1823, 15, '875.00'),
(668, 1828, 15, '2730.00'),
(669, 1836, 15, '1494.00'),
(670, 1859, 15, '1039.00'),
(671, 1868, 15, '1000.00'),
(672, 1931, 15, '1700.00'),
(673, 1942, 15, '720.00'),
(674, 1965, 15, '1733.00'),
(675, 1982, 15, '2500.00'),
(676, 2034, 15, '900.00'),
(677, 2045, 15, '1100.00'),
(678, 2048, 15, '3000.00'),
(679, 2060, 15, '2350.00'),
(680, 2068, 15, '1090.00'),
(681, 2077, 15, '3300.00'),
(682, 2101, 15, '3223.00'),
(683, 2103, 15, '2815.00'),
(684, 2105, 15, '2560.00'),
(685, 2121, 15, '2352.00'),
(686, 2176, 15, '1831.00'),
(687, 2198, 15, '1200.00'),
(688, 2203, 15, '333.00'),
(689, 2206, 15, '933.00'),
(690, 2217, 15, '1006.00'),
(691, 2242, 15, '1990.00'),
(692, 2267, 15, '920.00'),
(693, 2284, 15, '1306.00'),
(694, 2317, 15, '1000.00'),
(695, 2318, 15, '1000.00'),
(696, 2328, 15, '1170.00'),
(697, 2334, 15, '847.00'),
(698, 2377, 15, '173.00'),
(699, 2389, 15, '2790.00'),
(700, 2392, 15, '1100.00'),
(701, 2394, 15, '2085.00'),
(702, 2427, 15, '3414.00'),
(703, 2433, 15, '827.00'),
(704, 2456, 15, '668.00'),
(705, 2505, 15, '2782.00'),
(706, 2516, 15, '3215.00'),
(707, 2527, 15, '1251.00'),
(708, 2543, 15, '1815.00'),
(709, 2555, 15, '600.00'),
(710, 2557, 15, '3000.00'),
(711, 2567, 15, '1600.00'),
(712, 2594, 15, '604.00'),
(713, 2607, 15, '640.00'),
(714, 2610, 15, '1400.00'),
(715, 2626, 15, '3260.00'),
(716, 2643, 15, '854.00'),
(717, 2690, 15, '1094.00'),
(718, 2733, 15, '510.00'),
(719, 2747, 15, '1430.00'),
(720, 2768, 15, '1600.00'),
(721, 2795, 15, '503.00'),
(722, 2799, 15, '870.00'),
(723, 2806, 15, '2100.00'),
(724, 2819, 15, '2855.00'),
(725, 2822, 15, '850.00'),
(726, 2830, 15, '1240.00'),
(727, 2854, 15, '3500.00'),
(728, 2870, 15, '1893.00'),
(729, 2895, 15, '1146.00'),
(730, 2900, 15, '3200.00'),
(731, 2906, 15, '200.00'),
(732, 2907, 15, '1410.00'),
(733, 2913, 15, '1629.00'),
(734, 2914, 15, '1660.00'),
(735, 2921, 15, '1750.00'),
(736, 2937, 15, '830.00'),
(737, 2939, 15, '2354.00'),
(738, 2952, 15, '2000.00'),
(739, 2961, 15, '2500.00'),
(740, 2962, 15, '3000.00'),
(741, 2964, 15, '880.00'),
(742, 2972, 15, '882.00'),
(743, 2992, 15, '925.00'),
(744, 3005, 15, '5270.00'),
(745, 3032, 15, '1490.00'),
(746, 3034, 15, '2287.00'),
(747, 3035, 15, '4369.00'),
(748, 3037, 15, '1000.00'),
(749, 3042, 15, '408.00'),
(750, 3048, 15, '4053.00'),
(751, 3049, 15, '1250.00'),
(752, 3061, 15, '1050.00'),
(753, 3088, 15, '750.00'),
(754, 3093, 15, '2821.00'),
(755, 3096, 15, '2450.00'),
(756, 3128, 15, '650.00'),
(757, 3166, 15, '3000.00'),
(758, 3169, 15, '1580.00'),
(759, 3172, 15, '781.00'),
(760, 3195, 15, '1870.00'),
(761, 3258, 15, '2200.00'),
(762, 3329, 15, '1740.00'),
(763, 3335, 15, '1400.00'),
(764, 3353, 15, '768.00'),
(765, 3359, 15, '837.00'),
(766, 3363, 15, '870.00'),
(767, 3371, 15, '1200.00'),
(768, 3381, 15, '1127.00'),
(769, 3384, 15, '1175.00'),
(770, 3385, 15, '1371.00'),
(771, 3406, 15, '1079.00'),
(772, 3438, 15, '579.00'),
(773, 3464, 15, '940.00'),
(774, 3469, 15, '112.00'),
(775, 3473, 15, '1250.00'),
(776, 3483, 15, '2440.00'),
(777, 3490, 15, '990.00'),
(778, 3499, 15, '3138.00'),
(779, 3516, 15, '1790.00'),
(780, 3519, 15, '1400.00'),
(781, 3534, 15, '800.00'),
(782, 3535, 15, '1050.00'),
(783, 3546, 15, '1674.00'),
(784, 3568, 15, '416.00'),
(785, 3569, 15, '560.00'),
(786, 3576, 15, '1015.00'),
(787, 3584, 15, '1400.00'),
(788, 3585, 15, '1765.00'),
(789, 3591, 15, '2500.00'),
(790, 3596, 15, '1580.00'),
(791, 3610, 15, '1425.00'),
(792, 3619, 15, '1400.00'),
(793, 3624, 15, '1049.00'),
(794, 3633, 15, '1350.00'),
(795, 3642, 15, '233.00'),
(796, 3645, 15, '1020.00'),
(797, 3650, 15, '2040.00'),
(798, 3656, 15, '667.00'),
(799, 3668, 15, '2051.00'),
(800, 3673, 15, '646.00'),
(801, 3679, 15, '1400.00'),
(802, 3680, 15, '1555.00'),
(803, 3682, 15, '1980.00'),
(804, 3691, 15, '967.00'),
(805, 3695, 15, '1025.00'),
(806, 3706, 15, '788.00'),
(807, 3710, 15, '687.00'),
(808, 3711, 15, '3607.00'),
(809, 3738, 15, '1502.00'),
(810, 3746, 15, '1100.00'),
(811, 3747, 15, '3460.00'),
(812, 3751, 15, '1400.00'),
(813, 3752, 15, '1500.00'),
(814, 3785, 15, '781.00'),
(815, 3786, 15, '0.00'),
(816, 3788, 15, '467.00'),
(817, 3790, 15, '3500.00'),
(818, 3792, 15, '665.00'),
(819, 3805, 15, '1120.00'),
(820, 3806, 15, '556.00'),
(821, 3812, 15, '2334.00'),
(822, 3813, 15, '799.00'),
(823, 3822, 15, '1025.00'),
(824, 3826, 15, '843.00'),
(825, 3834, 15, '493.00'),
(826, 3839, 15, '788.00'),
(827, 3843, 15, '817.00'),
(828, 3852, 15, '1190.00'),
(829, 3854, 15, '3000.00'),
(830, 3855, 15, '950.00'),
(831, 3856, 15, '900.00'),
(832, 3861, 15, '3000.00'),
(833, 3863, 15, '837.00'),
(834, 3865, 15, '1050.00'),
(835, 3871, 15, '267.00'),
(836, 3873, 15, '247.00'),
(837, 3875, 15, '1050.00'),
(838, 3876, 15, '1400.00'),
(839, 3877, 15, '2500.00'),
(840, 3878, 15, '513.00'),
(841, 3879, 15, '1487.00'),
(842, 3880, 15, '532.00'),
(843, 3881, 15, '918.00'),
(844, 3882, 15, '1250.00'),
(845, 3883, 15, '1050.00'),
(846, 3884, 15, '1580.00'),
(847, 3885, 15, '1545.00'),
(848, 3886, 15, '117.00'),
(849, 3887, 15, '150.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id_empleado` int(11) NOT NULL,
  `numero_cuenta` varchar(20) NOT NULL,
  `numero_tarjeta` varchar(20) NOT NULL,
  `descripcion_pago` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id_empleado`, `numero_cuenta`, `numero_tarjeta`, `descripcion_pago`) VALUES
(1, '1234567891234567', '0987654321234567', 'pago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `r_desc_nom_i`
--

CREATE TABLE `r_desc_nom_i` (
  `id_nomina_individual` int(11) NOT NULL,
  `id_descuento` int(11) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `r_extrasnom_i`
--

CREATE TABLE `r_extrasnom_i` (
  `id_nomina_individual` int(11) NOT NULL,
  `id_extras` int(11) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `username`, `password`) VALUES
(1, 'Administrador', 'ü\0\"âœæö¼y=çÂ3');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id_nomina_individual`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id_cargo`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id_departamento`);

--
-- Indices de la tabla `descuento`
--
ALTER TABLE `descuento`
  ADD PRIMARY KEY (`id_descuento`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`),
  ADD KEY `id_horario` (`id_horario`),
  ADD KEY `id_departamento` (`id_departamento`),
  ADD KEY `id_cargo` (`id_cargo`);

--
-- Indices de la tabla `extras`
--
ALTER TABLE `extras`
  ADD PRIMARY KEY (`id_extras`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`id_horario`);

--
-- Indices de la tabla `nomina_general`
--
ALTER TABLE `nomina_general`
  ADD PRIMARY KEY (`id_nomina_general`);

--
-- Indices de la tabla `nomina_individual`
--
ALTER TABLE `nomina_individual`
  ADD PRIMARY KEY (`id_nomina_individual`),
  ADD KEY `id_nomina_general` (`id_nomina_general`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `r_desc_nom_i`
--
ALTER TABLE `r_desc_nom_i`
  ADD KEY `id_nomina_individual` (`id_nomina_individual`),
  ADD KEY `id_descuento` (`id_descuento`);

--
-- Indices de la tabla `r_extrasnom_i`
--
ALTER TABLE `r_extrasnom_i`
  ADD KEY `id_nomina_individual` (`id_nomina_individual`),
  ADD KEY `id_extras` (`id_extras`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id_departamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `descuento`
--
ALTER TABLE `descuento`
  MODIFY `id_descuento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `extras`
--
ALTER TABLE `extras`
  MODIFY `id_extras` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `id_horario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `nomina_general`
--
ALTER TABLE `nomina_general`
  MODIFY `id_nomina_general` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `nomina_individual`
--
ALTER TABLE `nomina_individual`
  MODIFY `id_nomina_individual` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=850;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id_horario`),
  ADD CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`),
  ADD CONSTRAINT `empleado_ibfk_3` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`);

--
-- Filtros para la tabla `nomina_individual`
--
ALTER TABLE `nomina_individual`
  ADD CONSTRAINT `nomina_individual_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  ADD CONSTRAINT `nomina_individual_ibfk_2` FOREIGN KEY (`id_nomina_general`) REFERENCES `nomina_general` (`id_nomina_general`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`);

--
-- Filtros para la tabla `r_desc_nom_i`
--
ALTER TABLE `r_desc_nom_i`
  ADD CONSTRAINT `r_desc_nom_i_ibfk_1` FOREIGN KEY (`id_nomina_individual`) REFERENCES `nomina_individual` (`id_nomina_individual`),
  ADD CONSTRAINT `r_desc_nom_i_ibfk_2` FOREIGN KEY (`id_descuento`) REFERENCES `descuento` (`id_descuento`);

--
-- Filtros para la tabla `r_extrasnom_i`
--
ALTER TABLE `r_extrasnom_i`
  ADD CONSTRAINT `r_extrasnom_i_ibfk_1` FOREIGN KEY (`id_nomina_individual`) REFERENCES `nomina_individual` (`id_nomina_individual`),
  ADD CONSTRAINT `r_extrasnom_i_ibfk_2` FOREIGN KEY (`id_extras`) REFERENCES `extras` (`id_extras`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
