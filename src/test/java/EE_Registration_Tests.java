import StepObject.EE_Registration_Steps;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static DataObject.EE_Registration_Data.*;
import static com.codeborne.selenide.Selenide.open;

public class EE_Registration_Tests  {
    EE_Registration_Steps eeRegistrationSteps = new EE_Registration_Steps();
    @Test
    @Description ("ee.ge რეგისტრაციის გვერდის შემოწმება დადებითი მნიშვნელობებით")
    @Severity(SeverityLevel.BLOCKER)
    public void RegistrationCheck_Case1 () {
        SoftAssert softAssert = new SoftAssert();
        open ("https://ee.ge/");
        eeRegistrationSteps.GoToRegistration()
                .FirstNameField(firstName)
                .LastNameField(lastName)
                .EmailField(email);
        softAssert.assertTrue(eeRegistrationSteps.emailInput.isDisplayed());
                eeRegistrationSteps.PassWordField(password);
        softAssert.assertTrue(eeRegistrationSteps.passwordInput.isDisplayed());
                eeRegistrationSteps.ConfirmPassWordField(confirmPass);
        softAssert.assertTrue(eeRegistrationSteps.confirmPassInput.isDisplayed());
        softAssert.assertTrue(eeRegistrationSteps.signUpBTN.isEnabled());
        softAssert.assertAll();
    }
}
