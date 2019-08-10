-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-08-2019 a las 20:52:23
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.19

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

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarPago` ()  begin
select * from pago;
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarPago` (IN `id` INT)  begin
delete from pago
where id_empleado=id;
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarExtras` (IN `descripcion_extras` VARCHAR(100))  begin
insert into extras (descripcion_extras)
values (descripcion_extras);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarHorario` (IN `hora_llegada` TIME, IN `hora_salida` TIME, IN `turno` VARCHAR(50))  begin
insert into horario (hora_llegada,hora_salida,turno)
values (hora_llegada,hora_salida,turno);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarPago` (IN `id_empleado` INT(11), IN `numero_cuenta` BIGINT(16), IN `numero_tarjeta` BIGINT(16), IN `descripcion_pago` VARCHAR(50))  begin
insert into pago (id_empleado,numero_cuenta,numero_tarjeta,descripcion_pago)
values (id_empleado,numero_cuenta,numero_tarjeta,descripcion_pago);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_Empleado` (IN `id_empleado` INT, IN `id_horario` INT, IN `id_cargo` INT, IN `nombre` VARCHAR(50), IN `apellido_paterno` VARCHAR(50), IN `apellido_materno` VARCHAR(50), IN `curp` VARCHAR(50), IN `id_departamento` INT, IN `direccion` VARCHAR(100), IN `salario` DOUBLE(8,2), IN `sexo` INT, IN `estatus` INT, IN `num_seg_social` INT, IN `rfc` VARCHAR(14), IN `gratificacion` DOUBLE(10,2))  begin
insert into empleado(id_empleado,id_horario,id_cargo,nombre,apellido_paterno,apellido_materno,curp,id_departamento,direccion,salario,sexo,
estatus,num_seg_social,rfc,gratificacion)
values(id_empleado,id_horario,id_cargo,nombre,apellido_paterno,apellido_materno,curp,id_departamento,direccion,salario,sexo,
estatus,num_seg_social,rfc,gratificacion);
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarEmpleado` (IN `id_horario` INT, IN `id_cargo` INT, IN `nombre` VARCHAR(50), IN `apellido_paterno` VARCHAR(50), IN `apellido_materno` VARCHAR(50), IN `curp` VARCHAR(50), IN `id_departamento` INT, IN `direccion` VARCHAR(100), IN `salario` DOUBLE(8,2), IN `sexo` INT, IN `estatus` INT, IN `num_seg_social` INT, IN `rfc` VARCHAR(14), IN `gratificacion` DOUBLE(10,2), IN `id` INT)  begin
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
gratificacion=gratificacion
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarPago` (IN `numero_cuenta` BIGINT(16), IN `numero_tarjeta` BIGINT(16), IN `descripcion_pago` VARCHAR(50))  begin
update pago set hora_llegada = hora_llegada , hora_salida = hora_salida , turno = turno
where id_descuento=id;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `id_asistencia` int(11) NOT NULL,
  `dia1` char(1) DEFAULT NULL,
  `dia2` char(1) DEFAULT NULL,
  `dia3` char(1) DEFAULT NULL,
  `dia4` char(1) DEFAULT NULL,
  `dia5` char(1) DEFAULT NULL,
  `dia6` char(1) DEFAULT NULL,
  `dia7` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`id_asistencia`, `dia1`, `dia2`, `dia3`, `dia4`, `dia5`, `dia6`, `dia7`) VALUES
(1, '1', '2', '3', '4', '5', '6', '7'),
(2, '1', '2', '3', '4', '5', '6', '7');

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
(2, 'Empleado');

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
(2, 'logistica', 10);

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
(1, 'Retardo'),
(2, 'Retardo');

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
  `rfc` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `id_horario`, `id_cargo`, `nombre`, `apellido_paterno`, `apellido_materno`, `curp`, `id_departamento`, `direccion`, `salario`, `gratificacion`, `sexo`, `estatus`, `num_seg_social`, `rfc`) VALUES
