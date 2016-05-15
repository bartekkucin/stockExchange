
insert into companyentity(id, company_name) values (1, 'test');
insert into share(id,price, sharedate,companyid) values (1, 123, '2013-02-02', 1);
insert into share(id,price, sharedate,companyid) values (2, 123, '2013-02-03', 1);

--insert into bank_account(id, client_number, currency_type, amount) values (1, 123, 'PLN', 10000.00);

--BULK INSERT stock FROM 'C:\Users\BKUCINSK\workspace6\stockExchange\src\main\resources\dane.csv' WITH (FIRSTROW = 2, FIELDTERMINATOR = ',', ROWTERMINATOR = '\n', ERRORFILE = 'C:\CSVDATA\SchoolsErrorRows.csv',TABLOCK);