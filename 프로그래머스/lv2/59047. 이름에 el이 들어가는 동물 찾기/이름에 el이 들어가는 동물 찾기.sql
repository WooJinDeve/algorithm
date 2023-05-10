select ANIMAL_ID, NAME
    from animal_ins
    where name like '%el%'
    and animal_type = 'dog'
    order by name;