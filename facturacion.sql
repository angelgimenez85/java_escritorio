-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 22-08-2018 a las 20:12:11
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `facturacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` varchar(10) NOT NULL,
  `idTipo` int(11) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `idCiudad` int(11) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `idTipo`, `nombres`, `apellidos`, `direccion`, `telefono`, `idCiudad`, `fechaNacimiento`, `fechaIngreso`) VALUES
('1', 6, 'Juan Carlos', 'Zuluaga Cardona', 'Calle Luna Calle Sol', '233 4455', 2, '1974-09-25', '2012-12-19'),
('2', 3, 'Maria', 'González', 'Calle Rosa con Amarillo', '233 4333', -1, '1980-12-14', '2012-12-19'),
('3', 1, 'Jaime', 'Vasquez', 'Avenida Guerrero', '233 4433', 5, '1976-12-15', '2012-12-14'),
('4', 4, 'Noemi', 'Cambell', 'Monaco', '2344 3332', 5, '1986-12-16', '2012-12-19');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

CREATE TABLE `detallefactura` (
  `idFactura` int(11) NOT NULL,
  `idLinea` int(11) NOT NULL,
  `idProducto` varchar(12) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detallefactura`
--

INSERT INTO `detallefactura` (`idFactura`, `idLinea`, `idProducto`, `descripcion`, `precio`, `cantidad`) VALUES
(1, 1, '10', 'Fabuloso x 500 ml', 4200, 6),
(1, 2, '1', 'Coca Cola x 350 Ml', 1300, 3),
(1, 3, '2', 'Pan Bimbo x 500 Gr', 3500, 12),
(1, 4, '3', 'Leche Colanta', 1900, 10),
(2, 1, '1', 'Coca Cola x 350 Ml', 1300, 3),
(2, 2, '2', 'Pan Bimbo x 500 Gr', 3500, 3),
(2, 3, '3', 'Leche Colanta', 1900, 6),
(2, 4, '10', 'Fabuloso x 500 ml', 4200, 7),
(3, 1, '1', 'Coca Cola x 350 Ml', 1300, 3),
(3, 2, '10', 'Fabuloso x 500 ml', 4200, 1),
(3, 3, '4', 'Salchichon Zenu x 500 Gr', 5000, 1),
(4, 1, '1', 'Coca Cola x 350 Ml', 1300, 3),
(4, 2, '3', 'Leche Colanta', 1900, 3),
(5, 1, '1', 'Coca Cola x 350 Ml', 1300, 2),
(5, 2, '3', 'Leche Colanta', 1900, 3),
(6, 0, '1', 'Coca Cola x 350 Ml', 1300, 12),
(6, 1, '2', 'Pan Bimbo x 500 Gr', 3500, 12),
(6, 2, '10', 'Fabuloso x 500 ml', 4200, 5),
(6, 3, '4', 'Salchichon Zenu x 500 Gr', 5000, 5),
(7, 0, '1', 'Coca Cola x 350 Ml', 1300, 1),
(7, 1, '2', 'Pan Bimbo x 500 Gr', 3500, 2),
(8, 0, '3', 'Leche Colanta', 1900, 12),
(8, 1, '2', 'Pan Bimbo x 500 Gr', 3500, 23),
(8, 2, '4', 'Salchichon Zenu x 500 Gr', 5000, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefacturatmp`
--

CREATE TABLE `detallefacturatmp` (
  `idProducto` varchar(12) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL,
  `idCliente` varchar(10) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`idFactura`, `idCliente`, `fecha`) VALUES
(1, '1', '2012-12-15'),
(2, '2', '2012-12-18'),
(3, '3', '2012-12-19'),
(4, '1', '2012-12-20'),
(5, '1', '2012-12-20'),
(6, '4', '2012-12-21'),
(7, '4', '2018-01-29'),
(8, '1', '2018-01-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` varchar(12) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  `idIVA` int(11) NOT NULL,
  `notas` text,
  `foto` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `descripcion`, `precio`, `idIVA`, `notas`, `foto`) VALUES
('1', 'Coca Cola x 350 Ml', 1300, 1, 'La mejor calidad', ''),
('2', 'Pan Bimbo x 500 Gr', 3500, 0, 'Simpre sueva y esponjoso', 'PanBimbo.jpg'),
('3', 'Leche Colanta', 1900, 1, 'Producto en oferta', ''),
('10', 'Fabuloso x 500 ml', 4200, 2, 'Ricol y oloroso', 'Fabuloso.jpg'),
('4', 'Salchichon Zenu x 500 Gr', 5000, 1, 'Sabe rico con limon', 'SalchichonZenu.jpg'),
('5', 'Salame Milán', 2500, 2, 'Producto regional', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` varchar(10) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `foto` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombres`, `apellidos`, `clave`, `idPerfil`, `foto`) VALUES
('zulu', 'Juan Carlos', 'Zuluaga Cardona', '123', 1, ''),
('pepe', 'Pedro Alfonso', 'Infante', '3030', 2, ''),
('vale', 'Valery Jennifer', 'Dominguez', '2020', 1, ''),
('rosa', 'María Rosa', 'Martinez', '123', 2, ''),
('ronal', 'Ronal', 'Hayazo', '123', 2, 'Ronal.jpg'),
('carla', 'Carla', 'Bruni', '123', 2, ''),
('alvaro', 'Alvaro', 'Uribe', '123', 1, ''),
('angelino', 'Angelino', 'Garzon Lopez', '123', 2, ''),
('angel', 'Angel', 'Giménez', 'pass', 1, 'mi_foto.jpg'),
('anibal', 'Anibal Alejandro', 'Pérez', '123', 1, ''),
('augusto', 'Augusto ', 'Salame', '123', 1, '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD PRIMARY KEY (`idFactura`,`idLinea`);

--
-- Indices de la tabla `detallefacturatmp`
--
ALTER TABLE `detallefacturatmp`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idFactura`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
