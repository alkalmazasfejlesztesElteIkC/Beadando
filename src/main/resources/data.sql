insert into users(id, name, status) values (1,'Sanyi','PARENT');
insert into tasks(id,taskname,lead_id) values (1,'porszivozas',1);
insert into comments(id,author,text,task_id) values (1,'Geza','Ez egy comment',1);

insert into users(id, name, status) values (2,'Alex','CHILD');
insert into users_taskto_dos(workers_id,taskto_dos_id) values (2,1);

