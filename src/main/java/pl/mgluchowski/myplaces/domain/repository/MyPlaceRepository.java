package pl.mgluchowski.myplaces.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mgluchowski.myplaces.domain.MyPlace;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MyPlaceRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPlace(MyPlace myPlace) {
        em.persist(myPlace);
    }
}
