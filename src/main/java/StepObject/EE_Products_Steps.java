package StepObject;
import PageObject.EE_Products_Page;
import io.qameta.allure.Step;
import org.testng.Assert;
import static DataObject.EE_Products_Data.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
public class EE_Products_Steps extends EE_Products_Page {
    @Step ("საძიებო ველში პროდუქტის მოძებნა")
    public EE_Products_Steps GoToSearchField(String Searchtext) {
        searchInput.setValue(Searchtext).pressEnter();
        sleep(5000);
        return this;
    }
    @Step ("ფილტრის სორტირება - ფასი კლებადობით")
    public EE_Products_Steps SetFilter () {
        filter.click();
        filter.selectOption(filterSet);
        sleep(5000);
        return this;
    }
    @Step ("ფილტრის შემოწმება ფასის მიხედვით ციკლში")
    public EE_Products_Steps PriceFilterCheck () {
        int count = ProductBoxes.size();
        String price = ProductPrice.getText();
        System.out.println(count);
        System.out.println(price);
        float firstPriceFloat = Float.parseFloat(price);
        for(int i = 1; i<count; i++) {
            String secondPrice = $(".price-section", i).$(byTagName("span")).getText();
            float secondPriceFLoat = Float.parseFloat(secondPrice);
            Assert.assertTrue(secondPriceFLoat <= firstPriceFloat);
            System.out.println(secondPriceFLoat);
            firstPriceFloat = secondPriceFLoat;
        }
        return this;
    }
}
