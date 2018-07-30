package pl.mgluchowski.myplaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mgluchowski.myplaces.utils.TestData;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    TestData testData;

    @Override
    public void run(String... args) throws Exception {

        testData.createTestData();

    }



}