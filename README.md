Task:
The local library wants to switch to digital accounting of books. So
you need to implement a web application for them. Librarians
should be able to register readers, issue them
books and release books (after the reader returns
book back to the library).


Use Hibernate, Spring Data JPA.


Tables:
User(id, full_name, date_of_birth, role_id, email, allow_letters, confirmed, login)
Password(user_id, password)
Role(id, name)

Book(id, quantity, occupied, title, author_id, publisher_id, year)
Author(id, full_name)
Publisher(id, name)
Tag(id, name)
book_tag(book_id, category_id)

Cart(user_id, book_id, quantity)
Order(id, user_id, appointment_time)
order_book(order_id, book_id, quantity)
user_book(id, user_id, book_id, quantity, date_of_issue, planned_date_of_release)
History(id, user_id, book_id, date_of_issue, date_of_release)



The project database name is library_db.


The reader registers in the system and then can:
- search (by author / title);
- place an order for a Book from the Catalog.
- An unregistered reader cannot order a book.
- For the catalog the ability to sort books has to be implemented:
- - by name;
- - by author;
- - by publication;
- - by date of publication.
- The librarian gives the reader a book on a subscription or to the reading room. 
- The book is issued to the reader for a certain period.
- If the book is not returned within the specified period, the reader will be fined.
- The book may be present in the library in one or more copies.
- The system keeps track of the available number of books.
- Each user has a personal account that displays registration information
And also:
- 1) for reader:
1) - list of books on the subscription and date of possible return (if the date is overdue, the amount of the fine is displayed);
2) 
3) for librarian:-
2) list of readers' orders;
2) - list of readers and their subscriptions.
- The system administrator has the rights:
- - adding / deleting a book, editing information about the book;
- - create / delete librarian;
- - blocking / unblocking the user.




Необходимый функционал:
1) Страницы добавления, изменения и удаления человека.
2) Страницы добавления, изменения и удаления книги
3) Страница со списком всех людей (люди кликабельные - при клике осуществляется
переход на страницу человека).
4) Страница со списком всех книг (книги кликабельные - при клике осуществляется
переход на страницу книги).
5) Страница человека, на которой показаны значения его полей и список книг, которые он
взял. Если человек не взял ни одной книги, вместо списка должен быть текст "Человек
пока не взял ни одной книги".
6) Страница книги, на которой показаны значения полей этой книги и имя человека,
который взял эту книгу. Если эта книга не была никем взята, должен быть текст "Эта
книга свободна".
7) На странице книги, если книга взята человеком, рядом с его именем должна быть кнопка
"Освободить книгу". Эта кнопка нажимается библиотекарем тогда, когда читатель
возвращает эту книгу обратно в библиотеку. После нажатия на эту кнопку книга снова
становится свободно и пропадает из списка книг человека.
8) На странице книги, если книга свободна, должен быть выпадающий список (<select>)
со всеми людьми и кнопка "Назначить книгу". Эта кнопка нажимается библиотекарем
тогда, когда читатель хочет забрать эту книгу домой. После нажатия на эту кнопку, книга
должна начать принадлежать выбранному человеку и должна появится в его списке
книг.
9) Все поля должны валидироваться - с помощью @Valid и Spring Validator, если это
требуется.


10) Добавить пагинацию для книг и людей.
11) Все сортировки и фильтри для кнниг и людей.
12) Создать страницу поиска книг и людей. Вводим в поле на странице начальные буквы
названия книги, получаем полное название книги и имя автора. Также, если
книга сейчас находится у кого-то, получаем имя этого человека.
13) Добавить автоматическую проверку на то, что человек просрочил возврат
книги.
