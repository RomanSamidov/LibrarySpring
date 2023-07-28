package my.project.library.models.enums;

public enum Language {
    en_US(1),
    uk_UA(2);


    private int id;

    private Language(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
