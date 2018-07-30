package pl.mgluchowski.myplaces.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mgluchowski.myplaces.domain.MyPlace;
import pl.mgluchowski.myplaces.domain.MyPoint;
import pl.mgluchowski.myplaces.domain.User;
import pl.mgluchowski.myplaces.services.MyPlaceService;
import pl.mgluchowski.myplaces.services.MyPointService;
import pl.mgluchowski.myplaces.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestData {

    @Autowired
    UserService userService;

    @Autowired
    MyPlaceService placeService;

    @Autowired
    MyPointService pointService;

    public void createTestData() {
        List<User> testUsers = createTestUsers();

        List<MyPlace> testPlaces = createTestPlaces(testUsers);

        createTestPoints(testPlaces);
    }

    private List<User> createTestUsers() {
        List<User> userList = new ArrayList<>();

        User admin = new User("admin", "{noop}adminpass");
        userService.createUser(admin, "ADMIN");
        userList.add(admin);

        User user1 = new User("user1", "{noop}user1");
        userService.createUser(user1);
        userList.add(user1);

        return userList;
    }

    private  List<MyPlace> createTestPlaces(List<User> userList) {
        List<MyPlace> myPlaces = new ArrayList<>();

        MyPlace adminPlace1 = new MyPlace("forest", userList.get(0));
        myPlaces.add(adminPlace1);
        MyPlace adminPlace2 = new MyPlace("city", userList.get(0));
        myPlaces.add(adminPlace2);

        MyPlace user1Place1 = new MyPlace("hills", userList.get(1));
        myPlaces.add(user1Place1);
        MyPlace user1Place2 = new MyPlace("city", userList.get(1));
        myPlaces.add(user1Place2);
        MyPlace user1Place3 = new MyPlace("mountain", userList.get(1));
        myPlaces.add(user1Place3);
        MyPlace user1Place4 = new MyPlace("hills", userList.get(1));
        myPlaces.add(user1Place4);

        myPlaces.forEach(myPlace -> placeService.createPlace(myPlace));
        return myPlaces;
    }

    private void createTestPoints(List<MyPlace> myPlaces) {
        List<String> pointNames = new ArrayList<>();
        pointNames.add("myhill");
        pointNames.add("myforest");
        pointNames.add("mymountain");
        pointNames.add("mycity");

        List<MyPoint> myPoints = new ArrayList<>();

        for (int i = 0; i < myPlaces.size(); i++) {
            for (int j = 0; j < randomInteger(6); j++) {
                myPoints.add(
                        new MyPoint(
                                pointNames.get(randomInteger(3)),
                                randomDouble(90),
                                randomDouble(180),
                                myPlaces.get(i)
                        ));
            }
        }
        myPoints.forEach(myPoint -> pointService.createPoint(myPoint));
    }

    private int randomInteger(int i) {
        return (int) (Math.random() * i);
    }

    private double randomDouble(int i) {
        return (double) ((Math.random() * 2 * i) - i);
    }
}
