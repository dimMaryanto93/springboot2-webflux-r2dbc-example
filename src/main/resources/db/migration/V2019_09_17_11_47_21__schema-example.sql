CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table examples
(
    id           character varying(64) not null primary key,
    name         character varying(100),
    age          integer                        default 0,
    birthday     date                  not null default now(),
    balance      decimal(14)           not null default 0,
    created_date timestamp             not null default now()
);

insert into examples(id, name, age, birthday, balance, created_date)
values
       (uuid_generate_v4(), 'Dimas Maryanto', 20, now(), 0, now()),
       (uuid_generate_v4(), 'Hari Sapto Adi', 20, now(), 0, now()),
       (uuid_generate_v4(), 'Muhamad Yusuf', 20, now(), 0, now()),
       (uuid_generate_v4(), 'Prima Jakaria', 20, now(), 0, now()),
       (uuid_generate_v4(), 'Andri', 20, now(), 0, now()),
       (uuid_generate_v4(), 'Gufron', 20, now(), 0, now());
