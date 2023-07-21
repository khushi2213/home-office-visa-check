package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {
    StartPage startPage;
    WorkTypePage workTypePage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    DurationOfStayPage durationOfStayPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        durationOfStayPage = new DurationOfStayPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void anAustralianComingToUKForTourism() throws InterruptedException {
        startPage.clickStartNow();
        selectNationalityPage.selectCountry("Australia");
        Thread.sleep(2000);
        selectNationalityPage.clickContinueButton();
        reasonForTravelPage.selectReasonForVisit("Tourism");
        reasonForTravelPage.clickContinueButton();
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");

    }

    @Test(groups = {"smoke", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() throws InterruptedException {
        startPage.clickStartNow();
        selectNationalityPage.selectCountry("Chile");
        selectNationalityPage.clickContinueButton();
        Thread.sleep(2000);
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        reasonForTravelPage.clickContinueButton();
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobTypeList("Health and care professional");
        workTypePage.clickContinueButton();
        Thread.sleep(2000);
        resultPage.confirmResultMessage("You need a visa to work in health and care");
        Thread.sleep(2000);
    }

    @Test(groups = "regression")
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() throws  InterruptedException {
        startPage.clickStartNow();
        selectNationalityPage.selectCountry("Colombia");
        Thread.sleep(2000);
        selectNationalityPage.clickContinueButton();
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        reasonForTravelPage.clickContinueButton();
        resultPage.confirmResultMessage("You may need a visa");
        Thread.sleep(2000);
    }

}
