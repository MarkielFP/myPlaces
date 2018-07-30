package pl.mgluchowski.myplaces.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class MyPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Point name
    @NotNull
    private String nameplace;

    // creation date
    private LocalDateTime date;

    // Owner name
    @ManyToOne
    @NotNull
    private User ownerUser;

    @OneToMany(mappedBy = "ownerPlace")
    private Set<MyPoint> myPoints;

    // required by Hibernate
    private MyPlace() {
        this.date = LocalDateTime.now();
    }

    public MyPlace(@NotNull String name,
                   @NotNull User ownerUser) {
        this.nameplace = name;
        this.ownerUser = ownerUser;
        this.date = LocalDateTime.now();
    }
}