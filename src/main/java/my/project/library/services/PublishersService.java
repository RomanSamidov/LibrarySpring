package my.project.library.services;

import my.project.library.models.Publisher;
import my.project.library.repositories.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PublishersService {
    private final PublishersRepository publishersRepository;

    @Autowired
    public PublishersService(PublishersRepository publishersRepository) {
        this.publishersRepository = publishersRepository;
    }

    public Optional<Publisher> findOne(String name){
        return publishersRepository.findByNameOrderById(name).stream().findFirst();
    }

    public List<Publisher> findAllStartingWith(String startingWith){
        return publishersRepository.findByNameStartingWithOrderById(startingWith);
    }


    public List<Publisher> findAll(){
        return publishersRepository.findAll();
    }

    public Optional<Publisher> findOne(long id){
        return publishersRepository.findById(id);
    }

    @Transactional
    public void save(Publisher publisher){
        publishersRepository.save(publisher);
    }

    @Transactional
    public void update(long id, Publisher publisher){
        publisher.setId(id);
        publishersRepository.save(publisher);
    }

    @Transactional
    public void delete(long id){
        publishersRepository.deleteById(id);
    }
}
