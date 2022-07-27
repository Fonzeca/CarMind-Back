ALTER TABLE `pregunta` ADD `evaluacion_id` INT NOT NULL AFTER `crucial`;
//Agregar datos
UPDATE pregunta p INNER JOIN seccion s ON p.seccion = s.id SET p.evaluacion_id = s.evaluacion_id
ALTER TABLE `pregunta` ADD CONSTRAINT `pregunta_evaluacion` FOREIGN KEY (`evaluacion_id`) REFERENCES `evaluacion`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

//Borrado de seccion
//drop pregunta.seccion
//drop pregunta.activo
//drop log_evaluacion.observaciones

ALTER TABLE `carmind`.`pregunta` DROP FOREIGN KEY `pregunta_seccion`;
DROP TABLE `seccion`;
ALTER TABLE `pregunta` DROP `seccion`, DROP `activo`;
ALTER TABLE `log_evaluacion` DROP `observaciones`;




ALTER TABLE `log_pregunta` ADD `descripcion` VARCHAR(100) NOT NULL AFTER `tick_correcto`, ADD `tipo` VARCHAR(50) NOT NULL AFTER `descripcion`, ADD `crucial` BOOLEAN NOT NULL AFTER `tipo`;

UPDATE log_pregunta l INNER JOIN pregunta p ON l.id_pregunta = p.id SET l.descripcion = p.descripcion, l.crucial = p.crucial, l.tipo = p.tipo
//Poner bien lo de crucial
ALTER TABLE `carmind`.`log_pregunta` DROP FOREIGN KEY `log_pregunta_id`;
ALTER TABLE `log_pregunta` DROP `id_pregunta`;


ALTER TABLE `log_option` ADD `descripcion` VARCHAR(50) NOT NULL AFTER `tick_check`, ADD `crucial` BOOLEAN NOT NULL AFTER `descripcion`;

UPDATE log_option l INNER JOIN pregunta_opcion o ON l.id_option = o.id SET l.descripcion = o.opcion, l.crucial = o.crucial

ALTER TABLE `carmind`.`log_option` DROP FOREIGN KEY `option_log_option`;
ALTER TABLE `log_option` DROP `id_option`;
ALTER TABLE `log_pregunta` ADD CONSTRAINT `logpregunta_tipopregunta` FOREIGN KEY (`tipo`) REFERENCES `tipo_pregunta`(`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT;



-- ALTER TABLE `pregunta_opcion` DROP FOREIGN KEY `id_pregunta_pregunta`; ALTER TABLE `pregunta_opcion` ADD CONSTRAINT `id_pregunta_pregunta` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;