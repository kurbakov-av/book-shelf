create table tenants
(
    id int8 not null,
    name varchar(255) not null,
    schema varchar(255) not null,
    createdAt timestamp not null ,
    updatedAt timestamp not null ,
    primary key (id)
);

create sequence tenants_id_seq;
alter table tenants alter column id set default nextval('tenants_id_seq');
alter sequence tenants_id_seq owned by tenants.id;

create table users
(
    id       int8         not null,
    email    varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);

create sequence users_id_seq;
alter table users alter column id set default nextval('users_id_seq');
alter sequence users_id_seq owned by users.id;

create table authorities
(
    user_id     int8 not null,
    authorities varchar(255)
);

alter table if exists tenants
    add constraint UK_EbMdOdb8R4jlZJ2r7mMTt4XFS unique (name);

alter table if exists tenants
    add constraint UK_eij8othaiNaMimai3shaim5Eh unique (schema);

alter table if exists users
    add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

alter table if exists users
    add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

alter table if exists authorities
    add constraint FK1haxxsb2605lmenadan4ghpb4
        foreign key (user_id)
            references users;