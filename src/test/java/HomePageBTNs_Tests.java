import StepObject.GorgiaHomepageBTNs_Steps;
import static DataObject.HomepageBTNs_Data.*;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class HomePageBTNs_Tests extends ChromeRunner {
    GorgiaHomepageBTNs_Steps homepageBTNs_steps = new GorgiaHomepageBTNs_Steps();

    @Test
    @Description ("ავტორიზაციის უარყოფითი მნიშვნელობით შემოწმება")
    @Severity(SeverityLevel.CRITICAL)
    public void HomePage_Case1 () {
        homepageBTNs_steps.GoToProfile()
                .GoToAutorization()
                .EmailField(email)
                .PasswordField(pass)
                .FinAuthorization()
                .ResetPassword();


























    }


}
