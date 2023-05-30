import StepObject.EE_Products_Steps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static DataObject.EE_Products_Data.*;
import static com.codeborne.selenide.Selenide.open;

public class EE_Products_Tests {
    EE_Products_Steps eeProductsSteps = new EE_Products_Steps();
    @Test
    @Description ("ფასის ფილტრის შემოწმების ტესტი ee.ge-თვის")
    @Severity(SeverityLevel.NORMAL)
    public void PriceFilterCheck () {
        open("https://ee.ge/");
        eeProductsSteps.GoToSearchField(SearchText)
                .SetFilter()
                .PriceFilterCheck();
    }
}
