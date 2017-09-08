package de.codecentric.eater.rest;

import de.codecentric.eater.service.EaterService;
import de.codecentric.eater.service.model.EaterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/eater")
public class EaterRest {

    @Autowired
    private EaterService eaterService;

    @RequestMapping(method = RequestMethod.GET)
    public EaterModel getUsername(Principal user) {
        return eaterService.findByUsername(user.getName());
    }
}
