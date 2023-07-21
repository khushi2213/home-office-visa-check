package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WorkTypePage extends Utility {

    @CacheLookup
    @FindBy(xpath ="//div[@class='govuk-radios']//div//label")
    List<WebElement> workType;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    public void selectJobTypeList(String jobType) {

        for (WebElement job : workType) {
            if (job.getText().contains(jobType))
                clickOnElement(job);
            break;
        }
    }

    public void clickContinueButton() {

        clickOnElement(continueButton);

    }

}
