package runners;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/login",
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)

public class RunCucumberTests{

}