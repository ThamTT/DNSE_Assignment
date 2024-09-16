package stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import pages.SearchPage;

public class StepSearch {
    @Steps
    SearchPage searchPage = new SearchPage();
    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("{string} Open the DNSE website")
    public void openTheDNSEWebsite(String name) {
        searchPage.openWeb(name);
    }

    @When("Go to the Senses page")
    public void goToTheSensesPage() {
        searchPage.goToPage();
    }

    @And("Search with text {string}")
    public void searchWithText(String text) {
        searchPage.inputValueToSearch(text);
        searchPage.clickElement("DSE");
    }

    @Then("Get link Share")
    public void getLinkShare() {
        searchPage.getAndPrintText();
    }

    @When("Back to the Senses page")
    public void backToTheSensesPage() {
        searchPage.backPage();
    }

    @And("Chose stock index {string}")
    public void choseStockIndex(String number) {
        searchPage.inputValueToSearch("DS");
        searchPage.chooseStock(number);
    }

    @Then("Print stock")
    public void printStock() {
        searchPage.printIdStock();
    }
}
