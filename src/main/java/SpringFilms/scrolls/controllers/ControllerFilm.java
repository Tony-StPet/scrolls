package SpringFilms.scrolls.controllers;

import SpringFilms.scrolls.entities.ArtMan;
import SpringFilms.scrolls.entities.Film;
import SpringFilms.scrolls.entities.FilmDirector;
import SpringFilms.scrolls.services.AtrService;
import SpringFilms.scrolls.services.FilmService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerFilm {

    @Autowired
    FilmService filmService;

    @Autowired
    AtrService atrService;


    @GetMapping("/catalog")
    public String showCatalog(Model model){
        List<Film> spisok = filmService.getAllList();
        System.out.println("spisok = " + spisok);
        model.addAttribute("spisok_film", spisok);
        return "catalog";        //передаем шаблон, который уже будет работать с model
    }

    @GetMapping("/new_film")
    public String newFilm(){
        return "new_film";        //передаем шаблон
    }

    @GetMapping("/save_new_film")
    public String saveNewDir(@RequestParam(name = "name")   String name,
                             @RequestParam(name = "genre") String genre,
                             @RequestParam(name = "year") String strInt,
                             @RequestParam(name = "director") String dir,
                             Model model){
        if(name != null && genre != null && strInt !=null) {
            try{
                int year = Integer.parseInt(strInt);
                FilmDirector director = (FilmDirector) atrService.findFirstByName(dir);
                if (director==null)
                {
                    atrService.addArt(new ArtMan(0, dir, ""));
                    director = (FilmDirector) atrService.findFirstByName(dir);
                }

                Film film = new Film(name, genre, year,director);
                filmService.addFilm(film);

                System.out.println("film = " + name + genre + year);


            } catch (Exception e) {
                System.out.println("все пропало "+e.getMessage());
            }
        }

        return "redirect:/directorscatalog";     //перенаправление заставляет клиента (браузер)
        //забыть предыдущий http-запрос и его параметры
    }

    @GetMapping("/find_film")
    public String findFilm(@RequestParam(name = "s", required = false) String s, Model model){
        if(s == null || s.isEmpty() || s.isBlank())
            return "catalog";

        Film film = filmService.findFirstByName(s);
        System.out.println("film = " + film);
        model.addAttribute("film", film);
        return "film_info";
    }

}
