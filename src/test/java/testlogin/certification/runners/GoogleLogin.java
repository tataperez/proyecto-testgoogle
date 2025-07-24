package testlogin.certification.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/google/login.feature",
        glue = "testlogin.certification.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class GoogleLogin {
}
