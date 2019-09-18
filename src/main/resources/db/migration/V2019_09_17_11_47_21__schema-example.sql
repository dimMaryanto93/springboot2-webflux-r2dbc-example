CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table examples
(
    id           character varying(64) not null primary key default uuid_generate_v4(),
    name         character varying(100),
    age          integer                                    default 0,
    birthdate    date                  not null             default now(),
    balance      decimal(14)           not null             default 0,
    created_date timestamp             not null             default now()
);

insert into examples(id, name, age, birthdate, balance, created_date)
values (uuid_generate_v4(), 'Dimas Maryanto', 21, now(), 0, now()),
       (uuid_generate_v4(), 'Hari Sapto Adi', 22, now(), 0, now()),
       (uuid_generate_v4(), 'Muhamad Yusuf', 23, now(), 0, now()),
       (uuid_generate_v4(), 'Prima Jakaria', 24, now(), 0, now()),
       (uuid_generate_v4(), 'Andri', 25, now(), 0, now()),
       (uuid_generate_v4(), 'Gufron', 26, now(), 0, now());
