package testlogin.certification.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After; // Keep @After if you need to clean up test data, otherwise can be removed.
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open; // This is crucial for opening URLs
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static testlogin.certification.utils.constants.ConstantManage.ACTOR;
import static testlogin.certification.utils.constants.ConstantManage.URL;


public class TestLoginStepDefinition {

    // REMOVE this variable declaration. Serenity manages the WebDriver internally.
    // WebDriver driver;

    @Before
    public void setUp() {
        // This is correct. It sets up the Screenplay stage for your actors.
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        theActorCalled(ACTOR);
        // This is the key change:
        // - You no longer manually get the driver from MyChromeDriver.
        // - You no longer explicitly "can" BrowseTheWeb with a manually obtained driver.
        // - Instead, you tell the actor to perform the "Open" action, which uses
        //   the WebDriver instance managed by Serenity (based on your serenity.conf).
        theActorInTheSpotlight().attemptsTo(
                Open.url(URL) // Use Serenity Screenplay's Open action to navigate.
        );
    }

    @When("I type the user and password")
    public void iTypeTheUserAndPassword() {
        // Your actions for typing username and password will go here.
        // Example: theActorInTheSpotlight().attemptsTo(
        //     Enter.theValue("your_username").into(LoginPage.USERNAME_FIELD),
        //     Enter.theValue("your_password").into(LoginPage.PASSWORD_FIELD)
        // );
    }

    @Then("I can see the init page")
    public void iCanSeeTheInitPage() {
        // Your assertions for verifying the login will go here.
        // Example: theActorInTheSpotlight().should(
        //     seeThat(DashboardPage.WELCOME_MESSAGE, containsText("Welcome"))
        // );
    }

    @After
    public void tearDown() {
        // REMOVE this block. Serenity BDD automatically quits the WebDriver
        // at the end of each scenario/test run.
        // Keep @After only if you need to perform other types of cleanup (e.g., database, test data).
        // if (driver != null) {
        //     driver.quit();
        // }
    }
}