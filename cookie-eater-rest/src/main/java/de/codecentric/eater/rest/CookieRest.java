package de.codecentric.eater.rest;

import de.codecentric.eater.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cookie")
public class CookieRest {

    @Autowired
    private CookieService cookieService;

    @RequestMapping(method = RequestMethod.GET)
    public List getCookies() {
        return cookieService.getCookies();
    }
}
