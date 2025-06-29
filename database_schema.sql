create database bankSystem;
use bankSystem; 
create table signup(form_no varchar(30), name varchar(30), father_name varchar(30), DOB varchar(30), gender varchar(30), email varchar(60), marital_status varchar(30), address varchar(60), city varchar(30), pincode varchar(30), state varchar(50));
select * from signup;
create table signup2(form_no varchar(30), religion varchar(30), category varchar(30), income varchar(30), education varchar(30), occupation varchar(60), PAN_number varchar(30), Addhar_number varchar(60), senior_citizen varchar(30), existing_account varchar(30));
select * from signup2;
# ALTER TABLE signup2
# CHANGE Addhar_number Aadhar_number VARCHAR(30);
create table signup3(form_no varchar(30), account_type varchar(40), card_number varchar(30), PIN varchar(30), sevices_required varchar(200));
select * from signup3;
create table login(form_no varchar(30), card_number varchar(30), PIN varchar(30));
select * from login;

delete from login where PIN = 'null';


# SET SQL_SAFE_UPDATES = 0;                    very important 

delete from signup where form_no = '4925';


create table bank(PIN varchar(10), data varchar(50), type varchar(20), amount varchar(20));
select * from bank;
delete from bank where PIN = '';

ALTER TABLE bank CHANGE data date VARCHAR(50);



