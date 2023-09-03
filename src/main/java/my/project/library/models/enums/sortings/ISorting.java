package my.project.library.models.enums.sortings;

import org.springframework.data.domain.Sort;

public interface ISorting {

    public Sort.Direction getDirection();

    public String getProperty();
}
