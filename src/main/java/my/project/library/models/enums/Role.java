package my.project.library.models.enums;

public enum Role {
    admin(1),
    librarian(2),
    reader(3);

    private int id;

    private Role(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
