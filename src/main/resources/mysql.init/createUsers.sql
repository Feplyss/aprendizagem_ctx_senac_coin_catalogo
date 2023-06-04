CREATE USER 'senac_coin'@'localhost' IDENTIFIED BY 'mypass';
CREATE USER 'senac_coin'@'%' IDENTIFIED BY 'mypass';
GRANT ALL PRIVILEGES ON senacCoin.* TO 'senac_coin'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;