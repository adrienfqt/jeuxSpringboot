package com.example.jeux.service;

import com.example.jeux.db.Countries;
import com.example.jeux.db.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {

    @Autowired
    CountriesRepository countriesRepository;

    public Countries startGame(){
        return countriesRepository.findRandomCountry();
    }

    public boolean checkProposition(String capitale, Countries pays){
        if(capitale == pays.getCapitale()){
            return true;
        }else{
            return false;
        }
    }
}
