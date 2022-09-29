CREATE TABLE `carmind`.`defecto` ( `id` INT NOT NULL AUTO_INCREMENT , `log_pregunta_id` INT NOT NULL , `nombre_usuario` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL , `resuelto` BOOLEAN NOT NULL , `fecha_creacion` DATETIME NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

ALTER TABLE `defecto` ADD `vehiculo_id` INT NOT NULL AFTER `fecha_creacion`;

ALTER TABLE `defecto` ADD CONSTRAINT `id_log_pregunta_defecto` FOREIGN KEY (`log_pregunta_id`) REFERENCES `log_pregunta`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `defecto` ADD CONSTRAINT `id_vehiculo_defecto` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculo`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;