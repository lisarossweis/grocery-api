create sequence g_products_SEQ start with 1 increment by 50;
create sequence MyEntity_SEQ start with 1 increment by 50;
create table g_products (price numeric(38,2) not null, stock integer not null, created_at timestamp(6) with time zone not null, id bigint not null, updated_at timestamp(6) with time zone not null, name varchar(100) not null, imageUrl varchar(255) not null, unit varchar(255) check (unit in ('GRAM','OUNCE','KILOGRAM','MILLILITRE','LITRE','PIECE','POUCH','BAG','BOX')), primary key (id));
create table MyEntity (id bigint not null, field varchar(255), primary key (id));
