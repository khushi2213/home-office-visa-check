package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ResultPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement resultText;

    public String getResultMessage() {
        return getTextFromElement(resultText);
    }

    public void confirmResultMessage(String expectedMessage) {

        Assert.assertTrue(getResultMessage().equalsIgnoreCase(expectedMessage));

    }
}
