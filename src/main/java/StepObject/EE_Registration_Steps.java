package StepObject;
import PageObject.EE_Registration_Page;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
public class EE_Registration_Steps extends EE_Registration_Page {

    @Step ("რეგისტრაციის გვერდზე გადასვლა")
    public EE_Registration_Steps GoToRegistration() {
        RegBTN.click();
        return this;
    }
    @Step("სახელის ველის შევსება მონაცემით: {name}")
    public EE_Registration_Steps FirstNameField (String name) {
        firstNameInput.setValue(name);
        return this;
    }
    @Step ("გვარის ველის შევსება მონაცემით: {lastName}")
    public EE_Registration_Steps LastNameField (String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step ("ელ.ფოსტის ველის შევსება და შემოწმება მონაცემით: {email}")
    public EE_Registration_Steps EmailField (String email) {
        emailInput.setValue(email);
        emailInput.shouldNotBe(Condition.empty);
        return this;
    }
    @Step ("პაროლის ველის შევსება და შემოწმება")
    public EE_Registration_Steps PassWordField (String password) {
        passwordInput.setValue(password);
        passwordInput.shouldNotBe(Condition.empty);
        return this;
    }
    @Step ("პაროლის დამოწმების ველის შევსება და შემოწმება")
    public EE_Registration_Steps ConfirmPassWordField (String confirmPass) {
        confirmPassInput.setValue(confirmPass);
        confirmPassInput.shouldNotBe(Condition.empty);
        return this;
    }
    @Step ("რეგისტრაციის გადამოწმება")
    public EE_Registration_Steps  ConfirmRegistration () {
        signUpBTN.shouldBe(Condition.enabled);
        return this;
    }
}
