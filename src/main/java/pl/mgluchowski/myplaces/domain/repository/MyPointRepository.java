package pl.mgluchowski.myplaces.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mgluchowski.myplaces.domain.MyPoint;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MyPointRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPoint(MyPoint myPoint) {
        em.persist(myPoint);
    }
}
