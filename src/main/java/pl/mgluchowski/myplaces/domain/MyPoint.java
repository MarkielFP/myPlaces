package pl.mgluchowski.myplaces.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class MyPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Point name
    @NotNull
    private String namePoint;

    // creation date
    private LocalDateTime date;

    // Point Latitude ("+" = N; "-" = S)
    @NotNull
    @Range(min = -90, max = 90)
    private double latitude;

    // Point Longitude ("+" = E; "-" = W)
    @NotNull
    @Range(min = -180, max = 180)
    private double longitude;

    // Owner name
    @NotNull
    @ManyToOne
    private MyPlace ownerPlace;

    // required by Hibernate
    private MyPoint() {
        this.date = LocalDateTime.now();
    }

    public MyPoint(@NotNull String name,
                   @NotNull double latitude,
                   @NotNull double longitude,
                   @NotNull MyPlace ownerPlace) {
        this.namePoint = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ownerPlace = ownerPlace;
        this.date = LocalDateTime.now();
    }
}