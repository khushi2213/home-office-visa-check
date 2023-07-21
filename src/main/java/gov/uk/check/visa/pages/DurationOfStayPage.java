package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DurationOfStayPage extends Utility {

    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> stay;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    public void selectLengthOfStay(String lengthOfStay){

        switch(lengthOfStay){
            case "6 months or less":
                stay.get(0).click();
                break;
            case "longer than 6 months":
                stay.get(1).click();
                break;
        }

    }
    public void clickNextStepButton(){

        clickOnElement(continueButton);
    }

}
