package my.project.library.models.enums.sortings;

import org.springframework.data.domain.Sort;

public enum UsersSorting implements ISorting {

    id_asc(Sort.Direction.ASC, "id"),
    id_desc(Sort.Direction.DESC, "id"),
    date_of_birth_asc(Sort.Direction.ASC, "date_of_birth"),
    date_of_birth_desc(Sort.Direction.DESC, "date_of_birth"),
    email_asc(Sort.Direction.ASC, "email"),
    email_desc(Sort.Direction.DESC, "email"),
    login_asc(Sort.Direction.ASC, "login"),
    login_desc(Sort.Direction.DESC, "login"),
    name_asc(Sort.Direction.ASC, "name"),
    name_desc(Sort.Direction.DESC, "name");

    private final Sort.Direction direction;
    private final String properties;


    UsersSorting(Sort.Direction direction, String properties) {
        this.direction = direction;
        this.properties = properties;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public String getProperty() {
        return properties;
    }



}
