package my.project.library.models.enums.entityes.converters;

import jakarta.persistence.AttributeConverter;
import my.project.library.models.enums.entityes.Authority;

//@Converter(autoApply = true)
//@Convert(converter = AuthorityConverter.class)
public class AuthorityConverter implements AttributeConverter<Authority, Long> {
    @Override
    public Long convertToDatabaseColumn(Authority attribute) {
        switch(attribute){
            case ROLE_ADMIN -> {
                return 1L;
            }
            case ROLE_LIBRARIAN -> {
                return 2L;
            }
            case ROLE_READER -> {
                return 3L;
            }
        }
        throw new IllegalArgumentException(attribute + " not supported.");
    }

    @Override
    public Authority convertToEntityAttribute(Long dbData) {

        if (dbData == 1L) {
            return Authority.ROLE_ADMIN;
        } else if (dbData == 2L) {
            return Authority.ROLE_LIBRARIAN;
        } else if (dbData == 3L) {
            return Authority.ROLE_READER;
        }
        throw new IllegalArgumentException(dbData + " not supported.");
    }
}
