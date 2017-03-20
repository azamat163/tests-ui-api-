package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by azamat on 20.03.17.
 */

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        tags = "@test")
public class AllTests {

}
