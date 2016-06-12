create or replace 
trigger trg_customer
before insert or update
on customer
referencing old as oldRow new as newRow
for each row
declare
begin
  if(0 >= :newRow.credit) then
    raise_application_error(-20999, 'the new credit: '|| :newRow.credit ||' unacceptable!');
  end if;
  
  if(updating) then
    if(:newRow.credit <= 0) then
      raise_application_error(-20998, 'du null');
    end if;
  end if;    
end trg_customer;