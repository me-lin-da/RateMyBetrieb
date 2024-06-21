-- insert into rank(id,title,seeds,reduction,value_order,discount) values('805fc890-247d-4d61-a169-e6408f9e231c','bronze',0,1,0,0);
-- insert into rank(id,title,seeds,reduction,value_order,discount) values('13e45fae-016c-4342-abb4-744ffc5628e9','silver',20,0.96,1,4);
-- insert into rank(id,title,seeds,reduction,value_order,discount) values('9ef05303-146e-405e-bed8-e481f6f085b1','gold',60,0.93,2,7);
-- insert into rank(id,title,seeds,reduction,value_order,discount) values('131e912c-f211-4526-b362-ffa44743da9d','platinum',140,0.91,3,9);
-- insert into rank(id,title,seeds,reduction,value_order,discount) values('ea83a03e-6326-4020-a721-1d1f0715ef36','diamond',300,0.9,4,10);
--
-- insert into country(id, country)values('b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','china');
-- insert into country(id, country)values('76ff2095-2bd5-455b-9b1a-6d71cfa986b7','taiwan');
-- insert into country(id, country)values('16ded094-2341-49bd-85ae-78451faac49f','japan');
-- insert into country(id, country)values('6bed40bc-1f21-4126-9046-5bdb208cd7e4','indien');
--
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','1e12b05a-2915-447b-a8a1-6bbd5864e8cd','white');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','4d195cc9-9491-4b62-b1d4-b16c76cc9c8b','yellow');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (18,'805fc890-247d-4d61-a169-e6408f9e231c','d64dc94d-33be-4855-ae43-79194dcea7fe','medicinal herbs');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','09b1cf5b-2426-4b31-8a18-c68adfcc9dcb','green');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','1d2e4628-91a0-49cd-8dd5-b67267c6ff1c','ripened');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','4d731a42-bc28-4f2f-9dc4-78e8498cfc0f','scented');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','072667ca-852f-4775-ac2c-049acde27718','matcha');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','16ff9d0b-1c35-4b62-a655-19f79e905f09','black');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','de07ede6-b210-4707-8c9e-5223e3d66ba6','tisanes');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'805fc890-247d-4d61-a169-e6408f9e231c','1085142b-b7f2-4bcd-a44f-e4798744faaf','functional blends');
-- insert into tea_type(age_restriction, required_rank, id, tea_type) values (1,'131e912c-f211-4526-b362-ffa44743da9d','0b227894-f73d-4e2c-9fed-d9167c88b1db','raw puerh');
-- insert into tea_type(age_restriction, id, tea_type, required_rank) values (1,'005956c8-7494-4df8-8e6e-a9492d19c982','oolong', '131e912c-f211-4526-b362-ffa44743da9d');
--
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(20,'a47d9683-2aed-42a3-846f-ccea365c7c9d','2021-04-23', 34,'white jasmine','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','1e12b05a-2915-447b-a8a1-6bbd5864e8cd');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(30,'4b484dad-fab1-4833-99a1-9060e44b7556','2021-04-14', 31,'amber mountain','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','4d195cc9-9491-4b62-b1d4-b16c76cc9c8b');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(13,'aec9da51-98ff-4079-bc05-9f9805939282','2021-04-01', 125, 'mist pilgrim','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','0b227894-f73d-4e2c-9fed-d9167c88b1db');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(45,'ab5acc7d-2826-449c-b5d2-90c60467f653','2021-05-01',53, 'ceremonial matcha tea','16ded094-2341-49bd-85ae-78451faac49f','09b1cf5b-2426-4b31-8a18-c68adfcc9dcb');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(21,'d37993db-1f5d-4112-b918-267985693245','2021-05-03',11,'dandelion leaf','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','d64dc94d-33be-4855-ae43-79194dcea7fe');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(12,'dc852512-f356-4132-ba8a-52edbd68eb5d','2021-04-02',50,'amber gaba oolong','76ff2095-2bd5-455b-9b1a-6d71cfa986b7','005956c8-7494-4df8-8e6e-a9492d19c982');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(7,'fac6b968-827b-4561-a7d2-32991230e3db','2021-05-01',36,'mulberry leaf powder','16ded094-2341-49bd-85ae-78451faac49f','de07ede6-b210-4707-8c9e-5223e3d66ba6');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(3,'11276c0e-195e-11ed-861d-0242ac120002','2021-04-01', 54,'river high','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','1085142b-b7f2-4bcd-a44f-e4798744faaf');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(3,'20f4984f-b376-4523-895c-47fe147e71ec','1996-05-01',45,'black yunnan tuo 96','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','1d2e4628-91a0-49cd-8dd5-b67267c6ff1c');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(12,'d7eb2c65-c74d-47e9-aa0e-7a7be3ce8304','2021-04-01',42,'traditional lapsang blending set','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','16ff9d0b-1c35-4b62-a655-19f79e905f09');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(66,'fc0409ba-dc09-411f-add2-709870715be1','2021-04-1',54,'ren shen wulong','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','4d731a42-bc28-4f2f-9dc4-78e8498cfc0f');
-- insert into tea(amount_in_stock,id, harvest_date, price,description, country_id, tea_type_id) values(122,'9167ba4f-5374-4f08-bae5-489d3d06e53a','2021-02-01', 33, 'juice journo','b0dd49e3-d4f7-4bf0-91bd-f70930c02fc0','4d731a42-bc28-4f2f-9dc4-78e8498cfc0f');
--
insert into role(id, name) values('48608063-985b-496d-94c6-1df46bb3ba26','ADMIN');
insert into role(id, name) values('ce7c3462-23f3-4c37-a75b-b945367f59ae','USER');

