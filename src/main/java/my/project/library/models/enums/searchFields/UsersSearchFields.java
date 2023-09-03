package my.project.library.models.enums.searchFields;

import my.project.library.models.enums.sortings.ISorting;
import org.springframework.data.domain.Sort;

public enum UsersSearchFields implements ISearchFields {

    email("email"),
    login("login"),
    name("name");

    private final String property;


    UsersSearchFields(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

}
