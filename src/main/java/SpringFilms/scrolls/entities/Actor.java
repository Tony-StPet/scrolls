package SpringFilms.scrolls.entities;

public class Actor extends ArtMan{
    public Actor(int age, String secondName, String name) {
        super(age, secondName, name);
    }
    @Override
    public String getMoney(){
        return "работаю за еду";
    }
}
