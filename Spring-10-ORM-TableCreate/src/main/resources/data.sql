--
-- INSERT INTO EMPLOYEES(id,name)
-- VALUES(3,'Mike Smith');

--
-- INSERT INTO student(id, first_name,last_name,email)
-- VALUES(4, 'Mike',' Smith','mike@cydeo.com');

-- after table is created with @GeneratedValue then id will be populated by postgres
-- INSERT INTO student(first_name,last_name,email)
-- VALUES('Joe',' Shmo','loe@cydeo.com');

-- after table name is altered with @Table
INSERT INTO students(first_name,last_name,email)
VALUES('Lame','Duck','lame@cydeo.com');


