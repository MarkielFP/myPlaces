package pl.mgluchowski.myplaces.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mgluchowski.myplaces.domain.MyPoint;
import pl.mgluchowski.myplaces.domain.repository.MyPointRepository;

@Component
public class MyPointService {

    @Autowired
    MyPointRepository myPointRepository;

    public void createPoint(MyPoint myPoint) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        myPointRepository.createPoint(myPoint);
    }
}