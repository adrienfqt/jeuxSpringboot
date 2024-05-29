package com.example.jeux.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries,Integer> {

    @Query(value = "SELECT * FROM countries ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Countries findRandomCountry();
}
