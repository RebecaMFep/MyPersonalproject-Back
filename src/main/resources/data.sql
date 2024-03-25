INSERT INTO activities(id_activity,name,location,days,month,time,ageRange,capacity,,description) VALUES (DEFAULT,"Escalada","Rocódromo San Agustín","5","1","11:00" "2","10" "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,true,"event2.jpg");
INSERT INTO activities(id_activity,name,location,days,month,time,ageRange,capacity,,description) VALUES (DEFAULT,"Surf","San Lorenzo","6","1" "9:00","1","10","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,true,"event3.jpg");
INSERT INTO activities(id_activity,name,location,days,month,time,ageRange,capacity,description) VALUES (DEFAULT,"Volley-Playa","San Lorenzo","2,4","2" "11:00","2","12","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,false,"event6.jpg");
INSERT INTO activities(id_activity,name,location,days,month,time,ageRange,capacity,,description) VALUES (DEFAULT,"Skate","Cimavilla","1,3","1" "10:00","1","10","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,false,"event7.png");
INSERT INTO acivities(id_activity,name,location,days,month,time,ageRange,capacity,description) VALUES (DEFAULT,"Natación","Santa Olaya","3","2" "10:00","2","12","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,false,"event8.jpeg");


INSERT INTO days(id_day,name) VALUES (DEFAULT,"Lunes");
INSERT INTO days(id_day,name) VALUES (DEFAULT,"Martes");
INSERT INTO days(id_day,name) VALUES (DEFAULT,"Miércoles");
INSERT INTO days(id_day,name) VALUES (DEFAULT,"Jueves");
INSERT INTO days(id_day,name) VALUES (DEFAULT,"Viernes");
INSERT INTO days(id_day,name) VALUES (DEFAULT,"Sábado");
INSERT INTO days(id_day,name) VALUES (DEFAULT,"Domingo");


INSERT INTO months(id_month,name) VALUES (DEFAULT,"Julio");
INSERT INTO months(id_month,name) VALUES (DEFAULT,"Agosto");

INSERT INTO ageRanges(id_ageRange,name) VALUES (DEFAULT,"3-6 años");
INSERT INTO ageRanges(id_ageRange,name) VALUES (DEFAULT,"7-12 años");

INSERT INTO roles(id_role,name) VALUES (DEFAULT,"ROLE_ADMIN");
INSERT INTO roles(id_role,name) VALUES (DEFAULT,"ROLE_USER");

INSERT INTO users(id_user,username,password) VALUES (DEFAULT,"admin","$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO");
INSERT INTO users(id_user,username,password) VALUES (DEFAULT,"user","$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO");

INSERT INTO roles_users(role_id,user_id) VALUES (1,1);
INSERT INTO roles_users(role_id,user_id) VALUES (2,2);