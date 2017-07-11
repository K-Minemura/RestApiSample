create table
    jiro (
        id                    serial         primary key
       ,name                  varchar(100)   not null
       ,address               varchar(1000)  not null
       ,latitude              decimal(20,10) not null
       ,longitude             decimal(20,10) not null
    )
;

create table
    menu (
        id                    serial         primary key
       ,jiro_id               bigint         not null
       ,name                  varchar(100)   not null
       ,price                 int            not null
    )
;
