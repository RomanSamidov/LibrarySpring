-- insert into role values (default, 'admin');
-- insert into role values (default, 'librarian');
-- insert into role values (default, 'reader');

-- insert into status values (default, 'created');
-- insert into status values (default, 'preparing');
-- insert into status values (default, 'ready');

insert into "user" values (default, 'Admin', '2000-12-11', 1, 'admin1@gmail.com', default, default, 'admin1');
insert into "user" values (default, 'Librarian', '2000-12-11', 2, 'librarian1@gmail.com', default, default, 'librarian1');
insert into "user" values (default, 'Librarian', '2000-12-11', 2, 'librarian2@gmail.com', default, default, 'librarian2');

insert into "user" values (default, 'user4', '2000-12-11', 3, 'email4@gmail.com', default, default, 'login4');
insert into "user" values (default, 'user5', '2000-12-11', 3, 'email5@gmail.com', default, default, 'login5');
insert into "user" values (default, 'user6', '2000-12-11', 3, 'email6@gmail.com', default, default, 'login6');
insert into "user" values (default, 'user7', '2000-12-11', 3, 'emai7@gmail.com', default, default, 'login7');
insert into "user" values (default, 'user8', '2000-12-11', 3, 'email8@gmail.com', default, default, 'login8');
insert into "user" values (default, 'user9', '2000-12-11', 3, 'email9@gmail.com', default, default, 'login9');
insert into "user" values (default, 'user10', '2000-12-11', 3, 'email10@gmail.com', default, default, 'login10');
insert into "user" values (default, 'user11', '2000-12-11', 3, 'email11@gmail.com', default, default, 'login11');
insert into "user" values (default, 'user12', '2000-12-11', 3, 'email12@gmail.com', default, default, 'login12');
insert into "user" values (default, 'user13', '2000-12-11', 3, 'email13@gmail.com', default, default, 'login13');
insert into "user" values (default, 'user14', '2000-12-11', 3, 'email14@gmail.com', default, default, 'login14');
insert into "user" values (default, 'user15', '2000-12-11', 3, 'email15@gmail.com', default, default, 'login15');
insert into "user" values (default, 'user16', '2000-12-11', 3, 'email16@gmail.com', default, default, 'login16');
insert into "user" values (default, 'user17', '2000-12-11', 3, 'email17@gmail.com', default, default, 'login17');
insert into "user" values (default, 'user18', '2000-12-11', 3, 'email18@gmail.com', default, default, 'login18');
insert into "user" values (default, 'user19', '2000-12-11', 3, 'email19@gmail.com', default, default, 'login19');
insert into "user" values (default, 'user20', '2000-12-11', 3, 'email20@gmail.com', default, default, 'login20');
insert into "user" values (default, 'user21', '2000-12-11', 3, 'email21@gmail.com', default, default, 'login21');


insert into block values (21);


insert into password values (1, 'password');
insert into password values (2, 'password');
insert into password values (3, 'password');
insert into password values (4, 'password');
insert into password values (5, 'password');
insert into password values (6, 'password');
insert into password values (7, 'password');
insert into password values (8, 'password');
insert into password values (9, 'password');
insert into password values (10, 'password');
insert into password values (11, 'password');
insert into password values (12, 'password');
insert into password values (13, 'password');
insert into password values (14, 'password');
insert into password values (15, 'password');
insert into password values (16, 'password');
insert into password values (17, 'password');
insert into password values (18, 'password');
insert into password values (19, 'password');
insert into password values (20, 'password');
insert into password values (21, 'password');


insert  into author values (default, 'author1');
insert  into author values (default, 'author2');
insert  into author values (default, 'author3');
insert  into author values (default, 'author4');
insert  into author values (default, 'author5');


insert  into publisher values (default, 'publisher1');
insert  into publisher values (default, 'publisher2');
insert  into publisher values (default, 'publisher3');
insert  into publisher values (default, 'publisher4');
insert  into publisher values (default, 'publisher5');


