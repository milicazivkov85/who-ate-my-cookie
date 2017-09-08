package de.codecentric.eater.service;

import de.codecentric.eater.domain.EaterUser;
import de.codecentric.eater.repository.EaterRepository;
import de.codecentric.eater.service.model.EaterModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EaterService {

    @Autowired
    private EaterRepository eaterRepository;

    public EaterModel findByUsername(String userName) {
        EaterModel eaterModel = new EaterModel();
        EaterUser eaterUser = eaterRepository.findByUsername(userName);
        BeanUtils.copyProperties(eaterUser, eaterModel);
        return eaterModel;
    }
}
