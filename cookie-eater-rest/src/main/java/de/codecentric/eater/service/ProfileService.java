package de.codecentric.eater.service;

import de.codecentric.eater.domain.EaterProfile;
import de.codecentric.eater.repository.EaterRepository;
import de.codecentric.eater.service.model.ProfileModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private EaterRepository eaterRepository;

    public void editProfile(String username, ProfileModel profileModel) {
        EaterProfile profile = new EaterProfile();
        BeanUtils.copyProperties(profileModel, profile);
        profile.setId(eaterRepository.getProfileIdByUsername(username));

        if (!profile.isEmailValid()) {
            throw new IllegalArgumentException("Email address is not valid");
        }

        if (profile.getId() == null) {
            throw new IllegalArgumentException("Id is not valid");
        }

        eaterRepository.update(profile);
    }

    public ProfileModel getProfileFor(String username) {
        EaterProfile profile = eaterRepository.findProfileByUsername(username);
        ProfileModel profileModel = new ProfileModel();
        BeanUtils.copyProperties(profile, profileModel);
        return profileModel;
    }
}
