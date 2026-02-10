
USE renta_equipos;


-- Password 123456789
INSERT INTO usuarios (correo, documento, nombre, password, rol) VALUES
('admin@rentas.com', '1001', 'Freddy Ramon', '$2a$12$CBIpfydwJbgwUWiLh7G9zOEdwjOUuodhh8b/WqTkyb52K7rmBuUGG', 'ADMINISTRADOR'),
('carlos@mail.com', '2001', 'Carlos Mantilla', '$2a$12$vk6dBntp1AU8SYRYfYXE8OIFVNJEuW9DsqTB7yigk5Mmzn4yViH5.', 'CLIENTE'),
('ana@mail.com', '2002', 'Ana Villamizar', '$2a$12$uC6D3WEqMz1UTjqBBfYg6eJSX9X/cjB3D5QD6WJWZ7zpi7jFmv/dy', 'CLIENTE'),
('luis@mail.com', '2003', 'Luis Garcia', '$2a$12$rcAx3BS3KFJhW6s0CY0FAOKG4JBWCbIa1R9cL5on5EdIN7qChU/YW', 'CLIENTE'),
('marta@mail.com', '2004', 'Marta Lopez', '$2a$12$JQIRInGUcMaOgfm.uL0zi.vn9juxjTOFO75t6UD6TE.vZsKa8kyx6', 'CLIENTE'),
('juan@mail.com', '2005', 'Juan Perez', '$2a$12$6SvVTbgS2XT/gUY7NlnJm.5lV5O0ts1ijU2V5p.TKoY4E2d92uTjK', 'CLIENTE'),
('pedro@mail.com', '2006', 'Pedro Picapiedra', '$2a$12$vODUiRRo97uA0ZdcjLqd5ekypF3S87bAX.FAuOA20Amg3qE4b.j7O', 'CLIENTE'),
('pablo@mail.com', '2007', 'Pablo Marmol', '$2a$12$fZx1LBaqA4gMe5lYdPNaYOpvJocurmIFSpiF/oqtPPfcRAaPpJaB2', 'CLIENTE'),
('vilma@mail.com', '2008', 'Vilma Palma', '$2a$12$p/J5pMiJU6TCP6FQCxa9oONfRlY6xOqaLvLIlPAkRYWtrEubbapDO', 'CLIENTE'),
('betty@mail.com', '2009', 'Betty Boop', '$2a$12$beNuZHS6g8ggH6l3SiNC4uOUfakr08WNh6IGhpvzdhUAlKC1yj7M6', 'CLIENTE'),
('homero@mail.com', '2010', 'Homero Simpson', '$2a$12$beNuZHS6g8ggH6l3SiNC4uOUfakr08WNh6IGhpvzdhUAlKC1yj7M6', 'CLIENTE'),
('ferreteria_paco@mail.com', '3001', 'Ferretería Paco', '$2a$12$beNuZHS6g8ggH6l3SiNC4uOUfakr08WNh6IGhpvzdhUAlKC1yj7M6', 'PROVEEDOR'),
('equipos_norte@mail.com', '3002', 'Equipos del Norte', '$2a$12$g9by3s0GsmWADYw2E0uOi.sL3FFzG2cYr.rSF6hDjLdyPxQ.nOJ3m', 'PROVEEDOR'),
('constru_renta@mail.com', '3003', 'Constru Renta', '$2a$12$RtJ6OBem1nhyhYcWVG6Ji.IbCx3OOG0xfGozS45Yfh0jfhqELIsju', 'PROVEEDOR'),
('herramientas_total@mail.com', '3004', 'Herramientas Total', '$2a$12$2mUzc5Ic8RT1EiodtXH/v./acOk7DA6K4iZy7Veehiw8BWyl42gvS', 'PROVEEDOR'),
('maquinas_plus@mail.com', '3005', 'Maquinas Plus', '$2a$12$eGYD5e4UVMVn1Tqkofhks.EtUYIC/w8UNygSTX5lJjv53nND3H5cq', 'PROVEEDOR'),
('renta_facil@mail.com', '3006', 'Renta Facil SAS', '$2a$12$Z2e.0ICuJD01XMs4TkI59O6k.5dRPQmdz10Wx8q3uMAVaFPZQe8oC', 'PROVEEDOR'),
('todo_obra@mail.com', '3007', 'Todo Obra Ltda', '$2a$12$El9M.noTAjVmJTjhmZDFRuvmxnNd.WDrm/6MQkb/J8X7ej8Py26NG', 'PROVEEDOR'),
('ferre_industrial@mail.com', '3008', 'Ferre Industrial', '$2a$12$6QleeLZJHdgBMez.NsaDa.fRm2pjM3BV3mmDC6r0LROTPP2bV4SCS', 'PROVEEDOR'),
('super_rentas@mail.com', '3009', 'Super Rentas', '$2a$12$VkY6RhYdPmmZib02s0H3fef4k3KZRS4iY4GzP4niV39ponA.XrScq', 'PROVEEDOR');