insert into authority(id, name) values('3648810a-6722-4e70-9667-69409afc699d','USER_SEE');
insert into authority(id, name) values('5fc20c1e-afbc-4e22-804b-85bf0b828b56','USER_MODIFY');
insert into authority(id, name) values('94f30ecd-8f8c-4a15-acdf-08d020496305','PRODUCT_SEE');
insert into authority(id, name) values('4b69915b-62f9-415b-ad8f-c48651b38aee', 'CAN_SEE_STATISTICS');


insert into role_authority(role_id, authority_id) values('48608063-985b-496d-94c6-1df46bb3ba26','3648810a-6722-4e70-9667-69409afc699d');
insert into role_authority(role_id, authority_id) values('48608063-985b-496d-94c6-1df46bb3ba26','5fc20c1e-afbc-4e22-804b-85bf0b828b56');
insert into role_authority(role_id, authority_id) values('48608063-985b-496d-94c6-1df46bb3ba26','94f30ecd-8f8c-4a15-acdf-08d020496305');
insert into role_authority(role_id, authority_id) values('ce7c3462-23f3-4c37-a75b-b945367f59ae','94f30ecd-8f8c-4a15-acdf-08d020496305');
insert into role_authority(role_id, authority_id) values('ce7c3462-23f3-4c37-a75b-b945367f59ae','3648810a-6722-4e70-9667-69409afc699d');
insert into role_authority(role_id, authority_id) values('48608063-985b-496d-94c6-1df46bb3ba26','4b69915b-62f9-415b-ad8f-c48651b38aee');

--
-- -- insert into orders(id, price, user_id) values('fdd3ac59-564e-4327-9c24-2dd52bfdf9b5',40,'c0a8db01-82f3-1c08-8182-f36c30280000');
-- -- insert into orders(id, price, user_id) values('3b442c14-5271-4543-8d90-b6f0b79c679a',5,'7f000101-82e9-1989-8182-e98c2a330008');
-- -- insert into orders(id, price, user_id) values('69166737-44c0-4930-8187-8ae6280694af',10,'7f000101-82e9-1989-8182-e98c2a330008');
-- -- insert into orders(id, price, user_id) values('23f46bbf-e3be-41b2-80d4-40ef2ed3c5ea',20,'7f000101-82e9-1989-8182-e98c2a330008');
insert into company (id, company_name, description) values ('fdd3ac59-564e-4327-9c24-2dd52bfdf9b7', 'NoserYoung', 'A part of the Noser Group');
insert into company (id, company_name, description) values ('fdd3ac59-564e-4327-9c24-2dd52bfdf9b2', 'Interdiscount', 'A division of COOP');
insert into review (id, text, title, company_id) values ('fdd3ac59-564e-4327-9c24-2dd52bfdf9b5', 'test', 'noser young isch cool', 'fdd3ac59-564e-4327-9c24-2dd52bfdf9b7');
insert into review (id, text, title, company_id) values ('fdd3ac59-564e-4327-9c24-2dd52bfdf9a5', 'test2', 'noser old isch cool', 'fdd3ac59-564e-4327-9c24-2dd52bfdf9b2');

insert into users (id, email, password, is_not_locked) values ('fdd3ac59-564e-4327-9c24-2dd52bfdf9a0', 'test@gmail.com', '$2a$10$8I6ttnD5LxTySiYnpZXjluIPUrJyInl10scwAKAH1PcS9Suuh5DKe', true);