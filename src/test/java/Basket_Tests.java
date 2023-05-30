import PageObject.Basket_Page;
import StepObject.Basket_Steps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DataObject.Basket_Data.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.getSelectedText;

public class Basket_Tests extends ChromeRunner {
    Basket_Steps basketSteps = new Basket_Steps();
    @Test
    @Description ("კალათაში პროდუქტის დამატება და შემდეგ გადამოწმება")
    @Severity(SeverityLevel.NORMAL)
    public void Basket_Case1 () {
        basketSteps.GoToBasket();
        Assert.assertTrue ($(byText("თქვენი კალათა ცარიელია"),0).isDisplayed());
        basketSteps.GoToSearchField(SearchText)
                .ChooseProduct();
        Assert.assertTrue($(byText("მარაგშია"),0).isDisplayed());
        basketSteps.AddToCart();
        sleep(5000);
        basketSteps.GoToBasket()
                .FinCheckTheBasket();
        Assert.assertTrue($(byText("შეკვეთის განთავსება"),0).isDisplayed());
    }

    @Test
    @Description ("კალათაში პროდუქტის დამატება, რაოდენობის გაზრდა და გადამოწმება")
    @Severity(SeverityLevel.NORMAL)
  public void Basket_Case2() {
        basketSteps.GoToSearchField2(SearchTextCase2)
                .CheckingStock();
      Assert.assertTrue( $(byText("მარაგშია"),0).is(Condition.visible));
       basketSteps.ClickStockBtn();
                sleep(5000);
       basketSteps.ChooseProduct2()
               .ProductPreview()
               .IncreaseQuantity()
               .AddToCart2();
       sleep(5000);
       basketSteps.FinCheckTheBasket2()
               .BasketView();
      Assert.assertTrue($(by("value","2")).isDisplayed());
  }
}
