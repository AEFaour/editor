create sequence hs_id_seq start with 1 increment by 50;

create table houses(
    id bigint default nextval('hs_id_seq') not null,
    article varchar(255) not null,
    url varchar(255) not null,
    created_at timestamp,
    primary key (id)
);