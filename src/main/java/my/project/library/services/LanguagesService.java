package my.project.library.services;

import my.project.library.models.Language;
import my.project.library.repositories.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//            en_US(1),
//            uk_UA(2);

@Service
@Transactional(readOnly = true)
public class LanguagesService {

    public final Language ENGLISH;
    public final Language UKRAINIAN;

    private final LanguagesRepository languagesRepository;

    @Autowired
    public LanguagesService(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
        ENGLISH = findOne("en_US");
        UKRAINIAN = findOne("uk_UA");
    }

    public Language findOne(String name){
        return languagesRepository.findByName(name).stream().findFirst().orElseThrow( () -> new RuntimeException("Wrong LANGUAGE name was " + name));
    }


    public List<Language> findAll(){
        return languagesRepository.findAll();
    }

    public Language findOne(long id){
        return languagesRepository.findById(id).orElseThrow( () -> new RuntimeException("Wrong LANGUAGE id expected 1 or 2 but was " + id));
    }

}
