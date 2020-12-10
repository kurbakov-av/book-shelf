create table oauth_client_details
(
    client_id               varchar(255)  not null,
    client_secret           varchar(255)  not null,
    resource_ids            varchar(1000) not null,
    scope                   varchar(1000),
    authorized_grant_types  varchar(1000) not null,
    web_server_redirect_uri varchar(255),
    authorities             varchar(255)  not null,
    access_token_validity   int8          not null,
    refresh_token_validity  int8          not null,
    additional_information  varchar(1000),
    autoapprove             varchar(1000),
    primary key (client_secret)
);
