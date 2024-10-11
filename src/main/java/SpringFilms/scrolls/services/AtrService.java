package SpringFilms.scrolls.services;

import SpringFilms.scrolls.entities.Actor;
import SpringFilms.scrolls.entities.ArtMan;
import SpringFilms.scrolls.entities.Film;
import SpringFilms.scrolls.entities.FilmDirector;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AtrService {
    List<ArtMan> artMEN = new ArrayList<>();


    public List<FilmDirector> getAllListDir() {
        return artMEN.stream().filter(artMan -> artMan instanceof FilmDirector).map(artMan -> (FilmDirector)artMan).toList();
    }

    public List<Actor> getAllListActors() {
        return artMEN.stream().filter(artMan -> artMan instanceof Actor).map(artMan -> (Actor)artMan).toList();
    }

    @PostConstruct  //аннотация, которая говорит Спрингу, что данный метод нужно вызвать для иницализации
    //после создания бина
    public void fill(){
        try{
            artMEN.add(new FilmDirector(1960, "Уайт", "Джон"));
            artMEN.add(new Actor(1975, "ДиКаприо", "Леонард"));
        } catch (Exception e) {
            System.out.println("Что-то не так с заполнением списка "+e.getMessage());
        }

    }

    public void addArt(ArtMan artMan){
        artMEN.add(artMan);

    }

    public ArtMan findFirstByName(String s){
        for (ArtMan a: artMEN)
            //if(p.getName().equals(s))
            if (a.getName().equalsIgnoreCase(s))
                return a;
        return null;
    }

    public List<ArtMan> filterByName(String s){
        return artMEN.stream().filter(p->p.getName().equals(s)).toList();
    }

}