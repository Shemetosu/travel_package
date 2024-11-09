SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';
SET NAMES utf8mb4;

USE `travel_package`;

INSERT INTO `travel_type` (`id`, `name`)
VALUES (1, 'Отдых'),
       (2, 'Экскурсии'),
       (3, 'Лечение'),
       (4, 'Шопинг'),
       (5, 'Круиз');

INSERT INTO `travel_transport` (`id`, `name`)
VALUES (1, 'Поезд'),
       (2, 'Самолёт'),
       (3, 'Круизный лайнер'),
       (4, 'Туристический автобус'),
       (5, 'Микроавтобус');

INSERT INTO `travel_feed` (`id`, `name`)
VALUES (1, 'Завтрак'),
       (2, 'Завтрак и обед'),
       (3, 'Трёхразовое питание'),
       (4, 'Шведский стол'),
       (5, 'Без питания');

INSERT INTO `travel` (`id`, `travel_type_id`, `travel_transport_id`, `travel_feed_id`, `name`, `days_count`)
VALUES (1, 1, 1, 1, 'Путёвочка1', 1),
       (2, 2, 2, 2, 'Путёвочка2', 2),
       (3, 3, 3, 3, 'Путёвочка3', 3),
       (4, 4, 4, 4, 'Путёвочка4', 4),
       (5, 5, 5, 5, 'Путёвочка5', 5),
       (1, 2, 3, 4, 'Путёвочка6', 6),
       (5, 4, 3, 2, 'Путёвочка7', 7),
       (2, 3, 4, 5, 'Путёвочка8', 8),
       (4, 3, 2, 1, 'Путёвочка9', 9),
       (1, 1, 2, 2, 'Путёвочка10', 10),
       (3, 3, 4, 4, 'Путёвочка11', 11),
       (5, 5, 4, 4, 'Путёвочка12', 12);