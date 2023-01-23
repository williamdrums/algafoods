-- set cozinha
insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Francesa');
insert into cozinha (id, nome) values (4, 'Italiana');



-- set restaurante
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet',10,1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery',9.50,1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana',15,2);


-- set estado
insert into estado (id, nome) values (1,'Mato Grosso do Sul');
insert into estado (id, nome) values  (2, 'São Paulo');

