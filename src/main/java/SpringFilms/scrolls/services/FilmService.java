package SpringFilms.scrolls.services;

import SpringFilms.scrolls.entities.Actor;
import SpringFilms.scrolls.entities.ArtMan;
import SpringFilms.scrolls.entities.Film;
import SpringFilms.scrolls.entities.FilmDirector;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {
    @Autowired
    AtrService artService;

    List<Film> films = new ArrayList<>();

    public List<Film> getAllList() {
        return films;
    }

    @PostConstruct  //аннотация, которая говорит Спрингу, что данный метод нужно вызвать для иницализации
    //после создания бина
    public void fill(){
        try{
            addFilm(new Film("Дракула", "ужасы", 1997, new FilmDirector(1960, "Коппола", "Френсис")));
           addFilm(new Film("Война миров", "фантастика", 2010, new FilmDirector(1968, "камерон", "Джеймс")));

        } catch (Exception e) {
            System.out.println("Что-то не так с заполнением списка "+e.getMessage());
        }

    }
    public void addFilm(Film film){
        films.add(film);
        artService.addArt(film.getDirector());
    }

    public Film findFirstByName(String s){
        for (Film f: films)

            if (f.getName().equalsIgnoreCase(s))
                return f;
        return null;
    }

    public List<Film> filterByName(String s){
        return films.stream().filter(p->p.getName().equals(s)).toList();
    }

}