INSERT INTO categoria_herramientas (nombre) VALUES
('Herramientas eléctricas'),
('Construcción pesada'),
('Carpintería'),
('Jardinería'),
('Pintura y acabados'),
('Equipos industriales');

INSERT INTO clientes (direccion, telefono, usuario_id) VALUES
('Calle 10 #5-20', '3101234567', 2), ('Av 5 #11-30', '3112345678', 3),
('Calle 2 #4-15', '3123456789', 4), ('Carrera 8 #12-40', '3134567890', 5),
('Calle 20 #1-10', '3145678901', 6), ('Calle 50 #10-20', '3156789012', 7),
('Av Sur #22-10', '3167890123', 8), ('Transversal 9 #4-5', '3178901234', 9),
('Calle 80 #15-30', '3189012345', 10), ('Carrera 15 #100-1', '3190123456', 11),
('Diagonal 1 #1-1', '3201234567', 1), ('Manzana A Casa 5', '3212345678', 12),
('Bulevar Central', '3223456789', 13), ('Vía Principal 4', '3234567890', 14),
('Calle del Sol', '3245678901', 15), ('Calle de la Luna', '3256789012', 16),
('Carrera 4 #20-10', '3267890123', 17), ('Calle 100 #10-10', '3278901234', 18),
('Av 1 #1-1', '3289012345', 19), ('Calle Final', '3290123456', 20);

INSERT INTO proveedores (direccion, nombre_empresa, telefono, usuario_id) VALUES
('Zona Industrial Lote 1', 'Ferretería Paco SAS', '60755511', 12),
('Calle 70 #10-05', 'Equipos del Norte Ltda', '60755522', 13),
('Carrera 5 #45-10', 'Constru Renta Bogota', '60755533', 14),
('Av Bolivar 123', 'Herramientas Total', '60755544', 15),
('Parque Industrial 2', 'Maquinas Plus Inc', '60755555', 16),
('Av 0 #10-20', 'Renta Facil SAS', '60755566', 17),
('Calle 13 #13-13', 'Todo Obra Ltda', '60755577', 18),
('Carrera 20 #40-50', 'Ferre Industrial', '60755588', 19),
('Diagonal 5 #2-1', 'Super Rentas', '60755599', 20),
('Calle 11 #11-1', 'Prov 10', '60755510', 1),
('Calle 12 #12-2', 'Prov 11', '60755511', 2),
('Calle 13 #13-3', 'Prov 12', '60755512', 3),
('Calle 14 #14-4', 'Prov 13', '60755513', 4),
('Calle 15 #15-5', 'Prov 14', '60755514', 5),
('Calle 16 #16-6', 'Prov 15', '60755515', 6),
('Calle 17 #17-7', 'Prov 16', '60755516', 7),
('Calle 18 #18-8', 'Prov 17', '60755517', 8),
('Calle 19 #19-9', 'Prov 18', '60755518', 9),
('Calle 20 #20-0', 'Prov 19', '60755519', 10),
('Calle 21 #21-1', 'Prov 20', '60755520', 11);

