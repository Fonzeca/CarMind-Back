
//Cambiar de fecha a fecha con hora en el log de uso
ALTER TABLE `log_uso_vehiculo` CHANGE `fecha_inicio` `fecha_inicio` DATETIME NOT NULL, CHANGE `fecha_fin` `fecha_fin` DATETIME NULL DEFAULT NULL;