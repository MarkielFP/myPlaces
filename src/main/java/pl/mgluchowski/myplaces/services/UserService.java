package pl.mgluchowski.myplaces.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.mgluchowski.myplaces.domain.Role;
import pl.mgluchowski.myplaces.domain.User;
import pl.mgluchowski.myplaces.domain.repository.RoleRepository;
import pl.mgluchowski.myplaces.domain.repository.UserRepository;

@Component
public class UserService {

    @Autowired
    UserRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void createUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.createUser(user);
        Role userRole = new Role(user.getUsername());
        roleRepository.addRole(userRole);
    }

    public void createUser(User user, String role) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.createUser(user);
        Role userRole1 = new Role(user.getUsername());
        roleRepository.addRole(userRole1);
        Role userRole2 = new Role(user.getUsername(), role);
        roleRepository.addRole(userRole2);
    }


}
