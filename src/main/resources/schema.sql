create table if not exists cds
(
    id      INTEGER not null
        constraint cds_pk
            primary key autoincrement,
    name    TEXT    not null,
    artist  TEXT    not null,
    country TEXT    not null,
    price   REAL    not null
);

create table if not exists users
(
    id       INTEGER not null
        constraint users_pk
            primary key autoincrement,
    email    TEXT    not null
        constraint users_pk2
            unique,
    password TEXT    not null
);


create table if not exists orders
(
    id      INTEGER not null
        constraint orders_pk
            primary key autoincrement,
    user_id INTEGER not null
        constraint orders_users_id_fk
            references users,
    price   REAL    not null
);

create table if not exists orders_cds
(
    id       INTEGER not null
        constraint orders_cds_pk
            primary key autoincrement,
    order_id integer not null
        constraint orders_cds_orders_id_fk
            references orders,
    cd_id    INTEGER not null
        constraint orders_cds_cds_id_fk
            references cds,
    amount   INTEGER not null
);

