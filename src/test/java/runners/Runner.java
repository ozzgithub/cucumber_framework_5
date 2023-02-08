package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features" ,
        glue = "steps",
        tags = "",
        dryRun = false, //
        monochrome = false // with false , reporting much more clean

)

public class Runner {


}
