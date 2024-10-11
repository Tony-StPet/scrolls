package SpringFilms.scrolls.controllers;

import SpringFilms.scrolls.entities.ArtMan;
import SpringFilms.scrolls.entities.Film;
import SpringFilms.scrolls.entities.FilmDirector;
import SpringFilms.scrolls.services.AtrService;
import SpringFilms.scrolls.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerArt {

    @Autowired
    AtrService atrService;

    @GetMapping("/directorscatalog")
    public String showDirectors(Model model){
        List<FilmDirector> spisokD = atrService.getAllListDir();
        System.out.println("spisokD = " + spisokD);
        model.addAttribute("spisok_directors", spisokD);
        return "directorscatalog";        //передаем шаблон, который уже будет работать с model
    }

    @GetMapping("/new_director")
    public String newDir(){
        return "new_director";        //передаем шаблон
    }

    @GetMapping("/save_new_director")
    public String saveNewDir(@RequestParam(name = "name")   String name,
                             @RequestParam(name = "secondName") String secondName,
                             @RequestParam(name = "age") String strInt, Model model){
        if(name != null && secondName != null && strInt !=null) {
            try{
                int age = Integer.parseInt(strInt);
                ArtMan artMan = new FilmDirector(age, secondName, name);
                System.out.println("artMan = " + artMan);
                atrService.addArt(artMan);
                
            } catch (Exception e) {
                System.out.println("все пропало "+e.getMessage());
            }
        }

        return "redirect:/directorscatalog";     //перенаправление заставляет клиента (браузер)
        //забыть предыдущий http-запрос и его параметры
    }

    @GetMapping("/find_director")
    public String findDir(@RequestParam(name = "s", required = false) String s, Model model){
        if(s == null || s.isEmpty() || s.isBlank())
            return "directorscatalog";

        ArtMan artMan = atrService.findFirstByName(s);
        System.out.println("artMan = " + artMan);
        model.addAttribute("director", artMan);
        return "director_info";
    }

}