INSERT INTO herramientas (descripcion, estado, nombre, precio, stock, categoria_id, proveedor_id) VALUES
('Taladro percutor 1/2', 'DISPONIBLE', 'Taladro Bosch', 45000.00, 10, 1, 1),
('Sierra circular 7-1/4', 'DISPONIBLE', 'Sierra DeWalt', 55000.00, 5, 3, 1),
('Martillo demoledor 15kg', 'MANTENIMIENTO', 'Martillo Makita', 120000.00, 2, 2, 2),
('Hidrolavadora 2000 PSI', 'DISPONIBLE', 'Karcher K4', 60000.00, 4, 6, 3),
('Andamio tubular 1.5m', 'ALQUILADA', 'Andamio Estándar', 15000.00, 20, 2, 2),
('Compresor de aire 50L', 'DISPONIBLE', 'Compresor Schulz', 80000.00, 3, 6, 3),
('Nivel láser 360', 'DISPONIBLE', 'Nivel Huepar', 35000.00, 7, 1, 4),
('Mezcladora de concreto', 'DISPONIBLE', 'Mezcladora 1HP', 150000.00, 2, 2, 4),
('Motosierra de gasolina', 'DISPONIBLE', 'Stihl MS 170', 95000.00, 2, 4, 1),
('Pulidora 4-1/2 850W', 'DISPONIBLE', 'Pulidora Stanley', 30000.00, 12, 1, 2),
('Pistola de calor 1800W', 'DISPONIBLE', 'Pistola Black+Decker', 20000.00, 8, 5, 5),
('Vibrador de concreto', 'DISPONIBLE', 'Vibrador 2HP', 70000.00, 3, 2, 6),
('Cortagrama eléctrica', 'ALQUILADA', 'Husqvarna 128LD', 45000.00, 4, 4, 7),
('Escalera extensión 7m', 'DISPONIBLE', 'Escalera Cuprum', 25000.00, 15, 2, 8),
('Soldador Inverter 200A', 'DISPONIBLE', 'Soldador Lincoln', 70000.00, 6, 1, 9),
('Bomba sumergible 1HP', 'MANTENIMIENTO', 'Bomba Pedrollo', 55000.00, 3, 6, 5),
('Cepillo eléctrico', 'DISPONIBLE', 'Cepillo Makita', 40000.00, 10, 3, 6),
('Rotomartillo SDS Plus', 'DISPONIBLE', 'Rotomartillo Hilti', 90000.00, 4, 1, 7),
('Aspiradora Industrial', 'DISPONIBLE', 'Aspiradora Ridgid', 40000.00, 6, 6, 8),
('Torre de iluminación', 'ALQUILADA', 'Torre Generac', 300000.00, 1, 6, 9);


INSERT INTO reservas (estado, fecha_fin, fecha_inicio, total, cliente_id, herramienta_id) VALUES
('DEVUELTA', '2026-02-05', '2026-02-01', 180000.00, 1, 1),
('EN_CURSO', '2026-02-15', '2026-02-09', 110000.00, 2, 2),
('RESERVADA', '2026-02-12', '2026-02-11', 60000.00, 3, 4),
('DEVUELTA', '2026-02-03', '2026-02-02', 15000.00, 4, 5),
('EN_CURSO', '2026-02-20', '2026-02-08', 960000.00, 5, 3),
('CANCELADA', '2026-02-05', '2026-02-04', 80000.00, 1, 6),
('DEVUELTA', '2026-01-30', '2026-01-28', 70000.00, 2, 7),
('RESERVADA', '2026-02-14', '2026-02-13', 95000.00, 3, 9),
('EN_CURSO', '2026-02-11', '2026-02-09', 50000.00, 4, 10),
('RESERVADA', '2026-02-18', '2026-02-16', 80000.00, 5, 8),
('DEVUELTA', '2026-02-10', '2026-02-08', 40000.00, 6, 11),
('EN_CURSO', '2026-02-20', '2026-02-10', 1500000.00, 7, 12),
('RESERVADA', '2026-02-25', '2026-02-22', 135000.00, 8, 13),
('DEVUELTA', '2026-02-05', '2026-02-01', 100000.00, 9, 14),
('EN_CURSO', '2026-02-18', '2026-02-12', 420000.00, 10, 15),
('CANCELADA', '2026-02-05', '2026-02-04', 55000.00, 1, 16),
('DEVUELTA', '2026-02-10', '2026-02-08', 60000.00, 2, 17),
('RESERVADA', '2026-02-28', '2026-02-25', 270000.00, 3, 18),
('EN_CURSO', '2026-02-15', '2026-02-10', 200000.00, 4, 19),
('RESERVADA', '2026-03-05', '2026-03-01', 1200000.00, 5, 20);

