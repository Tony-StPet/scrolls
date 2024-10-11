package SpringFilms.scrolls.entities;

import java.util.ArrayList;
import java.util.List;

public class Film {
    String name;
    String genre; // жанр
    int year;
    FilmDirector director;
    List<Actor> actorList = new ArrayList<>();

    public Film(String name, String genre, int year, FilmDirector director) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.director = director;
    }


    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", director=" + director +
                ", actorList=" + actorList +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public FilmDirector getDirector() {
        return director;
    }

    public List<Actor> getActorList() {
        return actorList;
    }
}
