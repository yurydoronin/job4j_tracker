create database tracker;

begin;

create table if not exists roles
(
    id   serial primary key not null,
    name varchar(30)        not null
);

create table if not exists users
(
    id       serial primary key not null,
    login    varchar(30)        not null,
    password varchar(30)        not null,
    role_id  int references roles (id)
);

create table if not exists rules
(
    id          serial primary key not null,
    description varchar(60)        not null
);

create table if not exists rule_to_role
(
    id       serial primary key,
    roles_id int references roles (id),
    rules_id int references rules (id)
);

create table if not exists item_status
(
    id   serial primary key not null,
    name varchar(30)        not null
);

create table if not exists item_category
(
    id   serial primary key not null,
    name varchar(30)        not null
);

create table if not exists items
(
    id            serial primary key not null,
    description   text               not null,
    creation_date timestamp          not null default now(),
    category      varchar(30)        not null,
    status        varchar(30)        not null,
    user_id       int references users (id),
    category_id   int references item_category (id),
    status_id     int references item_status (id)
);

create table if not exists item_comments
(
    id      serial primary key not null,
    comment text,
    item_id int references items (id),
    user_id int references users (id)
);

create table if not exists attachments
(
    id      serial primary key not null,
    file    varchar(100),
    item_id int references items (id)
);

commit;

insert into roles (name)
values ('admin'),
       ('superuser'),
       ('user');

insert into users (login, password, role_id)
values ('scout', '123', 1),
       ('largo', '555', 2),
       ('margo', '777', 3),
       ('tank', '333', 3),
       ('black', '999', 3);

insert into rules (description)
values ('creat item'),
       ('delete item'),
       ('update item'),
       ('add file'),
       ('alter item status'),
       ('creat category'),
       ('alter category'),
       ('delete category'),
       ('create user account'),
       ('delete user account'),
       ('alter user role');

insert into rule_to_role (roles_id, rules_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (1, 9),
       (1, 10),
       (1, 11),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (2, 7),
       (3, 1),
       (3, 3),
       (3, 4),
       (3, 9);

insert into item_status (name)
values ('new item'),
       ('in processing'),
       ('performing'),
       ('closed');

insert into item_category (name)
values ('customer support'),
       ('tech support'),
       ('logistics'),
       ('accounting'),
       ('marketing'),
       ('law');

insert into items (description, category, status, user_id, category_id, status_id)
values ('test', 'customer support', 'new item', 3, 1, 1),
       ('test_2', 'logistics', 'new item', 4, 3, 1);

insert into item_comments (comment, item_id, user_id)
values ('мама мыла раму', 1, 3),
       ('sql is cool', 2, 4);

insert into attachments (file, item_id)
values ('/Users/macintosh/Pictures/Harvard.jpg', 1),
       ('/Users/macintosh/Pictures/barbados.jpg', 2);
