-- postgres
DROP DATABASE IF EXISTS academic;
DROP USER IF EXISTS academic;

CREATE USER academic WITH PASSWORD 'academic';
CREATE DATABASE academic WITH ENCODING 'UTF8' LC_COLLATE ='C' LC_CTYPE ='C' TEMPLATE =template0;
GRANT ALL PRIVILEGES ON DATABASE academic to academic;