//package my.project.library.services;
//
//import my.project.library.models.Book;
////import my.project.library.repositories.BooksRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
////@Service
////@Transactional(readOnly = true)
//public class BooksService {
//    private final BooksRepository booksRepository;
//
////    @Autowired
//    public BooksService(BooksRepository booksRepository) {
//        this.booksRepository = booksRepository;
//    }
//
//    public Optional<Book> findOne(String name){
//        return booksRepository.findByNameOrderById(name).stream().findFirst();
//    }
//
//    public List<Book> findAllStartingWith(String startingWith){
//        return booksRepository.findByNameStartingWithOrderById(startingWith);
//    }
//
//
//    public List<Book> findAll(){
//        return booksRepository.findAll();
//    }
//
//    public Optional<Book> findOne(long id){
//        return booksRepository.findById(id);
//    }
//
//    @Transactional
//    public void save(Book book){
//        booksRepository.save(book);
//    }
//
//    @Transactional
//    public void update(long id, Book book){
////        book.setId(id);
//        booksRepository.save(book);
//    }
//
//    @Transactional
//    public void delete(long id){
//        booksRepository.deleteById(id);
//    }
//}
