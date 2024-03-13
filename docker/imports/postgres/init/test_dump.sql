--CREATE DATABASE users ENCODING 'utf8';
--USE users;
CREATE schema if not exists users_scheme;
CREATE TABLE IF NOT EXISTS users_scheme.companies(
id uuid primary KEY,
name varchar(255),
phone varchar(255),
deleted BOOLEAN DEFAULT FALSE
);
CREATE TABLE IF NOT EXISTS users_scheme.addresses(
addr_id uuid primary KEY,
city varchar(255),
street varchar(255),
house_number varchar(255),
flat_number integer,
deleted BOOLEAN DEFAULT FALSE
);
CREATE TABLE IF NOT EXISTS users_scheme.companies_addresses(
companies_id uuid,
addresses_id uuid,
deleted BOOLEAN DEFAULT FALSE
);
--constraints
ALTER TABLE users_scheme.companies ADD CONSTRAINT company_name_chk CHECK(name IS NOT null); --название компании не может быть пустым
ALTER TABLE users_scheme.addresses 
ADD CONSTRAINT addresses_check CHECK (city is not null and street is not NULL AND house_number IS NOT NULL); --Некоторые поля адреса обязательны для заполнения
ALTER TABLE users_scheme.companies_addresses ADD CONSTRAINT company_fk FOREIGN KEY (companies_id) REFERENCES users_scheme.companies(id) ON
DELETE
	CASCADE ON
	UPDATE
	CASCADE;
ALTER TABLE users_scheme.companies_addresses ADD CONSTRAINT addressess_fk FOREIGN KEY (addresses_id) REFERENCES users_scheme.addresses(addr_id) ON
DELETE
	CASCADE ON
	UPDATE
	CASCADE;

insert into users_scheme.companies(id,name,phone) values (gen_random_uuid(),'name1','phone1');
commit;