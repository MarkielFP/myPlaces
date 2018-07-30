package pl.mgluchowski.myplaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mgluchowski.myplaces.domain.Role;
import pl.mgluchowski.myplaces.domain.User;
import pl.mgluchowski.myplaces.domain.repository.RoleRepository;
import pl.mgluchowski.myplaces.domain.repository.UserRepository;


@Component
public class Starter implements CommandLineRunner {

    @Autowired
    UserRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
//        createTestUsers();
//        createTestPlaces()
//        createTestPoints();
    }

    private void createTestUsers() {
        User admin = new User("admin", "{noop}adminpass");
        usersRepository.createUser(admin);
        Role adminRoleAdmin = new Role("admin", "ADMIN");
        Role adminRoleUser = new Role("admin", "USER");
        roleRepository.addRole(adminRoleAdmin);
        roleRepository.addRole(adminRoleUser);

        User user1 = new User("user1", "{noop}user1");
        usersRepository.createUser(user1);
        Role user1RoleUser = new Role("user1", "USER");
        roleRepository.addRole(user1RoleUser);
    }

    private void createTestPlaces() {

//        User admin = new User("admin","{noop}adminpass");
//        usersRepository.createUser(admin);
//        Role adminRoleAdmin = new Role("admin","ADMIN");
//        Role adminRoleUser = new Role("admin","USER");
//        roleRepository.addRole(adminRoleAdmin);
//        roleRepository.addRole(adminRoleUser);
//
//        User user1 = new User("user1","{noop}user1");
//        usersRepository.createUser(user1);
//        Role user1RoleUser = new Role("user1","USER");
//        roleRepository.addRole(user1RoleUser);
    }

    private void createTestPoints() {
//        User admin = new User("admin","{noop}adminpass");
//        usersRepository.createUser(admin);
//        Role adminRoleAdmin = new Role("admin","ADMIN");
//        Role adminRoleUser = new Role("admin","USER");
//        roleRepository.addRole(adminRoleAdmin);
//        roleRepository.addRole(adminRoleUser);
//
//        User user1 = new User("user1","{noop}user1");
//        usersRepository.createUser(user1);
//        Role user1RoleUser = new Role("user1","USER");
//        roleRepository.addRole(user1RoleUser);
    }


}
