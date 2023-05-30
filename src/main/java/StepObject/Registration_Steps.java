package StepObject;
import PageObject.Registration_Page;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
public class Registration_Steps extends Registration_Page {
    @Step("პროფილის გვერდზე გადასვლა")
    public Registration_Steps GoToProfile() {
        profileBtn.click();
        return this;
    }
    @Step("რეგისტრაციის ღილაკით რეგისტრაციის გვერდის გახსნა")
    public Registration_Steps GoToRegistration() {
        regBtn.click();
        return this;
    }
    @Step("სახელის ველის შევსება მონაცემებით: {firstName}")
    public Registration_Steps FirstName(String firstName) {
        firstNameInput.setValue(firstName);
        firstNameInput.shouldBe(visible);
        return this;
    }
    @Step("გვარის ველის შევსება მონაცემით: {lastName}")
    public Registration_Steps LastName(String lastName) {
        lastNameInput.setValue(lastName);
        lastNameInput.shouldBe(visible);
        return this;
    }
    @Step("ტელეფონის ველის შევსება")
    public Registration_Steps PhoneNumber(String number) {
        phoneNumInput.setValue(number);
        lastNameInput.shouldBe(visible);
        return this;
    }
    @Step("ალტერნატიული ტელეფონის ველის შევსება")
    public Registration_Steps AlterPhoneNumber(String number) {
        altPhoneNumInput.setValue(number);
        altPhoneNumInput.shouldBe(visible);
        return this;
    }
    @Step("ელ.ფოსტის ველის შევსება")
    public Registration_Steps Email(String email) {
        emailInput.setValue(email);
        emailInput.shouldBe(visible);
        return this;
    }
    @Step("პაროლის ველის შევსება")
    public Registration_Steps Password(String pass) {
        passwordInput.setValue(pass);
        passwordInput.shouldBe(visible);
        return this;
    }
    @Step("პაროლის დამოწმების ველის შევსება")
    public Registration_Steps ConfirmPassword(String pass) {
        confirmPasswordInput.setValue(pass);
        confirmPasswordInput.shouldBe(visible);
        return this;
    }
    @Step("რეგისტრაციის ღილაკზე დაკლიკება")
    public Registration_Steps RegistrationClick() {
        finRegistrationBtn.click();
        return this;
    }
    @Step("ტელეფონის ველის შევსება არასწორი მონაცემით")
    public Registration_Steps wrongPhoneNumber(String wrongNumber) {
        phoneNumInput.setValue(wrongNumber);
        phoneNumInput.shouldBe(visible);
        return this;
    }
    @Step("ალტერნატიული ტელეფონის ველის შევსება არასწორი მონაცემით")
    public Registration_Steps wrongAltPhoneNumber(String wrongNumber) {
        altPhoneNumInput.setValue(wrongNumber);
        altPhoneNumInput.shouldBe(visible);
        return this;
    }
    @Step("ელ.ფოსტის ველის შევსება არასწორი მონაცემით")
    public Registration_Steps wrongEmail(String wrongEmail) {
        emailInput.setValue(wrongEmail);
        return this;
    }
    @Step("პაროლის ველის შევსება")
    public Registration_Steps wrongPassword(String wrongPass) {
        passwordInput.setValue(wrongPass);
        passwordInput.shouldBe(visible);
        return this;
    }
    @Step("პაროლის დამოწმება არასწორი მონაცემით")
    public Registration_Steps wrongConfirmPassword(String wrongPass) {
        confirmPasswordInput.setValue(wrongPass);
        confirmPasswordInput.shouldBe(visible);
        return this;
    }
    @Step("რეგისტრაციაზე დაკლიკება")
    public Registration_Steps ClickRegBTN() {
        finRegistrationBtn.click();
        ErrorPhoneMessage.shouldBe(visible);
        ErrorEMailMessage.shouldBe(visible);
        ErrorPassMessage.shouldBe(visible);
        return this;
    }
}