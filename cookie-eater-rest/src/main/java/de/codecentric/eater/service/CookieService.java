package de.codecentric.eater.service;

import de.codecentric.eater.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookieService {

    @Autowired
    private CookieRepository cookieRepository;

    public List getCookies() {
        return cookieRepository.findAll();
    }
}
