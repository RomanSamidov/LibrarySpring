package my.project.library.repositories;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

import my.project.library.models.Author;
import my.project.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface BooksRepository extends JpaRepository<Book, Long> {
//    List<Book> findByNameOrderById(String ful_name);
//
//    List<Book> findByNameStartingWithOrderById(String startingWith);
//}
