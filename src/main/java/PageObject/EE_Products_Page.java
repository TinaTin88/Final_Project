package PageObject;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
public class EE_Products_Page {
    public SelenideElement
       searchInput = $ (byId("search_list")),
       filter = $(byId("sort")),
       ProductPrice = $(".price-section",0).$(byTagName("span"));

    public ElementsCollection
       ProductBoxes = $$(byClassName("product-list"));














}
