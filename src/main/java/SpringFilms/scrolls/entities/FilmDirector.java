package SpringFilms.scrolls.entities;

public class FilmDirector extends ArtMan {

    public FilmDirector(int age, String secondName, String name) {
        super(age, secondName, name);
    }

    @Override
    public String getMoney(){
        return "мой рабочий день стоит big money";
    }

    @Override
    public String toString() {
        return name + '\'' +  " " + secondName + '\'' +  ", age=  " + age + '}';    }



}
