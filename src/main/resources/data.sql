
--setup initial data
-- setup TOPPING table data
insert into TOPPING
values(1000,'SAN_MARZANO_TOMATO', 2.50);

insert into TOPPING
values(2000,'ROMA_TOMATO', 2.00);

insert into TOPPING
values(3000,'OLIVE_OIL', 2.00);

insert into TOPPING
values(4000,'PEPPERONI', 2.50);

insert into TOPPING
values(5000,'MUSHROOM', 1.50);

insert into TOPPING
values(6000,'CANADIAN_BACON', 3.50);


-- Setup INVENTORY table data

insert into INVENTORY
values(1000, 500, 1, 1000);

insert into INVENTORY
values(2000, 400, 1, 2000);

insert into INVENTORY
values(3000, 500, 1, 3000);

insert into INVENTORY
values(4000, 100, 1, 4000);

insert into INVENTORY
values(5000, 500, 1, 5000);


insert into INVENTORY
values(6000, 500, 1, 6000);

-- Setup some initial PROMOTION table data

INSERT INTO PROMOTION (PROMOTION_ID, PROMOTION_CODE, CREATED_DATE, EXPIRY_DATE, PERCENTAGE_OFF) VALUES(1000, '10_PERCENT_OFF_DEAL', CURRENT_DATE,
parsedatetime('01-01-2020 00:00:00.00', 'dd-MM-yyyy hh:mm:ss.SS'), 10);

INSERT INTO PROMOTION (PROMOTION_ID, PROMOTION_CODE, CREATED_DATE, EXPIRY_DATE, PERCENTAGE_OFF) VALUES(2000, 'SUPER_BOWL_DEAL', CURRENT_DATE,
parsedatetime('01-01-2020 00:00:00.00', 'dd-MM-yyyy hh:mm:ss.SS'), 50);
