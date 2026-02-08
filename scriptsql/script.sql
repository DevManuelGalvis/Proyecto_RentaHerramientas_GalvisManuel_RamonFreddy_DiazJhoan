CREATE DATABASE IF NOT EXISTS renta_equipos;

USE renta_equipos;

CREATE TABLE `usuarios` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `correo` varchar(255) NOT NULL,
    `documento` varchar(80) NOT NULL,
    `nombre` varchar(80) NOT NULL,
    `password` varchar(255) NOT NULL,
    `rol` enum('ADMINISTRADOR','CLIENTE','PROVEEDOR') NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKcdmw5hxlfj78uf4997i3qyyw5` (`correo`),
    UNIQUE KEY `UK51x567hg32si9nj9gjcbabcnm` (`documento`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `categoria_herramientas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `clientes` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `direccion` varchar(255) NOT NULL,
    `telefono` varchar(30) NOT NULL,
    `usuario_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK96x1n5ut15ns1xhkm87y7qhnd` (`usuario_id`),
    CONSTRAINT `FKk6iwsq3kts1bblivkjy6epajx` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `proveedores` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `direccion` varchar(255) NOT NULL,
   `nombre_empresa` varchar(100) NOT NULL,
   `telefono` varchar(30) NOT NULL,
   `usuario_id` bigint NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `UKpeyto1ojcttpte898wjwqjsfj` (`usuario_id`),
   CONSTRAINT `FKtduja1lqu2fr99ud9289xcfqe` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `herramientas` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `descripcion` varchar(255) NOT NULL,
    `estado` enum('ALQUILADA','DAÑADA','DISPONIBLE','MANTENIMIENTO') NOT NULL,
    `nombre` varchar(90) NOT NULL,
    `precio` decimal(10,2) NOT NULL,
    `categoria_id` bigint NOT NULL,
    `proveedor_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKfk6nrr8hxyacg5bqbn51o2h0j` (`categoria_id`),
    KEY `FKksrw997r6plty4sixxyjcickl` (`proveedor_id`),
    CONSTRAINT `FKfk6nrr8hxyacg5bqbn51o2h0j` FOREIGN KEY (`categoria_id`) REFERENCES `categoria_herramientas` (`id`),
    CONSTRAINT `FKksrw997r6plty4sixxyjcickl` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reservas` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `estado` enum('CANCELADA','DEVUELTA','EN_CURSO','RESERVADA') NOT NULL,
    `fecha_fin` datetime(6) NOT NULL,
    `fecha_inicio` datetime(6) NOT NULL,
    `total` decimal(10,2) NOT NULL,
    `cliente_id` bigint NOT NULL,
    `herramienta_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKpays115gahfu3ffuywded1xqt` (`cliente_id`),
    KEY `FK3si71ogl7n3hqgsx79l2u4suf` (`herramienta_id`),
    CONSTRAINT `FK3si71ogl7n3hqgsx79l2u4suf` FOREIGN KEY (`herramienta_id`) REFERENCES `herramientas` (`id`),
    CONSTRAINT `FKpays115gahfu3ffuywded1xqt` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pagos` (
 `id` bigint NOT NULL AUTO_INCREMENT,
 `estado_pago` enum('PAGADO','PENDIENTE') DEFAULT NULL,
 `fecha_pago` datetime(6) NOT NULL,
 `metodo_pago` enum('EFECTIVO','TARJETA','TRANSFERENCIA') NOT NULL,
 `monto` decimal(10,2) NOT NULL,
 `reserva_id` bigint NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `UKpn8lfo4dddgw287xi57lul480` (`reserva_id`),
 CONSTRAINT `FKrd490715qtq2imjqrn0rwyhsl` FOREIGN KEY (`reserva_id`) REFERENCES `reservas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `devoluciones` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `estado_equipo` enum('BUENO','DAÑADO') NOT NULL,
    `fecha_devolucion` datetime(6) NOT NULL,
    `observaciones` varchar(255) NOT NULL,
    `reserva_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKr8nmxva41u1kgwnkbmyo2qkll` (`reserva_id`),
    CONSTRAINT `FKopq6b4emmwhw89phlqtxouy4l` FOREIGN KEY (`reserva_id`) REFERENCES `reservas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `facturas` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `fecha_emision` datetime(6) NOT NULL,
    `numero_factura` varchar(30) NOT NULL,
    `total` decimal(10,2) NOT NULL,
    `pago_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKm3ybkrgx2m3tj1tk6rp7sqjxt` (`numero_factura`),
    UNIQUE KEY `UKdomubdc5xuqh8s3nauui00ly4` (`pago_id`),
    CONSTRAINT `FKniyc4ntc4e02vcpyyfqku2cyj` FOREIGN KEY (`pago_id`) REFERENCES `pagos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `imagenes_herramientas` (
 `id` bigint NOT NULL AUTO_INCREMENT,
 `url_imagen` text,
 `herramienta_id` bigint NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `UKhspir6a8kyi322r6wrhhqooue` (`herramienta_id`),
 CONSTRAINT `FKhd1gsdb513swi8avhq8g9vvwk` FOREIGN KEY (`herramienta_id`) REFERENCES `herramientas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reporte_incidencias` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `costo_reparacion` decimal(10,2) NOT NULL,
   `descripcion` varchar(255) NOT NULL,
   `fecha_reporte` datetime(6) NOT NULL,
   `herramienta_id` bigint NOT NULL,
   `proveedor_id` bigint NOT NULL,
   PRIMARY KEY (`id`),
   KEY `FKcp8t8r4obv9hbx5fxd0qpvs3e` (`herramienta_id`),
   KEY `FKbqmbcjn4tfqg511bmwrku5xym` (`proveedor_id`),
   CONSTRAINT `FKbqmbcjn4tfqg511bmwrku5xym` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedores` (`id`),
   CONSTRAINT `FKcp8t8r4obv9hbx5fxd0qpvs3e` FOREIGN KEY (`herramienta_id`) REFERENCES `herramientas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;