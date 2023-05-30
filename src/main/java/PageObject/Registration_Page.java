package PageObject;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class Registration_Page {
    public SelenideElement
    profileBtn = $(byClassName("cm-tooltip"), 1),
    regBtn =  $(byClassName("ty-btn__primary"), 1),
    firstNameInput = $(byName("user_data[firstname]")),
    lastNameInput = $(byName("user_data[lastname]")),
    phoneNumInput = $(byName("user_data[phone]")),
    altPhoneNumInput = $(byName("user_data[fields][40]")),
    emailInput = $(byName("user_data[email]")),
    passwordInput = $(byId("password1")),
    confirmPasswordInput = $(byId("password2")),
    ErrorPhoneMessage = $("#elm_9_error_message"),
    ErrorPassMessage = $("#password1_error_message"),
    ErrorEMailMessage = $("#email_error_message"),
    finRegistrationBtn = $(byName("dispatch[profiles.update]"));
}
