package PageObject;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class EE_Registration_Page {
    public SelenideElement
       RegBTN =$(byText("რეგისტრაცია")),
       firstNameInput = $("#firstName"),
       lastNameInput = $("#lastName"),
       emailInput = $("#email"),
       passwordInput = $("#password"),
       confirmPassInput = $("#confirmPassword"),
       signUpBTN = $("#singup");
}
