package elements;

import core.CoreWeb;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ElementSearchPage extends CoreWeb {
    public WebElementFacade elementTextDynamic(String title) {
        String txtFlag = String.format("//*[normalize-space(text()) = '%s']", title);
        return $(By.xpath(txtFlag));
    }

    public String menuTo(String title) {
        return String.format("//*[normalize-space(text()) = '%s']", title);
    }
    public Target elementDynamicText(String title) {
        String element =  String.format("//*[normalize-space(text()) = '%s']", title);
        return Target.the("child menu")
                .locatedBy(element);
    }

    public static Target elementDynamicAtr(String att, String text) {
        return Target.the("dynamic element with attribute")
                .locatedBy("//*[normalize-space(@"+ att +") = '" + text + "']");
    }

    public Target textLinkShare() {
        return  Target.the("link share")
                .locatedBy("//button[text()]/../p[1]");
    }

//    public WebElementFacade textLinkShare() {
//        String link = String.format("\"//button[text()]/../p[1]");
//        return $(By.xpath(link));
//    }

    public static Target childElement(String number){
        return Target.the("Child Element").locatedBy("//ul[@role = \"listbox\"]/child::li["+number+"]");
    }

    public Target idStock(){
        Target el = Target.the("Child Element").locatedBy("//nav[@aria-label]/ol/child::li[3]/span");
        return el;
    }
}
