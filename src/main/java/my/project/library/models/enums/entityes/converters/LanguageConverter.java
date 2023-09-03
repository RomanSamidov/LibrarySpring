package my.project.library.models.enums.entityes.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import my.project.library.models.enums.entityes.Language;

//@Converter(autoApply = true)
//@Convert(converter = LanguageConverter.class)
public class LanguageConverter implements AttributeConverter<Language, Long> {
    @Override
    public Long convertToDatabaseColumn(Language attribute) {
        switch(attribute){
            case en_US -> {
                return 1L;
            }
            case uk_UA -> {
                return 2L;
            }
        }
        throw new IllegalArgumentException(attribute + " not supported.");
    }

    @Override
    public Language convertToEntityAttribute(Long dbData) {

        if (dbData == 1L) {
            return Language.en_US;
        } else if (dbData == 2L) {
            return Language.uk_UA;
        }
        throw new IllegalArgumentException(dbData + " not supported.");
    }
}
