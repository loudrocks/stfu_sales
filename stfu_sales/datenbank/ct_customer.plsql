create or replace 
procedure ct_customer is
  v_tabcnt number;
  
begin
  select count(*) into v_tabcnt from all_tables
  where table_name = 'customer' and owner = user;
  
  if v_tabcnt = 0 then
  execute immediate 'create table customer(
    customer_id integer,
    first_name varchar2(30),
    credit decimal(10,2),
    constraint customer_pk primary key (customer_id))';
    commit;
  end if;
end ct_customer;