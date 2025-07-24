package testlogin.certification.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import testlogin.certification.utils.drivers.MyChromeDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static testlogin.certification.utils.constants.ConstantManage.ACTOR;
import static testlogin.certification.utils.constants.ConstantManage.URL;


public class TestLoginStepDefinition {

    WebDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        theActorCalled(ACTOR);
        driver = MyChromeDriver.chromeHisBrowserWeb(URL);
        theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }

    @When("I type the user and password")
    public void iTypeTheUserAndPassword() {
        // Aquí iría la acción para digitar usuario y contraseña
    }

    @Then("I can see the init page")
    public void iCanSeeTheInitPage() {
        // Aquí iría la validación del inicio de sesión
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
