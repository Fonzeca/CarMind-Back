
//Cambiar de fecha a fecha con hora en el log de uso
ALTER TABLE `log_uso_vehiculo` CHANGE `fecha_inicio` `fecha_inicio` DATETIME NOT NULL, CHANGE `fecha_fin` `fecha_fin` DATETIME NULL DEFAULT NULL;


//Eliminar propiedad active del user hub
ALTER TABLE usuario
DROP COLUMN active;

//Cambiar casacde para que se elimine la pregunta al eliminar evaluacion
ALTER TABLE `pregunta` DROP FOREIGN KEY `pregunta_evaluacion`; ALTER TABLE `pregunta` ADD CONSTRAINT `pregunta_evaluacion` FOREIGN KEY (`evaluacion_id`) REFERENCES `evaluacion`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;

//Cambiar log vehiculo para que se elimine cuando se elimina un vehiculo
ALTER TABLE `log_evaluacion` DROP FOREIGN KEY `log_evaluacion_id`; ALTER TABLE `log_evaluacion` ADD CONSTRAINT `log_evaluacion_id` FOREIGN KEY (`evaluacion_id`) REFERENCES `evaluacion`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;

//Cambiar documento para que se elimine cuando se elimina un vehiculo
ALTER TABLE `documento` DROP FOREIGN KEY `vehiculo_documento`; ALTER TABLE `documento` ADD CONSTRAINT `vehiculo_documento` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculo`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;

//Cambiar el log de uso del vehiculo para que se elimine cuando se elimina un vehiculo
ALTER TABLE `log_uso_vehiculo` DROP FOREIGN KEY `log_uso_vehiculo_ibfk_2`; ALTER TABLE `log_uso_vehiculo` ADD CONSTRAINT `log_uso_vehiculo_ibfk_2` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculo`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `log_evaluacion` DROP FOREIGN KEY `log_evaluacion_id`; ALTER TABLE `log_evaluacion` ADD CONSTRAINT `log_evaluacion_id` FOREIGN KEY (`evaluacion_id`) REFERENCES `evaluacion`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;

//Añadir foreign key caida en el log option
ALTER TABLE `log_option` ADD CONSTRAINT `id_log_option_log_pregunta` FOREIGN KEY (`id_log_pregunta`) REFERENCES `log_pregunta`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE vehiculo ADD IMEI VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL AFTER kilometraje;