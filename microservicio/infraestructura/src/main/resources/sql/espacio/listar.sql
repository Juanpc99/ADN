select id,nombre,estado
from espacio
where estado = :estado
order by nombre;