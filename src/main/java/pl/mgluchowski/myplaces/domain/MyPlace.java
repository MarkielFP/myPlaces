package pl.mgluchowski.myplaces.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class MyPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Point name
    @NotNull
    private String name;

    // creation date
    private Date date;

    // Owner name
//    @ManyToOne()
    private String username;


    // required by Hibernate
    private MyPlace() {
        this.date = new Date();
    }




}