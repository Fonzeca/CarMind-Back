






-- crear la tabla
CREATE TABLE `carmind`.`log_uso_vehiculo` ( `id` INT NOT NULL , `fecha_inicio` DATE NOT NULL , `fecha_fin` DATE NULL , `usuario_id` INT NOT NULL , `vehiculo_id` INT NOT NULL ) ENGINE = InnoDB;

-- añadir clave primaria
ALTER TABLE `log_uso_vehiculo` ADD PRIMARY KEY(`id`);

-- añadir claves foraneas
ALTER TABLE `log_uso_vehiculo` ADD INDEX(`usuario_id`);
ALTER TABLE `log_uso_vehiculo` ADD INDEX(`vehiculo_id`);

ALTER TABLE `log_uso_vehiculo` ADD CONSTRAINT `log_uso_vehiculo_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `log_uso_vehiculo` ADD CONSTRAINT `log_uso_vehiculo_ibfk_2` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
