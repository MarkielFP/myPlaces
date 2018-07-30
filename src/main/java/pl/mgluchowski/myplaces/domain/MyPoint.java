package pl.mgluchowski.myplaces.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MyPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Point name
    private String name;

    // creation date
    private Date date;

    // Point Latitude ("+" = N; "-" = S)
    private double latitude;

    // Point Longitude ("+" = E; "-" = W)
    private double longitude;


    // required by Hibernate
    private MyPoint() {
        this.date = new Date();
    }

    public MyPoint(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}