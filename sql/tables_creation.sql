drop table if exists user_book cascade;
drop table if exists "order" cascade;
drop table if exists order_book cascade;
drop table if exists cart cascade;
drop table if exists history cascade;
drop table if exists book_tag cascade;
drop table if exists tag cascade;
drop table if exists book cascade;
drop table if exists publisher cascade;
drop table if exists author cascade;
drop table if exists password cascade;
drop table if exists "user" cascade;
drop table if exists role cascade;


create table role(
    id bigint generated always as identity primary key,
    name varchar(64) not null unique
);

insert into role values (default, 'admin');
insert into role values (default, 'librarian');
insert into role values (default, 'reader');

create table "user"(
    id bigint generated always as identity primary key,
    full_name varchar(64) not null,
    date_of_birth date not null,
    role_id bigint references role(id) not null,
    email varchar(64) not null,
    allow_letters bool default(true) not null,
    confirmed bool default(false) not null,
    login varchar(64) not null
);

create table password(
    user_id bigint references "user"(id) on delete cascade not null,
    password varchar(128) not null
);

create table author(
    id bigint generated always as identity primary key,
    full_name varchar(64) not null unique
);

create table publisher(
    id bigint generated always as identity primary key,
    name varchar(64) not null unique
);

create table book(
    id bigint generated always as identity primary key,
    quantity bigint not null CONSTRAINT CHK_quantity CHECK (quantity >= 0),
    occupied bigint not null CONSTRAINT CHK_occupied CHECK (occupied >= 0),
    title varchar(128) not null,
    author_id bigint references author(id) on delete cascade not null,
    publisher_id bigint references publisher(id) on delete cascade not null,
    year smallint not null
);

create table history(
    id bigint generated always as identity primary key,
    user_id bigint references "user"(id) on delete cascade not null,
    book_id bigint references "book"(id) on delete cascade not null,
    date_of_issue date not null,
    date_of_release date not null CONSTRAINT CHK_date CHECK (date_of_release >= date_of_issue)
);

create table cart(
    user_id bigint references "user"(id) on delete cascade not null,
    book_id bigint references book(id) on delete cascade not null,
    quantity bigint not null CONSTRAINT CHK_quantity CHECK (quantity > 0)
);

create table "order"(
    id bigint generated always as identity primary key,
    user_id bigint references "user"(id) on delete cascade not null,
    appointment_time timestamptz not null
);

create table order_book(
    order_id bigint references "order"(id) on delete cascade not null,
    book_id bigint references book(id) on delete cascade not null,
    quantity smallint not null CONSTRAINT CHK_quantity CHECK (quantity > 0)
);

create table user_book(
    id bigint generated always as identity primary key,
    user_id bigint references "user"(id) on delete cascade not null,
    book_id bigint references book(id) on delete cascade not null,
    quantity smallint not null CONSTRAINT CHK_quantity CHECK (quantity > 0),
    date_of_issue date not null,
    planned_date_of_release date not null
);

create table tag(
    id bigint generated always as identity primary key,
    name varchar(64) not null
 );

create table book_tag(
    book_id bigint references book(id) on delete cascade not null,
    category_id bigint references tag(id) on delete cascade not null
);