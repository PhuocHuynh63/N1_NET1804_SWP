CREATE DATABASE me_be_test
GO

USE me_be_test
GO

-- Tạo bảng User
CREATE TABLE [user] (
    [user_id] INT PRIMARY KEY IDENTITY(1,1),
    avatar VARCHAR(255),
    first_name NVARCHAR(50),
    last_name NVARCHAR(50),
	username NVARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    [password] VARCHAR(255),
    birth_date DATE,
	[role] VARCHAR(20),
    phone VARCHAR(20),
    point INT,
	[status] NVARCHAR(50),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL
);

-- Tạo bảng Address
CREATE TABLE [address] (
    address_id INT PRIMARY KEY IDENTITY(1,1),
    [user_id] INT,
    is_default BIT,
    title NVARCHAR(100),
    [address] NVARCHAR(255),
    city NVARCHAR(100),
	district NVARCHAR(100),
	ward NVARCHAR(100),
    FOREIGN KEY ([user_id]) REFERENCES [user]([user_id])
);

-- Tạo bảng Category
CREATE TABLE category (
    category_id INT PRIMARY KEY IDENTITY(1,1),
    [name] NVARCHAR(100),
    [slug] NVARCHAR(MAX)
);

-- Tạo bảng SubCategory
CREATE TABLE subcategory (
    subcategory_id INT PRIMARY KEY IDENTITY(1,1),
    parent_id INT,
    [name] NVARCHAR(100),
    slug NVARCHAR(MAX),
    FOREIGN KEY (parent_id) REFERENCES category(category_id)
);

-- Tạo bảng ProductAttribute
CREATE TABLE product_attribute (
    product_attribute_id INT PRIMARY KEY IDENTITY(1,1),
    [type] NVARCHAR(50),
    [value] VARCHAR(100)
);

-- Tạo bảng Product
CREATE TABLE product (
    product_id INT PRIMARY KEY IDENTITY(1,1),
    subcategory_id INT,
	slug NVARCHAR(100),
	name NVARCHAR(255),
	images NVARCHAR(MAX),
	[description] NVARCHAR(MAX),
	price DECIMAL(10, 2),
	sale_price 	DECIMAL(10, 2),
	[status] NVARCHAR(50),
	total_sold INT,
	product_view INT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(subcategory_id)
);

-- Tạo bảnh Inventory
CREATE TABLE inventory (
	inventory_id INT PRIMARY KEY IDENTITY(1,1),
	product_id INT,
	size_id	INT,
	color_id INT,
	quantity INT,
    FOREIGN KEY(product_id) REFERENCES product(product_id)
);

-- Tạo bảng Review
CREATE TABLE review (
    review_id INT PRIMARY KEY IDENTITY(1,1),
    [user_id] INT,
    product_id INT,
    rate INT,
    comment NVARCHAR(MAX),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	update_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY ([user_id]) REFERENCES [user]([user_id]),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Tạo bảng Voucher
CREATE TABLE voucher (
    voucher_id INT PRIMARY KEY IDENTITY(1,1),
	voucher_code NVARCHAR(50),
	discount_type 	NVARCHAR(50),
	discount_value 	DECIMAL(10, 2),
	[name] NVARCHAR(255),
	cost DECIMAL(10, 2),
	quantity INT,
	minimum_apply DECIMAL(10, 2),
	max_discount DECIMAL(10, 2),
	is_active BIT,
	is_public BIT,
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	update_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tạo bảng Order
CREATE TABLE [order] (
    order_id INT PRIMARY KEY IDENTITY(1,1),
    [user_id] INT,
    voucher_id INT,
	[status] NVARCHAR(50),
	delivery_fee DECIMAL(10, 2),
	total_amount DECIMAL(10, 2),
    deposite_amount DECIMAL(10, 2),
	order_type NVARCHAR(50),
	payment_status NVARCHAR(50),
	note NVARCHAR(200),
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY ([user_id]) REFERENCES [user]([user_id]),
    FOREIGN KEY (voucher_id) REFERENCES voucher(voucher_id)
);

-- Tạo bảng OrderDetail
CREATE TABLE order_detail (
    order_detail_id  INT PRIMARY KEY IDENTITY(1,1),
    order_id INT,
    product_id INT,
    inventory_id  INT,
    quantity INT,
	price DECIMAL(10, 2),
    sale_price  DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES [order](order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id),
	FOREIGN KEY (inventory_id) REFERENCES inventory(inventory_id)
);


-- Tạo bảng Payment
CREATE TABLE payment (
    payment_id INT PRIMARY KEY IDENTITY(1,1),
	order_id INT,
	amount DECIMAL(10, 2),
	payment_type NVARCHAR(50),
	payment_method NVARCHAR(50),
	payment_status NVARCHAR(50),
	transaction_reference 	NVARCHAR(100),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
	FOREIGN KEY (order_id) REFERENCES [order](order_id),
);


