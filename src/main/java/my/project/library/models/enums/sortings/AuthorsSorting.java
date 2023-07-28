package my.project.library.models.enums.sortings;

import org.springframework.data.domain.Sort;

public enum AuthorsSorting implements ISorting {

    id_asc(Sort.Direction.ASC, "id"),
    id_desc(Sort.Direction.DESC, "id"),
    name_asc(Sort.Direction.ASC, "name"),
    name_desc(Sort.Direction.DESC, "name");

    private final Sort.Direction direction;
    private final String properties;


    AuthorsSorting(Sort.Direction direction, String properties) {
        this.direction = direction;
        this.properties = properties;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public String getProperties() {
        return properties;
    }



}