-- PAGOS
INSERT INTO pagos (estado_pago, fecha_pago, metodo_pago, monto, reserva_id) VALUES
('PAGADO', '2026-02-01', 'EFECTIVO', 180000.00, 1), ('PENDIENTE', '2026-02-09', 'TRANSFERENCIA', 110000.00, 2),
('PAGADO', '2026-02-11', 'TARJETA', 60000.00, 3), ('PAGADO', '2026-02-02', 'EFECTIVO', 15000.00, 4),
('PENDIENTE', '2026-02-08', 'TRANSFERENCIA', 960000.00, 5), ('PENDIENTE', '2026-02-04', 'TARJETA', 80000.00, 6),
('PAGADO', '2026-01-28', 'TRANSFERENCIA', 70000.00, 7), ('PAGADO', '2026-02-13', 'EFECTIVO', 95000.00, 8),
('PENDIENTE', '2026-02-09', 'TRANSFERENCIA', 50000.00, 9), ('PENDIENTE', '2026-02-16', 'TARJETA', 80000.00, 10),
('PAGADO', '2026-02-08', 'EFECTIVO', 40000.00, 11), ('PENDIENTE', '2026-02-10', 'TRANSFERENCIA', 1500000.00, 12),
('PAGADO', '2026-02-22', 'TARJETA', 135000.00, 13), ('PAGADO', '2026-02-01', 'EFECTIVO', 100000.00, 14),
('PENDIENTE', '2026-02-12', 'TRANSFERENCIA', 420000.00, 15), ('PENDIENTE', '2026-02-04', 'TARJETA', 55000.00, 16),
('PAGADO', '2026-02-08', 'TRANSFERENCIA', 60000.00, 17), ('PAGADO', '2026-02-25', 'EFECTIVO', 270000.00, 18),
('PENDIENTE', '2026-02-10', 'TRANSFERENCIA', 200000.00, 19), ('PENDIENTE', '2026-03-01', 'TARJETA', 1200000.00, 20);

-- FACTURAS
INSERT INTO facturas (fecha_emision, numero_factura, total, pago_id) VALUES
('2026-02-01', 'FAC-001', 180000.00, 1), ('2026-02-11', 'FAC-002', 60000.00, 3),
('2026-02-02', 'FAC-003', 15000.00, 4), ('2026-01-28', 'FAC-004', 70000.00, 7),
('2026-02-13', 'FAC-005', 95000.00, 8), ('2026-02-08', 'FAC-006', 40000.00, 11),
('2026-02-22', 'FAC-007', 135000.00, 13), ('2026-02-01', 'FAC-008', 100000.00, 14),
('2026-02-08', 'FAC-009', 60000.00, 17), ('2026-02-25', 'FAC-010', 270000.00, 18),
('2026-02-26', 'FAC-011', 110000.00, 2), ('2026-02-27', 'FAC-012', 960000.00, 5),
('2026-02-28', 'FAC-013', 80000.00, 6), ('2026-03-01', 'FAC-014', 50000.00, 9),
('2026-03-02', 'FAC-015', 80000.00, 10), ('2026-03-03', 'FAC-016', 1500000.00, 12),
('2026-03-04', 'FAC-017', 420000.00, 15), ('2026-03-05', 'FAC-018', 55000.00, 16),
('2026-03-06', 'FAC-019', 200000.00, 19), ('2026-03-07', 'FAC-020', 1200000.00, 20);

-- DEVOLUCIONES
INSERT INTO devoluciones (estado_equipo, fecha_devolucion, observaciones, reserva_id) VALUES
('BUENO', '2026-02-05', 'Todo ok', 1), ('BUENO', '2026-02-03', 'Limpio', 4),
('DAÑADO', '2026-01-30', 'Cable', 7), ('BUENO', '2026-02-10', 'OK', 11),
('BUENO', '2026-02-05', 'Perfecto', 14), ('BUENO', '2026-02-10', 'OK', 17),
('DAÑADO', '2026-02-15', 'Raspas', 2), ('BUENO', '2026-02-16', 'OK', 3),
('BUENO', '2026-02-17', 'OK', 5), ('BUENO', '2026-02-18', 'OK', 6),
('BUENO', '2026-02-19', 'OK', 8), ('BUENO', '2026-02-20', 'OK', 9),
('BUENO', '2026-02-21', 'OK', 10), ('BUENO', '2026-02-22', 'OK', 12),
('BUENO', '2026-02-23', 'OK', 13), ('BUENO', '2026-02-24', 'OK', 15),
('BUENO', '2026-02-25', 'OK', 16), ('BUENO', '2026-02-26', 'OK', 18),
('BUENO', '2026-02-27', 'OK', 19), ('BUENO', '2026-02-28', 'OK', 20);

