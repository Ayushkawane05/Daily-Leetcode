delete from person where id in(
select id from (
SELECT p2.id
FROM Person p1, Person p2
WHERE p1.email = p2.email
AND p1.id < p2.id) as duplicates)