create table water (
        id serial primary key,
        capacity int,
        portion int,
        coffee_id int,
        foreign key (coffee_id) references coffee(id))