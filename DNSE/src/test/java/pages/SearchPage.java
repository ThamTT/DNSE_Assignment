package pages;

import elements.ElementSearchPage;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.Assert;
import static net.serenitybdd.screenplay.actors.OnStage.*;
public class SearchPage extends ElementSearchPage {

    public void openWeb(String actor){
        theActorCalled(actor).attemptsTo(
                Open.url("https://www.dnse.com.vn")
        );
    }

    public void goToPage(){
        theActorInTheSpotlight().attemptsTo(MoveMouse.to(menuTo("Thị trường")));
        clickElement(elementDynamicText("Senses"));
    }

    public void inputValueToSearch(String text){
        inputValueIntoField(elementDynamicAtr("placeholder", "Tìm hiểu mã chứng khoán..."), text);
    }
    public void clickElement(String text){
        clickElement(elementDynamicText(text));
    }

    public void getAndPrintText(){
        clickElement(elementDynamicText("Chia sẻ"));
        String link = getTexto(textLinkShare());
        System.out.println("Link Share: " + link);
        sendReport("Link share", link);
    }

    public void backPage(){
        theActorInTheSpotlight().attemptsTo(
                Open.relativeUrl("https://www.dnse.com.vn/senses")
        );
    }

    public void chooseStock(String number){
        clickElement(childElement(number));
    }

    public void printIdStock(){
        String idStock = Text.of(idStock()).answeredBy(theActorInTheSpotlight()).toString();
        System.out.println("Id Stock: " + idStock);
        sendReport("Id Stock", idStock);
    }
}
