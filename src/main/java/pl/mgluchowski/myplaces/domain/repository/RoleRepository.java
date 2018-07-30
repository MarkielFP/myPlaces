package pl.mgluchowski.myplaces.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mgluchowski.myplaces.domain.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addRole(Role role) {
        em.persist(role);
    }

    public List<Role> getAll() {
        return em.createQuery("from Role", Role.class).getResultList();
    }
}