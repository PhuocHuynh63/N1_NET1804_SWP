CREATE DATABASE me_be
GO

USE me_be
GO

-- Tạo bảng User
CREATE TABLE [user] (
    user_id INT PRIMARY KEY IDENTITY(1,1),
    avatar VARCHAR(255),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    [password] VARCHAR(255),
    role VARCHAR(20),
    birth_date DATE,
    phone VARCHAR(20),
    point INT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL
);

-- Tạo bảng Address
CREATE TABLE address (
    address_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    is_default BIT,
    title VARCHAR(100),
    address_line_1 VARCHAR(255),
    address_line_2 VARCHAR(255),
    country VARCHAR(100),
    city VARCHAR(100),
    postal_code VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES [user](user_id)
);

-- Tạo bảng Category
CREATE TABLE category (
    category_id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(100),
    description TEXT
);

-- Tạo bảng SubCategory
CREATE TABLE subcategory (
    subcategory_id INT PRIMARY KEY IDENTITY(1,1),
    parent_id INT,
    name VARCHAR(100),
    description TEXT,
    FOREIGN KEY (parent_id) REFERENCES category(category_id)
);

-- Tạo bảng ProductAttribute
CREATE TABLE product_attribute (
    product_attribute_id INT PRIMARY KEY IDENTITY(1,1),
    type VARCHAR(50),
    value VARCHAR(100)
);

-- Tạo bảng Product
CREATE TABLE product (
    product_id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(255),
    img VARCHAR(255),
    description TEXT,
    subcategory_id INT,
    number_view INT,
    is_flash_sale BIT,
    status VARCHAR(20),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(subcategory_id)
);

-- Tạo bảng ProductSkus
CREATE TABLE product_skus (
    product_sku_id INT PRIMARY KEY IDENTITY(1,1),
    product_id INT,
    size_id INT,
    color_id INT,
    sku VARCHAR(50) UNIQUE,
    price DECIMAL(10, 2),
    quantity INT,
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (size_id) REFERENCES product_attribute(product_attribute_id),
    FOREIGN KEY (color_id) REFERENCES product_attribute(product_attribute_id)
);

-- Tạo bảng Review
CREATE TABLE review (
    review_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    product_id INT,
    rating INT,
    comment TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES [user](user_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Tạo bảng Voucher
CREATE TABLE voucher (
    voucher_id INT PRIMARY KEY IDENTITY(1,1),
    voucher_type VARCHAR(50),
    cost DECIMAL(10, 2),
    name VARCHAR(100),
    code VARCHAR(50) UNIQUE,
    usage_quantity INT,
    quantity INT,
    percentage DECIMAL(5, 2),
    min_basket_price DECIMAL(10, 2),
    max_basket_price DECIMAL(10, 2),
    max_discount DECIMAL(10, 2),
    start_at DATETIME,
    end_at DATETIME,
    status VARCHAR(20)
);

-- Tạo bảng PaymentDetail
CREATE TABLE payment_detail (
    payment_id INT PRIMARY KEY IDENTITY(1,1),
    amount DECIMAL(10, 2),
    provider VARCHAR(50),
    transaction_code VARCHAR(100),
    status VARCHAR(20),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tạo bảng Order
CREATE TABLE [order] (
    order_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    payment_id INT,
    voucher_id INT,
    delivery_fee DECIMAL(10, 2),
    status VARCHAR(20),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    email_sent BIT,
    is_preorder BIT,
    preorder_type VARCHAR(50),
    paid_amount DECIMAL(10, 2),
    remaining_amount DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES [user](user_id),
    FOREIGN KEY (payment_id) REFERENCES payment_detail(payment_id),
    FOREIGN KEY (voucher_id) REFERENCES voucher(voucher_id)
);

-- Tạo bảng OrderDetail
CREATE TABLE order_detail (
    id INT PRIMARY KEY IDENTITY(1,1),
    order_id INT,
    product_id INT,
    product_sku_id INT,
    quantity INT,
    discount DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES [order](order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (product_sku_id) REFERENCES product_skus(product_sku_id)
);
