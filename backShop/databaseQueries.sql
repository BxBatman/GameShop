CREATE TABLE category (

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,

	CONSTRAINT pk_category_id PRIMARY KEY (id)

);

INSERT INTO category (name, description,image_url,is_active) VALUES ('Laptop', 'This is description for Laptop category!', 'CAT_1.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Television', 'This is description for Television category!', 'CAT_2.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Mobile', 'This is description for Mobile category!', 'CAT_3.png', true);

CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY(id),
);


INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Tomasz', 'Kowalski', 'ADMIN', true, 'admin', 'kowalski@gmail.com', '123456789');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Adam', 'Joachimiak', 'SUPPLIER', true, '12345', 'adam@gmail.com', '111222333');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Krzystof', 'Kuc', 'SUPPLIER', true, '12345', 'krzys@gmail.com', '444555666');


CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
);


INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'Uncharted3', 'PS3', 'This is one of the best game available in the market right now!', 100, 5, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'NFS RIVALS', 'PS4', 'NFS FOR PS4', 60, 10, true, 2, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'NFS UNDERCOVER', 'PS4', 'GAME FOR PS4', 100, 5, true, 2, 2 );

