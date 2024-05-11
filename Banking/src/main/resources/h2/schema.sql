CREATE TABLE Customer_tbl (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Account_tbl (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES Customer(id)
);

CREATE TABLE Transaction_tbl (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    account_id BIGINT,
    FOREIGN KEY (account_id) REFERENCES Account(id)
);
