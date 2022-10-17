CREATE TABLE `defecto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `log_pregunta_id` int NOT NULL,
  `nombre_ape_usuario` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `vehiculo_id` int NOT NULL,
  `id_usuario` int DEFAULT NULL,
  `prioridad` int NOT NULL,
  `estado` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_log_pregunta_defecto` (`log_pregunta_id`),
  KEY `id_vehiculo_defecto` (`vehiculo_id`),
  KEY `id_usuario_defecto` (`id_usuario`),
  KEY `estado_defecto` (`estado`),
  CONSTRAINT `estado_defecto` FOREIGN KEY (`estado`) REFERENCES `estado` (`estado`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_log_pregunta_defecto` FOREIGN KEY (`log_pregunta_id`) REFERENCES `log_pregunta` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_usuario_defecto` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_vehiculo_defecto` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

ALTER TABLE `defecto` DROP FOREIGN KEY `estado_defecto`; ALTER TABLE `defecto` ADD CONSTRAINT `estado_defecto` FOREIGN KEY (`estado`) REFERENCES `estado`(`estado`) ON DELETE RESTRICT ON UPDATE CASCADE;