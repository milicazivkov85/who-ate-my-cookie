package de.codecentric.eater.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRest {

    @RequestMapping(method = RequestMethod.GET)
    public Object getUsername(Principal user) {
        Map map = new HashMap<String, String>();
        map.put("username", user.getName());
        return map;
    }
}
