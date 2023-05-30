package StepObject;
import PageObject.HomepageBTNs_Page;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
public class GorgiaHomepageBTNs_Steps extends HomepageBTNs_Page {

    @Step ("ჩემი პროფილის გახსნა")
    public GorgiaHomepageBTNs_Steps GoToProfile(){
        profileBTN.click();
        return this;
    }
    @Step ("ავტორიზაციაზე გადასვლა")
    public GorgiaHomepageBTNs_Steps GoToAutorization(){
        authorizBTN.click();
        return this;
    }
    @Step ("ელ.ფოსტის ველის შევსება მონაცემით: {email}")
    public GorgiaHomepageBTNs_Steps EmailField (String email){
        emailInput.setValue(email);
        return this;
    }
    @Step ("პაროლის ველის შევსება მონაცემით: {pass}")
    public GorgiaHomepageBTNs_Steps PasswordField (String pass){
        passInput.setValue(pass);
        return this;
    }
    @Step ("ავტორიზაციაზე დაკლიკება")
    public GorgiaHomepageBTNs_Steps FinAuthorization (){
        regBTN.click();
        errorMessage.shouldBe(Condition.visible);
        return this;
    }

    @Step ("პაროლის აღდგენაზე გადასვლა")
    public GorgiaHomepageBTNs_Steps ResetPassword (){
        forgotPass.click();
        resetPasswordMessage.shouldBe(Condition.visible);
        return this;
    }
}
