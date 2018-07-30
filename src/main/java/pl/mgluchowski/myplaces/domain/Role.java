package pl.mgluchowski.myplaces.domain;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String role;

    private Role(){
    }

    public Role(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public Role(String username) {
        this.username = username;
        this.role = "USER";
    }
}