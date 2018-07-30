package pl.mgluchowski.myplaces.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mgluchowski.myplaces.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createUser(User user) {
        em.persist(user);
    }


}
