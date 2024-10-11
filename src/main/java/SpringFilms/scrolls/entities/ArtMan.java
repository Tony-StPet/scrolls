package SpringFilms.scrolls.entities;

public class ArtMan {
    String name;
    String secondName;
    int age;

    public ArtMan(int age, String secondName, String name) {
        this.age = age;
        this.secondName = secondName;
        this.name = name;
    }
    public String getMoney() {
        return "мой рабочий день стоит money";
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }
}
