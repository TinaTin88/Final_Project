package StepObject;
import PageObject.Basket_Page;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
public class Basket_Steps extends Basket_Page {
    @Step ("კალათის გვერდზე გადასვლა და შემოწმება")
    public Basket_Steps GoToBasket (){
        BasketBtn.click();
        return this;
    }
    @Step ("საძიებო ველში გადასვლა და პროდუქტის მოძებნა")
    public Basket_Steps GoToSearchField (String text){
        SearchInput.setValue(text).pressEnter();
        return this;
    }
    @Step ("პროდუქტის არჩევა")
    public Basket_Steps ChooseProduct (){
        FirstProduct.click();
        return this;
    }
    @Step ("კალათაში დამატება")
    public Basket_Steps AddToCart (){
        AddToBasket.click();
        return this;
    }
    @Step ("კალათის საბოლოო შემოწმება")
    public Basket_Steps FinCheckTheBasket (){
        CheckTheBasket.click();
        return this;
    }

    @Step ("საძიებო ველში გადასვლა")
    public Basket_Steps GoToSearchField2 (String SearchText){
        SearchInput.setValue(SearchText).pressEnter();
        return this;
    }
     @Step ("მარაგის შემოწმება და მონიშვნა")
    public Basket_Steps CheckingStock (){
        CheckStockBtn.click();
        InStockInput.shouldBe(Condition.visible);
        return this;
    }
  @Step ("მოვნიშნოთ მარაგშია")
    public Basket_Steps ClickStockBtn (){
        InStockInput.click();
        return this;
    }
    @Step ("მეორე პროდუქტის არჩევა")
    public Basket_Steps ChooseProduct2 (){
        SecondProduct.click();
        return this;
    }
    @Step ("პროდუქტის დაზუმება")
    public Basket_Steps ProductPreview () {
        HoverInput.shouldBe(Condition.visible);
        return this;
    }
    @Step ("პროდუქტის რაოდენობის გაზრდა")
    public Basket_Steps IncreaseQuantity () {
        PlusInput.click();
        return this;
    }
    @Step ("კალათაში დამატება")
    public Basket_Steps AddToCart2 () {
        AddToBasket.click();
        return this;
    }
    @Step ("კალათაში გადასვლა")
    public Basket_Steps FinCheckTheBasket2 () {
        CHeckFilledBasket.click();
        return this;
    }
    @Step ("კალათის შემოწმება")
    public Basket_Steps BasketView () {
        CheckTheBasket.click();
        return this;
    }
}
