package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(features="D:\\new eclipse space\\SmallWorldTestProject\\src\\test\\resources\\FeatureFile\\Login.feature",
	glue= {"AppHooks","StepDefinition"},
	monochrome = true,
	plugin = {"pretty",  "json:target/cucumber/report.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	tags = "@LoginTest"
)

	public class TestRunner  extends AbstractTestNGCucumberTests{

	

}
