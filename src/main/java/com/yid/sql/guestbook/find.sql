select * from category;
select * from guestbook;

select * from guestbook where category_id = 2;

select g.category_id, g.username, g.message 
from guestbook g 
where g.category_id = 2;


select g.category_id, c.name, g.username, g.message 
from guestbook g, category c
where g.category_id = 2 and c.id = g.category_id;