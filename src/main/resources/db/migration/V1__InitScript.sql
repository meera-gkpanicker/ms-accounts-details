create schema if not exists anz;

DROP TABLE IF EXISTS anz.account;
DROP TABLE IF EXISTS anz.account_transaction;

CREATE TABLE anz.account (
  account_id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  account_number varchar(255) NOT NULL,
  account_type varchar(255) NOT NULL,
  account_name varchar(255) NOT NULL,
  currency varchar(255) NOT NULL,
  balance_date date NOT NULL,
  balance decimal NOT NULL
);

INSERT INTO anz.account (account_number, account_type, account_name, currency, balance_date, balance) VALUES ( '123456', 'Savings', 'SGSavings 726', 'SGD', CURRENT_DATE, 12.45 );
INSERT INTO anz.account (account_number, account_type, account_name, currency, balance_date, balance) VALUES ( '123456', 'Savings', 'SGSavings 726', 'SGD', CURRENT_DATE, 12.45 );
INSERT INTO anz.account (account_number, account_type, account_name, currency, balance_date, balance) VALUES ( '123456', 'Savings', 'SGSavings 726', 'SGD', CURRENT_DATE, 12.45 );
INSERT INTO anz.account (account_number, account_type, account_name, currency, balance_date, balance) VALUES ( '123456', 'Savings', 'SGSavings 726', 'SGD', CURRENT_DATE, 12.45 );
INSERT INTO anz.account (account_number, account_type, account_name, currency, balance_date, balance) VALUES ( '123456', 'Savings', 'SGSavings 726', 'SGD', CURRENT_DATE, 12.45 );


CREATE TABLE anz.account_transaction (
  account_transaction_id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  account_number varchar(255) NOT NULL,
  account_name varchar(255) NOT NULL,
  value_date date NOT NULL,
  currency varchar(255) NOT NULL,
  debit_amount decimal NULL,
  credit_amount decimal NULL,
  transaction_type varchar(255) NOT NULL,
  tran_narrative varchar(255) NOT NULL
);


INSERT INTO anz.account_transaction (account_number, account_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');
INSERT INTO anz.account_transaction (account_number, account_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');
INSERT INTO anz.account_transaction (account_number, account_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');
INSERT INTO anz.account_transaction (account_number, account_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');
INSERT INTO anz.account_transaction (account_number, account_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');

COMMIT;