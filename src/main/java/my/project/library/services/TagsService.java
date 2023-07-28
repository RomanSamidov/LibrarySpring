package my.project.library.services;

import my.project.library.models.Tag;
import my.project.library.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TagsService {
    private final TagsRepository tagsRepository;

    @Autowired
    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    public Optional<Tag> findOne(String name){
        return tagsRepository.findByNameOrderById(name).stream().findFirst();
    }

    public List<Tag> findAllStartingWith(String startingWith){
        return tagsRepository.findByNameStartingWithOrderById(startingWith);
    }


    public List<Tag> findAll(){
        return tagsRepository.findAll();
    }

    public Optional<Tag> findOne(long id){
        return tagsRepository.findById(id);
    }

    @Transactional
    public void save(Tag tag){
        tagsRepository.save(tag);
    }

    @Transactional
    public void update(long id, Tag tag){
        tag.setId(id);
        tagsRepository.save(tag);
    }

    @Transactional
    public void delete(long id){
        tagsRepository.deleteById(id);
    }
}
