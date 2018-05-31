create schema accountant_logging; 
create table accountant_logging.hibernate_sequence (next_val bigint) engine=MyISAM;
insert into accountant_logging.hibernate_sequence values ( 1 );
create table accountant_logging.log_messages (id bigint not null, message varchar(255), primary key (id)) engine=MyISAM;
ALTER USER root IDENTIFIED WITH mysql_native_password BY 'Pass1234';