insert into book values (default, 19, 0, 'book1', 1, 1, 1999);
insert into book values (default, 18, 0, 'book2', 1, 2, 2000);
insert into book values (default, 17, 0, 'book3', 1, 3, 2001);
insert into book values (default, 16, 0, 'book4', 1, 4, 2002);
insert into book values (default, 15, 0, 'book5', 1, 5, 2003);
insert into book values (default, 14, 0, 'book6', 2, 1, 2004);
insert into book values (default, 13, 0, 'book7', 2, 2, 2009);
insert into book values (default, 12, 0, 'book8', 2, 3, 2008);
insert into book values (default, 11, 2, 'book9', 2, 4, 2007);
insert into book values (default, 29, 2, 'book10', 2, 5, 2006);
insert into book values (default, 28, 2, 'book11', 3, 1, 2005);
insert into book values (default, 27, 2, 'book12', 3, 2, 2004);
insert into book values (default, 26, 2, 'book13', 3, 3, 2003);
insert into book values (default, 25, 0, 'book14', 3, 4, 2002);
insert into book values (default, 24, 0, 'book15', 3, 5, 2001);
insert into book values (default, 22, 0, 'book16', 4, 1, 2009);
insert into book values (default, 23, 0, 'book17', 4, 2, 2008);
insert into book values (default, 21, 0, 'book18', 4, 3, 2007);
insert into book values (default, 19, 0, 'book19', 4, 4, 2006);
insert into book values (default, 18, 0, 'book20', 4, 5, 2005);
insert into book values (default, 17, 0, 'book21', 5, 1, 2004);
insert into book values (default, 14, 0, 'book22', 5, 2, 2003);
insert into book values (default, 15, 0, 'book23', 5, 3, 2009);
insert into book values (default, 16, 0, 'book24', 5, 4, 2007);
insert into book values (default, 19, 0, 'book25', 5, 5, 2006);


insert into history values (default, 4, 1, '2023-07-15', '2023-07-20');
insert into history values (default, 5, 2, '2023-06-15', '2023-06-20');
insert into history values (default, 6, 3, '2023-05-15', '2023-05-20');
insert into history values (default, 7, 4, '2023-04-15', '2023-04-20');
insert into history values (default, 8, 5, '2023-03-15', '2023-03-20');
insert into history values (default, 9, 6, '2023-02-15', '2023-02-20');
insert into history values (default, 10, 7, '2023-01-15', '2023-01-20');
insert into history values (default, 11, 8, '2023-08-15', '2023-08-20');
insert into history values (default, 12, 9, '2023-09-15', '2023-09-20');
insert into history values (default, 13, 10, '2023-10-15', '2023-10-20');
insert into history values (default, 14, 11, '2023-11-15', '2023-11-20');
insert into history values (default, 15, 12, '2023-12-15', '2023-12-20');
insert into history values (default, 16, 13, '2023-07-01', '2023-07-03');
insert into history values (default, 17, 14, '2023-07-02', '2023-07-04');
insert into history values (default, 18, 15, '2023-07-03', '2023-07-05');
insert into history values (default, 19, 16, '2023-07-04', '2023-07-06');
insert into history values (default, 20, 18, '2023-07-05', '2023-07-07');
insert into history values (default, 21, 17, '2023-07-06', '2023-07-09');


insert into cart values (4, 1, 2);
insert into cart values (4, 2, 3);
insert into cart values (4, 3, 4);


insert into "order" values (default, 4, '2023-12-06', 1);


insert into order_book values (1, 4, 2);
insert into order_book values (1, 3, 3);
insert into order_book values (1, 2, 5);
insert into order_book values (1, 1, 5);
insert into order_book values (1, 6, 5);


insert into user_book values (default, 4, 9, 2, '2023-07-06', '2023-07-07');
insert into user_book values (default, 4, 10, 2, '2023-07-07', '2023-07-08');
insert into user_book values (default, 4, 11, 2, '2023-07-08', '2023-07-09');
insert into user_book values (default, 4, 12, 2, '2023-07-09', '2023-07-10');
insert into user_book values (default, 4, 13, 2, '2023-07-10', '2023-07-11');


insert into tag values (default, 'tag1');
insert into tag values (default, 'tag2');
insert into tag values (default, 'tag3');
insert into tag values (default, 'tag4');
insert into tag values (default, 'tag5');


insert into book_tag values (1, 1);
insert into book_tag values (2, 2);
insert into book_tag values (3, 3);
insert into book_tag values (4, 4);
insert into book_tag values (5, 5);
insert into book_tag values (6, 4);
insert into book_tag values (7, 3);
insert into book_tag values (8, 2);
insert into book_tag values (9, 1);
insert into book_tag values (10, 2);
insert into book_tag values (11, 3);
insert into book_tag values (12, 4);
insert into book_tag values (13, 5);
insert into book_tag values (14, 1);
insert into book_tag values (15, 4);
insert into book_tag values (16, 3);
insert into book_tag values (17, 2);
insert into book_tag values (18, 5);
insert into book_tag values (19, 4);
insert into book_tag values (20, 3);
insert into book_tag values (21, 2);
insert into book_tag values (22, 1);
insert into book_tag values (23, 5);
insert into book_tag values (24, 2);
insert into book_tag values (25, 3);


