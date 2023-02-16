package steps;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Driver;

public class RandomSteps {

    @Test
    public void getRandomData() {

        Faker faker = new Faker();

        Driver.getDriver().get("https://www.google.com/");
        Driver.getDriver().findElement(By.name("q")).sendKeys(faker.chuckNorris().fact());
        for (int i = 0; i < 20; i++) {
            System.out.println(faker.chuckNorris().fact());

        }

    }
}
