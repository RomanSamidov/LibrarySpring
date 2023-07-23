Task:
The local library wants to switch to digital accounting of books. So
you need to implement a web application for them.

Use Hibernate, Spring Data JPA.


Tables:
- role(id, name)
- language(id, name)
- user(id, full_name, date_of_birth, role_id, language_id, email, allow_letters, confirmed, login)
- block(user_id)
- password(user_id, password)


- author(id, full_name)
- publisher(id, name)
- book(id, quantity, occupied, title, author_id, publisher_id, year)
- tag(id, name)
- book_tag(book_id, tag_id)


- cart(user_id, book_id, quantity)
- status(id, name)
- order(id, user_id, appointment_time, status_id)
- order_book(order_id, book_id, quantity)
- type(id, name)
- user_book(id, user_id, book_id, quantity, type_id, date_of_issue, planned_date_of_release)
- history(id, user_id, book_id, date_of_issue, date_of_release)


User roles: 
- admin;
- librarian;
- reader.

Languages:
- en_US;
- uk_UA...

Order statuses: 
- created;
- preparing;
- ready.

Types:
- subscription,
- reading_room.


The project database name is library_db.


For the catalog the ability to sort books has to be implemented:
- by name;
- by author;
- by publication;
- by date of publication.

For the catalog the ability to filter books has to be implemented:
- by tags;
- by authors;
- by publications;
- by range for date of publication.


- Each book has own page in which reader see books quantity and occupied quantity.
- The book may be present in the library in one or more copies.
- The system keeps track of the available number of books.


An unregistered user can only see catalog of books.

Registered reader can:
- see catalog of books;
- add books to cart from catalog, if confirmed email and doesn't block;
- place an order from cart, and set time for order;
- will receive letters about his order(if allowed);
- see a personal profile that displays registration information,
  change parameters, and list of orders, taken books and history
  (if the date is overdue, the amount of the fine is displayed).

For librarian and administrator:
1) list of readers orders and possibility to change order's status;
2) set that they give books on a subscription or to the reading room;
3) set time period for book issuing;
4) see how much fine reader should to pay if the book is not returned within the specified period;
5) list of taken books with fine and button to take book;
6) list of readers and all information about them on their;
7) on book page see who taken it.

The system administrator has the rights:
1) add/delete/edit a book;
2) create/delete/edit users with any role;
3) block/unblock the user.

- Validate everything with @Valid и Spring Validator.
- Pagination for everything.
- Search in book catalog by text input by book name and author.
- Search in user list by text input by full name.