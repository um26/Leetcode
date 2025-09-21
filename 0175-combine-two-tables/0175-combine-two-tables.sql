/* Write your PL/SQL query statement below */

select a.firstName, a.lastName, b.city, b.state 
from person a
left join address b on a.personId=b.personId;