(1, 2, 2, 'Gonzalo', 'Ramirez', 'Hernandez', 'RAHA900214HPLMRL09', 1, 'Calle san jose numero 711 colonia ricardo flores magon', 4500.00, 300.45, 1, 1, 154321, 'RAHA900214HPL'),
(2, 2, 2, 'Alfredo', 'Soto', 'Perez', 'MASG000215HPLRNNA8', 1, 'Calle Atlixco', 4000.00, 300.45, 1, 1, 154321, 'GAMS900214HPL');

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
(2, 'horas extras');

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
  `fecha_inicio` int(11) NOT NULL,
  `fecha_fin` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `total_extras` double(7,2) DEFAULT NULL,
  `total_desc` double(7,2) DEFAULT NULL,
  `total_nom` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina_individual`
--

CREATE TABLE `nomina_individual` (
  `id_nomina_individual` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_nomina_general` int(11) NOT NULL,
  `id_asistencia` int(11) NOT NULL,
  `total_nom_ind` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id_empleado` int(11) NOT NULL,
  `numero_cuenta` bigint(16) NOT NULL,
  `numero_tarjeta` bigint(16) NOT NULL,
  `descripcion_pago` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id_empleado`, `numero_cuenta`, `numero_tarjeta`, `descripcion_pago`) VALUES
(1, 1234567891234567, 987654321234567, 'pago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `r_asis_emp`
--

CREATE TABLE `r_asis_emp` (
  `id_asistencia` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `r_desc_nom_i`
--

CREATE TABLE `r_desc_nom_i` (
  `id_nomina_individual` int(11) NOT NULL,
  `id_descuento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `r_extras_nom_i`
--

CREATE TABLE `r_extras_nom_i` (
  `id_extras` int(11) NOT NULL,
  `id_nomina_individual` int(11) NOT NULL
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
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id_asistencia`);

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
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_nomina_general` (`id_nomina_general`),
  ADD KEY `id_asistencia` (`id_asistencia`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `r_asis_emp`
--
ALTER TABLE `r_asis_emp`
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_asistencia` (`id_asistencia`);

--
-- Indices de la tabla `r_desc_nom_i`
--
ALTER TABLE `r_desc_nom_i`
  ADD KEY `id_descuento` (`id_descuento`),
  ADD KEY `id_nomina_individual` (`id_nomina_individual`);

--
-- Indices de la tabla `r_extras_nom_i`
--
ALTER TABLE `r_extras_nom_i`
  ADD KEY `id_extras` (`id_extras`),
  ADD KEY `id_nomina_individual` (`id_nomina_individual`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `id_asistencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  MODIFY `id_descuento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `extras`
--
ALTER TABLE `extras`
  MODIFY `id_extras` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `id_horario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `nomina_general`
--
ALTER TABLE `nomina_general`
  MODIFY `id_nomina_general` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `nomina_individual`
--
ALTER TABLE `nomina_individual`
  MODIFY `id_nomina_individual` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `nomina_individual_ibfk_2` FOREIGN KEY (`id_nomina_general`) REFERENCES `nomina_general` (`id_nomina_general`),
  ADD CONSTRAINT `nomina_individual_ibfk_3` FOREIGN KEY (`id_asistencia`) REFERENCES `asistencia` (`id_asistencia`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`);

--
-- Filtros para la tabla `r_asis_emp`
--
ALTER TABLE `r_asis_emp`
  ADD CONSTRAINT `r_asis_emp_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  ADD CONSTRAINT `r_asis_emp_ibfk_2` FOREIGN KEY (`id_asistencia`) REFERENCES `asistencia` (`id_asistencia`);

--
-- Filtros para la tabla `r_desc_nom_i`
--
ALTER TABLE `r_desc_nom_i`
  ADD CONSTRAINT `r_desc_nom_i_ibfk_1` FOREIGN KEY (`id_descuento`) REFERENCES `descuento` (`id_descuento`),
  ADD CONSTRAINT `r_desc_nom_i_ibfk_2` FOREIGN KEY (`id_nomina_individual`) REFERENCES `nomina_individual` (`id_nomina_individual`);

--
-- Filtros para la tabla `r_extras_nom_i`
--
ALTER TABLE `r_extras_nom_i`
  ADD CONSTRAINT `r_extras_nom_i_ibfk_1` FOREIGN KEY (`id_extras`) REFERENCES `extras` (`id_extras`),
  ADD CONSTRAINT `r_extras_nom_i_ibfk_2` FOREIGN KEY (`id_nomina_individual`) REFERENCES `nomina_individual` (`id_nomina_individual`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
