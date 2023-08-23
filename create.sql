create sequence g_categories_SEQ start with 1 increment by 50;
create sequence g_products_SEQ start with 1 increment by 50;
create sequence g_users_SEQ start with 1 increment by 50;
create table g_categories (created_at timestamp(6) with time zone not null, id bigint not null, updated_at timestamp(6) with time zone not null, title varchar(50) not null, image_url varchar(255), primary key (id));
create table g_products (price numeric(38,2) not null, stock integer not null, created_at timestamp(6) with time zone not null, id bigint not null, updated_at timestamp(6) with time zone not null, name varchar(100) not null, image_url varchar(255) not null, unit varchar(255) check (unit in ('GRAM','OUNCE','KILOGRAM','MILLILITRE','LITRE','PIECE','POUCH','BAG','BOX')), primary key (id));
create table g_users (created_at timestamp(6) with time zone not null, id bigint not null, updated_at timestamp(6) with time zone not null, name varchar(50) not null, email varchar(255) unique, password varchar(255), role varchar(255) check (role in ('ADMIN','SHOP_MANAGER','CUSTOMER')), primary key (id));
