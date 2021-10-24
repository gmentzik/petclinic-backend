--
-- Insert first users, create roles and associate them 
--
INSERT INTO `petclinic2`.`user` (`id`,`username`, `password`,`enabled`) VALUES (1, 'admin', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6','1');
INSERT INTO `petclinic2`.`user` (`id`,`username`, `password`,`enabled`) VALUES (2, 'user', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6','1');

INSERT INTO `petclinic2`.`roles` (`id`,`name`) VALUES (1,'ADMIN');
INSERT INTO `petclinic2`.`roles` (`id`,`name`) VALUES (2,'USER');

INSERT INTO `petclinic2`.`users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `petclinic2`.`users_roles` (`user_id`, `role_id`) VALUES (2, 2);
