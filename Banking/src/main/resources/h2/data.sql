-- Insert sample data for Customer_tbl table
INSERT INTO Customer_tbl_tbl (name) VALUES ('John Doe');
INSERT INTO Customer_tbl (name) VALUES ('Jane Smith');
INSERT INTO Customer_tbl (name) VALUES ('Alice');
INSERT INTO Customer_tbl (name) VALUES ('Bob');
INSERT INTO Customer_tbl (name) VALUES ('Charlie');
INSERT INTO Customer_tbl (name) VALUES ('David');
INSERT INTO Customer_tbl (name) VALUES ('Eva');
INSERT INTO Customer_tbl (name) VALUES ('Frank');
INSERT INTO Customer_tbl (name) VALUES ('Grace');
INSERT INTO Customer_tbl (name) VALUES ('Harry');

-- Insert sample data for Account_tbl table
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('12345678', 1000.00, 1);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('87654321', 2000.00, 2);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('11111111', 1500.00, 3);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('22222222', 2500.00, 4);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('33333333', 3500.00, 5);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('44444444', 4500.00, 6);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('55555555', 5500.00, 7);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('66666666', 6500.00, 8);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('77777777', 7500.00, 9);
INSERT INTO Account_tbl (account_number, balance, customer_id) VALUES ('88888888', 8500.00, 10);

-- Insert sample data for Transaction_tbl table
INSERT INTO Transaction_tbl (amount, account_id) VALUES (100.00, 1);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (200.00, 2);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (50.00, 3);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (75.00, 4);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (150.00, 5);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (300.00, 6);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (400.00, 7);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (500.00, 8);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (1000.00, 9);
INSERT INTO Transaction_tbl (amount, account_id) VALUES (2000.00, 10);