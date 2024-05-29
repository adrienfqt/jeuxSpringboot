package com.example.jeux.controller;

import com.example.jeux.db.Countries;
import com.example.jeux.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class GameController {

    @Autowired
    CountriesService countriesService;

    public static Countries pays;

    @GetMapping("games")
    public String startGame() {
        pays = countriesService.startGame();
        return pays.getPays();
    }

    @GetMapping("hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("play")
    public String play(@RequestParam String capital){
        if(countriesService.checkProposition(capital,pays)){
            return "Bien joué, bonne réponse";
        }else{
            return "Mauvaise réponse, il fallait répondre " + pays.getCapitale();
        }
    }

}
