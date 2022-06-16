package UnityRealTimeOnline.runners;


import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        //plugin = "message:target/cucumber-report.ndjson",
        plugin = {"html:target/cucumber/cucumber.html"},
        glue = {"UnityRealTimeOnline"},
        features= "src/test/resources/UnityRealTimeOnline"
)
public class TestNGRunnertTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object [][] scenarios() {
        return super.scenarios();
    }

}
