import StepObject.Registration_Steps;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static DataObject.Registration_Data.*;
public class Registration_Tests extends ChromeRunner {
    Registration_Steps registration_steps = new Registration_Steps();

    @Test
    @Description ("გორგიას რეგისტრაციის გვერდის დადებითი მნიშვნელობებით შემოწმება")
    @Severity(SeverityLevel.CRITICAL)
    public void RegistrationCheck_Case1(){
        SoftAssert softAssert = new SoftAssert();
                registration_steps.GoToProfile()
                .GoToRegistration()
                .FirstName(firstName);
                softAssert.assertEquals(registration_steps.firstNameInput.getValue(),firstName,"სახელის შემოწმება");
                registration_steps.LastName(lastName)
                .PhoneNumber(phoneNumber)
                .AlterPhoneNumber(alternativePhoneNumber)
                .Email(email);
                softAssert.assertEquals(registration_steps.emailInput.getValue(),email,"მეილის შემოწმება");
                registration_steps.Password(password)
                .ConfirmPassword(confirmPassword)
                .RegistrationClick();
                softAssert.assertAll();
    }
    @Test
    @Description ("გორგიას რეგისტრაციის გვერდის უარყოფითი მნიშვნელობებით შემოწმება")
    @Severity(SeverityLevel.CRITICAL)
    public void RegistrationCheck_Case2 () {
        SoftAssert softAssert = new SoftAssert();
        registration_steps.GoToProfile()
                .GoToRegistration()
                .FirstName(firstName)
                .LastName(lastName)
                .wrongPhoneNumber(wrongPhoneNumb);
        softAssert.assertNotEquals(registration_steps.phoneNumInput.getValue(),phoneNumber,"ტელეფონის ველის შემოწმება");
        registration_steps.AlterPhoneNumber(wrongAltPhoneNum);
        softAssert.assertNotEquals(registration_steps.altPhoneNumInput.getValue(),alternativePhoneNumber, "ტელეფონის ველის შემოწმება");
        registration_steps.wrongEmail(wrongEmail);
         softAssert.assertNotEquals(registration_steps.emailInput.getValue(),email, "მეილის ველის შემოწმება");
         registration_steps.wrongPassword(wrongPass)
                 .wrongConfirmPassword( wrongConfirmPass)
                 .RegistrationClick();
         softAssert.assertTrue(registration_steps.ErrorPhoneMessage.isDisplayed(),"ტელეფონის ნომერი არასწორია");
         softAssert.assertTrue(registration_steps.ErrorEMailMessage.isDisplayed(),"ელ-ფოსტა არასწორია");
         softAssert.assertTrue(registration_steps.ErrorPassMessage.isDisplayed(),"პაროლის დამოწმება არ ემთხვევა პაროლს");
         softAssert.assertAll();
    }
}
