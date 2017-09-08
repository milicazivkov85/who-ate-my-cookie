package de.codecentric.eater.rest;

import de.codecentric.eater.service.ProfileService;
import de.codecentric.eater.service.model.ProfileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/profile")
public class EaterProfileRest {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ProfileModel getEaterProfile(Principal principal) {
       return profileService.getProfileFor(principal.getName());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateProfile(Principal principal, @RequestBody ProfileModel profileModel) {
        profileService.editProfile(principal.getName(), profileModel);
    }
}
