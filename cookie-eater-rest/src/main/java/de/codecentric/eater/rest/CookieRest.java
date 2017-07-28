package de.codecentric.eater.rest;

import de.codecentric.eater.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cookie")
public class CookieRest {

    @Autowired
    private CookieService cookieService;

    @RequestMapping(method = RequestMethod.GET)
    public List getCookies(Principal principal) {
        return cookieService.getCookies(principal.getName());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeCookie(@PathVariable Integer id) {
        cookieService.remove(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeAllCookiesFor(Principal principal) {
        cookieService.removeAllCookiesFor(principal.getName());
    }
}
