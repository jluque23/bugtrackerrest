/* creamos algunos usuarios */

INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email,create_at) VALUES ('jluque','$2a$10$Zri4Huh6KQHtir0Ud3xClOXQEdIzQ9cbaJf4HupoGFxDHz2Y/Kvp.',1,'Jesus','Luque','luque23@live.com.mx','2020-01-01');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email,create_at) VALUES ('admin','$2a$10$h5FDjzfoYpDnKvLi4YalmOOVMPyNyNgzvAWButHx/sX.o20ib9iN.',1,'admin','admin','admin@email.com','2010-01-01');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,1);

/* Creamos bugs */
insert into bugs (title,create_at,descripcion,usuario_id,enabled) values ('This is the first bug','2010-01-05','This is the description',1,1);
insert into bugs (title,create_at,descripcion,usuario_id,enabled) values ('Error en ventana login','2015-01-05','Error al iniciar un login no funciona',2,0);

/* Creamos comentarios en bugs */
insert into bug_comentarios(id, comentario, create_at, usuario, bug_id) values (1,'Verificare el bug de inmediato','2010-01-05','Andres Guzman','1');
insert into bug_comentarios(id, comentario, create_at, usuario, bug_id) values (2,'Verificare el bug de inmediato','2010-01-05','John Doe','1');
insert into bug_comentarios(id, comentario, create_at, usuario, bug_id) values (3,'Verificalo bien porfavor','2010-01-05','Jesus Luque','1');

/* creamos notificationes */
insert into notifications (id,create_at,description) values (1,'2020/10/10','This is the first notification');
insert into notifications (id,create_at,description) values (2,now(),'This is the second notification');