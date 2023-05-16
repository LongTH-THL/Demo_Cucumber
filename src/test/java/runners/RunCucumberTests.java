package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/feature/",
        glue = "steps/login",
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)

public class RunCucumberTests  extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}