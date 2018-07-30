package pl.mgluchowski.myplaces.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mgluchowski.myplaces.domain.MyPlace;
import pl.mgluchowski.myplaces.domain.repository.MyPlaceRepository;

@Component
public class MyPlaceService {

    @Autowired
    MyPlaceRepository myPlaceRepository;

    public void createPlace(MyPlace myPlace) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        myPlaceRepository.createPlace(myPlace);
    }

}
