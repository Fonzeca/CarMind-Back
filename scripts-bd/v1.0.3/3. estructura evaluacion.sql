//Borrado de seccion
//drop pregunta.seccion
//drop pregunta.activo
//drop log_evaluacion.observaciones




ALTER TABLE `log_pregunta` ADD `descripcion` VARCHAR(100) NOT NULL AFTER `tick_correcto`, ADD `tipo` VARCHAR(50) NOT NULL AFTER `descripcion`, ADD `crucial` BOOLEAN NOT NULL AFTER `tipo`;
//agregar los datos correctos
ALTER TABLE `carmind`.`log_pregunta` DROP FOREIGN KEY `log_pregunta_id`;
ALTER TABLE `log_pregunta` DROP `id_pregunta`;


ALTER TABLE `log_option` ADD `descripcion` VARCHAR(50) NOT NULL AFTER `tick_check`, ADD `crucial` BOOLEAN NOT NULL AFTER `descripcion`;
//agregar los datos correctos
ALTER TABLE `carmind`.`log_option` DROP FOREIGN KEY `option_log_option`;
ALTER TABLE `log_option` DROP `id_option`;
ALTER TABLE `log_pregunta` ADD CONSTRAINT `logpregunta_tipopregunta` FOREIGN KEY (`tipo`) REFERENCES `tipo_pregunta`(`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE `pregunta` ADD `evaluacion_id` INT NOT NULL AFTER `crucial`;
ALTER TABLE `pregunta` ADD CONSTRAINT `pregunta_evaluacion` FOREIGN KEY (`evaluacion_id`) REFERENCES `evaluacion`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;