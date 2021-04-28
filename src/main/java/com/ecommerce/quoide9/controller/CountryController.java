package com.ecommerce.quoide9.controller;

import com.ecommerce.quoide9.dao.CountryDao;
import com.ecommerce.quoide9.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/country")
public class CountryController {

    private CountryDao countryDao;

    @Autowired
    public CountryController(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(countryDao.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addCountries() {


       /* for (Locale locale : Locale.getAvailableLocales()) {
            if (locale.getDisplayCountry().equals("") || locale.getCountry().equals(""))
                continue;
            Country c = new Country(locale.getDisplayCountry(), locale.getCountry());
            countryDao.save(c);
        }*/


        return ResponseEntity.created(URI.create("/country")
        ).build();
    }
}