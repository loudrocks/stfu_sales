create or replace 
procedure ct_customer is
  v_tabcnt number;
  v_seqcnt number;
  
begin
  select count(*) into v_tabcnt from all_tables
  where table_name = 'customer' and owner = user;
  
  if v_tabcnt = 0 then
  execute immediate 'create table customer(
    customer_id integer,
    first_name varchar(30),
    credit decimal(10,2),
    constraint customer_pk primary key (customer_id))';
    commit;
  end if;
  
  select count(*) into v_seqcnt
  from all_sequences
  where sequence_name = 'seq_customer_id'
  and sequence_owner = user;

  if v_seqcnt = 0 then
   execute immediate 
   'create sequence seq_customer_id
   start with 1000
   increment by 1
   cache 20';
   commit;
  end if;
end ct_customer;