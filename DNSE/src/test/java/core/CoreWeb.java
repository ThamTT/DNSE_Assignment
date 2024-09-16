package core;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CoreWeb extends PageObject {
  public WebElementFacade findElement(String locator) {
    return $(By.xpath(locator));
  }

  public void clickToElement(WebElementFacade element) {
    element.waitUntilVisible().waitUntilClickable().click();
  }

  public String getValueElement(WebElementFacade el){
    return el.getText();
  }

  public static void sendReport(String key, String value) {
    Serenity.recordReportData().withTitle(key).andContents(value);
  }

  public static void waitVisible(Target targetLocators) {
    theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(targetLocators, WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds());
  }

  public  static void clickElement(Target targetLocators) {
    theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(targetLocators, WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds(),
            Click.on(targetLocators));
  }

  public static void inputValueIntoField(Target targetLocators, String value) {
    waitVisible(targetLocators);
    theActorInTheSpotlight().attemptsTo(
            Enter.theValue(value).into(targetLocators));
  }

  public  String getTexto(Target elemento) {
    return Text.of(elemento).answeredBy(theActorInTheSpotlight()).toString();
  }
}