-- IMÁGENES
INSERT INTO imagenes_herramientas (url_imagen, herramienta_id) VALUES
('https://i.pinimg.com/1200x/fd/2f/cf/fd2fcf9328ae38213012cf4e8e44f820.jpg', 1),
('https://i.pinimg.com/1200x/e4/02/53/e40253b3427e048c4ea270c3e405d3fc.jpg', 2),
('https://i.pinimg.com/1200x/45/58/f5/4558f58e81c120af077335d0cc0445f8.jpg', 3),
('https://i.pinimg.com/736x/17/48/d5/1748d5e0cf3ba183d34bcf6bb4890767.jpg', 4),
('https://i.pinimg.com/736x/49/87/9f/49879f5325b89b47ec9bedd01781b1d2.jpg', 5),
('https://i.pinimg.com/1200x/09/62/be/0962be7e1eff61282515f6c86279c2d5.jpg', 6),
('https://i.pinimg.com/1200x/a3/94/cf/a394cf73a468203207c9cabc7e282a08.jpg', 7),
('https://i.pinimg.com/1200x/fd/e0/ad/fde0add84cf6cef201cfd069e880a32b.jpg', 8),
('https://i.pinimg.com/736x/44/be/4f/44be4f8c14c5451c0e2266989f6cbe81.jpg', 9),
('https://i.pinimg.com/736x/61/47/ad/6147ad21b6b318bc6916ccf523f6517a.jpg', 10),
('https://i.pinimg.com/736x/d6/7e/70/d67e707ad4b711969d3a4312cbabb56c.jpg', 11),
('https://i.pinimg.com/736x/82/14/92/821492102e7d40e24ea5fd27afd20bd9.jpg', 12),
('https://i.pinimg.com/736x/9f/ec/20/9fec204893707a4f4b771fba05b82c77.jpg', 13),
('https://i.pinimg.com/736x/3f/41/d8/3f41d803bb3101f0ac9a0eb3a1b7f7b8.jpg', 14),
('https://i.pinimg.com/736x/1b/b6/15/1bb6153c9320791b43fc5bc5f73338c2.jpg', 15),
('https://i.pinimg.com/1200x/77/bc/c6/77bcc6a3c41c594b3cdf269459c12ec8.jpg', 16),
('https://i.pinimg.com/1200x/62/fe/10/62fe10302003bf22d5ba60bc8639ffcc.jpg', 17),
('https://i.pinimg.com/1200x/9d/1a/aa/9d1aaa9b6a48daa0662c1019ce2764ce.jpg', 18),
('https://i.pinimg.com/736x/d6/e6/df/d6e6dfad4787ac257741e6b7b18356fa.jpg', 19),
('https://i.pinimg.com/1200x/9b/65/26/9b65263ad10367510e0c979a4e932609.jpg', 20);

-- INCIDENCIAS
INSERT INTO reporte_incidencias (costo_reparacion, descripcion, fecha_reporte, estado, herramienta_id, proveedor_id) VALUES
(25000.00, 'Falla motor', '2026-02-01', 'PENDIENTE', 1, 1),
(150000.00, 'Calor excesivo', '2026-02-02', 'PENDIENTE', 3, 2),
(45000.00, 'Ajuste disco', '2026-02-03', 'RESUELTA', 2, 1),
(30000.00, 'Fuga de agua', '2026-02-04', 'RESUELTA', 4, 3),
(12000.00, 'Oxido superficial', '2026-02-05', 'RESUELTA', 5, 2),
(85000.00, 'Cambio aceite', '2026-02-06', 'RESUELTA', 6, 3),
(20000.00, 'Calibracion Laser', '2026-02-07', 'EN_PROCESO', 7, 4),
(110000.00, 'Riel guia', '2026-02-08', 'EN_PROCESO', 8, 4),
(60000.00, 'Afilado general', '2026-02-09', 'PENDIENTE', 9, 1),
(15000.00, 'Cambio Bateria', '2026-02-09', 'EN_PROCESO', 10, 2),
(15000.00, 'Resistencia quemada', '2026-02-11', 'PENDIENTE', 11, 5),
(500000.00, 'Motor fundido', '2026-02-12', 'EN_PROCESO', 12, 6),
(35000.00, 'Filo cuchilla', '2026-02-13', 'RESUELTA', 13, 7),
(10000.00, 'Ajuste peldaño', '2026-02-14', 'RESUELTA', 14, 8),
(120000.00, 'Chip control', '2026-02-15', 'PENDIENTE', 15, 9),
(45000.00, 'Sello roto', '2026-02-16', 'EN_PROCESO', 16, 5),
(25000.00, 'Mango suelto', '2026-02-17', 'RESUELTA', 17, 6),
(180000.00, 'Cabezal mandril', '2026-02-18', 'PENDIENTE', 18, 7),
(30000.00, 'Filtro aire', '2026-02-19', 'RESUELTA', 19, 8),
(900000.00, 'Generador quemado', '2026-02-20', 'EN_PROCESO', 20, 9);

