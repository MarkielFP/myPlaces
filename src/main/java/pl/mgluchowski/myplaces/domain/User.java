package pl.mgluchowski.myplaces.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4, max = 32, message = "username must be between 4 and 32 characters")
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min = 4, max = 32, message = "password must be between 4 and 32 characters")
    private String password;

    // creation date
    private LocalDateTime date;

    private boolean enabled;

    private String passwordConfirm;

    @OneToMany(mappedBy = "ownerUser")
    private Set<MyPlace> myPlaces;

    public User() {
        this.date = LocalDateTime.now();
        this.enabled = true;
    }

    public User(@NotNull String username,
                @NotNull String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
        this.date = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = "{noop}" + password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
