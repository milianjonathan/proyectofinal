create schema escuela;
create table if not exists alumno(clave int(4) NOT NULL, nombre varchar(50), teléfono INT(8),dirección varchar(30), email varchar(30), fecha_de_nacimiento VARCHAR(30), genero varchar(10), cuotas_pagadas int(2), cuotas_pendientes int(2), total varchar(10), mora varchar(2));

SELECT * FROM alumno where clave =?;
INSERT INTO  alumno (clave,nombre,teléfono, dirección, email, fecha_de_nacimiento, genero,cuotas_pagadas , cuotas_pendientes , total , mora) VALUES(?,?,?,?,?,?,?,?,?,?,?);
Select count(clave) from alumno where clave =?;
DELETE  FROM alumno WHERE clave =?;
SELECT clave, nombre, cuotas_pagadas FROM alumno;
