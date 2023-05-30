package PageObject;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class HomepageBTNs_Page {
    public SelenideElement
     profileBTN =  $(byClassName("cm-tooltip"), 1),
     authorizBTN = $(byText("ავტორიზაცია"),0),
     emailInput =  $(byName("user_login")),
     passInput = $(byName("password")),
     regBTN= $(byName("dispatch[auth.login]")),
     forgotPass = $(".ty-password-forgot__a"),
     errorMessage =  $(byId("login_popup600_error_message")),
     resetPasswordMessage = $(".ty-mainbox-title");
}
