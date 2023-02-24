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
insert into estado (id,nome) values (3,'Santa Catarina');



-- set cidade
insert into cidade (id,nome, estado_id) values(1,'Campo Grande',1);
insert into cidade (id, nome, estado_id) values (2, 'Birigui', 2);
insert into cidade (id, nome, estado_id) values (3,'Florianópolis',3);

-- set forma pagamento
insert into forma_pagamento (id,descricao) values (1,'CARTÃO DE CRÉDITO');
insert into forma_pagamento (id, descricao) values (2,'DÉBITO');
insert into forma_pagamento (id, descricao) values (3,'DINHEIRO');
insert into forma_pagamento (id, descricao) values (4,'PIX');

-- set permissao
insert into permissao (id, nome, descricao) values (1,'CONSULTAR_COZINHAS','Permite consulta');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS','Permite editar cozinha');


-- set restaurante_forma_pagamento
insert into restaurante_forma_pagamento(restaurante_id,forma_pagamento_id) values (1,1),(1,2),(1,3),(2,3),(3,2),(3,3);


