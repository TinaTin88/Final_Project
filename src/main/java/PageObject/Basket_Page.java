package PageObject;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class Basket_Page {
    public SelenideElement
            BasketBtn = $(".ty-minicart-count"),
            CheckBasketIsEmpty = $(byText("თქვენი კალათა ცარიელია"),0),
            InStockInput = $(byText("მარაგშია"),0),
            SearchInput = $("#search_input"),
            FirstProduct = $("#det_img_88379"),
            AddToBasket = $(byClassName("m-icon__add-to-cart"), 0),
            CheckTheBasket = $(byText("კალათის ნახვა")),
            PlaceOrderInput = $(byText("შეკვეთის განთავსება"),0),
            CheckStockBtn =  $(byText("მარაგი")),
            SecondProduct = $(".abt-single-image",0),
            HoverInput = $(".cm-image-previewer",0),
            PlusInput =  $(byAttribute("precision","1")),
            CHeckFilledBasket = $("#sw_dropdown_265");

}

