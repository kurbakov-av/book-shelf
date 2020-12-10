create table authors
(
    id       int8         not null,
    fullName varchar(255) not null,
    primary key (id)
);

create sequence authors_id_seq;
alter table authors
    alter column id set default nextval('authors_id_seq');
alter sequence authors_id_seq owned by authors.id;

create table books
(
    id            int8         not null,
    cover         varchar(255),
    description   varchar(5000),
    publicationAt timestamp,
    title         varchar(255) not null,
    volume        int4,
    author_id     int8,
    primary key (id)
);

create sequence books_id_seq;
alter table books
    alter column id set default nextval('books_id_seq');
alter sequence books_id_seq owned by books.id;

create table books_genres
(
    book_id   int8 not null,
    genres_id int8 not null,
    primary key (book_id, genres_id)
);

create table books_tags
(
    book_id int8 not null,
    tags_id int8 not null,
    primary key (book_id, tags_id)
);

create table favorite_books
(
    id      int8 not null,
    addedAt timestamp,
    book_id int8 not null,
    primary key (id)
);

create sequence favorite_books_id_seq;
alter table favorite_books
    alter column id set default nextval('favorite_books_id_seq');
alter sequence favorite_books_id_seq owned by favorite_books.id;

create table genres
(
    id    int8 not null,
    title varchar(255),
    primary key (id)
);

create sequence genres_id_seq;
alter table genres
    alter column id set default nextval('genres_id_seq');
alter sequence genres_id_seq owned by genres.id;

create table genres_tags
(
    genre_id int8 not null,
    tags_id  int8 not null,
    primary key (genre_id, tags_id)
);

create table rates
(
    id        int8 not null,
    createdAt timestamp,
    value     int4 not null,
    book_id   int8 not null,
    voter_id  int8 not null,
    primary key (id)
);

create sequence rates_id_seq;
alter table rates
    alter column id set default nextval('rates_id_seq');
alter sequence rates_id_seq owned by rates.id;

create table shelfs
(
    id          int8         not null,
    createdAt   timestamp,
    description varchar(255),
    title       varchar(255) not null,
    updatedAt   timestamp,
    owner_id    int8         not null,
    primary key (id)
);

create sequence shelfs_id_seq;
alter table shelfs
    alter column id set default nextval('shelfs_id_seq');
alter sequence shelfs_id_seq owned by shelfs.id;

create table tags
(
    id    int8 not null,
    title varchar(255),
    primary key (id)
);

create sequence tags_id_seq;
alter table tags
    alter column id set default nextval('tags_id_seq');
alter sequence tags_id_seq owned by tags.id;

create table user_shelf_books
(
    id       int8    not null,
    addedAt  timestamp,
    read     boolean not null,
    book_id  int8    not null,
    shelf_id int8    not null,
    primary key (id)
);

create sequence user_shelfs_books_seq;
alter table user_shelf_books
    alter column id set default nextval('user_shelfs_books_seq');
alter sequence user_shelfs_books_seq owned by user_shelf_books.id;

alter table if exists books
    add constraint FKfjixh2vym2cvfj3ufxj91jem7
        foreign key (author_id)
            references authors;

alter table if exists books_genres
    add constraint FKd69nnd4vn4ql5pp5i0fmmr7de
        foreign key (genres_id)
            references genres;

alter table if exists books_genres
    add constraint FK15koc8qu16w7b4n2ivvpkbjhj
        foreign key (book_id)
            references books;

alter table if exists books_tags
    add constraint FK1hmtafmavonwojd60bw3k3a9g
        foreign key (tags_id)
            references tags;

alter table if exists books_tags
    add constraint FK24aindb0esahor494422u1wnk
        foreign key (book_id)
            references books;

alter table if exists favorite_books
    add constraint FK5m94fycq4uodqata72s0hb9mg
        foreign key (book_id)
            references user_shelf_books;

alter table if exists genres_tags
    add constraint FK8eg5qqopqo3797956nkxvx9j5
        foreign key (tags_id)
            references tags;

alter table if exists genres_tags
    add constraint FKdixvvtmxh6wps1e1thv5rkge1
        foreign key (genre_id)
            references genres;

alter table if exists rates
    add constraint FK680ef588cndk2bwb5hdkcq1pg
        foreign key (book_id)
            references books;

alter table if exists rates
    add constraint FK40jvx69m39uppsfo51c9itooy
        foreign key (voter_id)
            references app.users;

alter table if exists shelfs
    add constraint FKsxyerhlphriwgypg4jwdtfh7s
        foreign key (owner_id)
            references app.users;

alter table if exists user_shelf_books
    add constraint FKsonxpwxcsh5k6jx9vg6uw10gf
        foreign key (book_id)
            references books;

alter table if exists user_shelf_books
    add constraint FKjrsp9va5avr7k00whgcpc35ys
        foreign key (shelf_id)
            references shelfs;