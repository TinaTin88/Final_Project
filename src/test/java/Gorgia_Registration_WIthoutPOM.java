import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Attribute;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Gorgia_Registration_WIthoutPOM {
    @Test
    public void Gorgia_registration_case1() {
        //case 1. positive tests
        SoftAssert softAssert = new SoftAssert();
        open("https://gorgia.ge/ka/"); //გაიხსნას გორგიას საიტი
        $(byClassName("ui-icon-closethick")).click(); // დაიხუროს სარეკლამო ბანერი
        $(".ui-icon-closethick");
        $(byClassName("cm-tooltip"), 1).click(); //დააკლიკოს პროფილის ბატონზე
        $(byClassName("ty-btn__primary"), 1).click(); // დაკლიკოს რეგისტრაციაზე-იხსნება ახალი მომხმარებლის რეგისტრაცია
        $(byName("user_data[firstname]")).setValue("თინათინ");
        softAssert.assertEquals($(byName("user_data[firstname]")).getValue(), "თინათინ", "სახელის ველის შემოწმება");
        $(byName("user_data[lastname]")).setValue("იობიშვილი");
        softAssert.assertEquals($(byName("user_data[lastname]")).getValue(), "იობიშვილი", "გვარის ველის შემოწმება");
        $(byName("user_data[phone]")).setValue("123456789");
        softAssert.assertEquals($(byName("user_data[phone]")).getValue(), "123456789", "ტელეფონის ველის შემოწმება");
        $(byName("user_data[fields][40]")).setValue("123456788");
        softAssert.assertEquals($(byName("user_data[fields][40]")).getValue(), "123456788", "ალტერნატიული ნომრის ველის შემოწმება");
        $(byName("user_data[email]")).setValue("tiko.iobishvili@gmail.com");
        softAssert.assertEquals($(byName("user_data[email]")).getValue(), "tiko.iobishvili@gmail.com", "მეილის ველის შემოწმება");
        $(byId("password1")).setValue("ttt888");
        softAssert.assertEquals($(byId("password1")).getValue(), "ttt888", "პაროლის ველის შემოწმება");
        $(byId("password2")).setValue("ttt888").pressTab();
        softAssert.assertEquals($(byId("password2")).getValue(), "ttt888", "პაროლის დამოწმება");
        sleep(5000); //რეგისტრაციის ღილაკს ვერ ვწვდები რადგან ხილულ ველში არ არის, ტესტიც აფეილებს
        $(byName("dispatch[profiles.update]")).click();
        softAssert.assertAll();
    }

    @Test
    public void Gorgia_registration_case2() {
        // case 2. negative tests
        SoftAssert softAssert = new SoftAssert();
        open("https://gorgia.ge/ka/"); //გაიხსნას გორგიას საიტი
        $(byClassName("ui-icon-closethick")).click(); // დაიხუროს სარეკლამო ბანერი
        $(byClassName("cm-tooltip"), 1).click(); //დააკლიკოს პროფილის ბატონზე
        $(byClassName("ty-btn__primary"), 1).click(); // დაკლიკოს რეგისტრაციაზე-იხსნება ახალი მომხმარებლის რეგისტრაცია
        $(byName("user_data[firstname]")).setValue("თინათინ");
        $(byName("user_data[lastname]")).setValue("იობიშვილი");
        softAssert.assertEquals($(byName("user_data[lastname]")).getValue(), "იობიშვილი", "გვარის შემოწმება");
        $(byName("user_data[phone]")).setValue("თიკოთიკო");
        softAssert.assertNotEquals($(byName("user_data[phone]")).getValue(), "123456789", "ტელეფონის ინფუთის შემოწმება");
        $(byName("user_data[fields][40]")).setValue("თინათინა");
        softAssert.assertNotEquals($(byName("user_data[fields][40]")).getValue(), "123456788", "ალტ.ტელეფონის ინფუთის შემოწმება");
        $(byName("user_data[email]")).setValue("123123");
        $(byId("password1")).setValue("123123");
        $(byId("password2")).setValue("12341234");
        sleep(5000);
        $(byName("dispatch[profiles.update]")).click();
        sleep(5000);
        softAssert.assertTrue($(byClassName("help-inline"), 0).isDisplayed(), "ტელეფონის ნომერი არასწორია");
        softAssert.assertTrue($(byClassName("help-inline"), 1).isDisplayed(), "ალტერნატიული ტელეფონის ნომერი არასწორია");
        softAssert.assertTrue($(byClassName("help-inline"), 2).isDisplayed(), "ელ-ფოსტა არასწორია");
        softAssert.assertTrue($(byClassName("help-inline"), 3).isDisplayed(), "პაროლის დამოწმება არ ემთხვევა პაროლს");
        softAssert.assertAll();
    }


   /* @Test
    public void Basket() {
        open("https://gorgia.ge/ka/"); //გაიხსნას გორგიას საიტი
        $(".ty-dropdown-box",1).click();
        Assert.assertTrue ($(byText("თქვენი კალათა ცარიელია")).isDisplayed());
        $("#search_input").setValue("კედლის კონდიციონერი").pressEnter();
        $("#det_img_88379").click();
        Assert.assertTrue($(byText("მარაგშია")).isDisplayed());
        $(byClassName("m-icon__add-to-cart"),0).click();
        Assert.assertTrue($(byText("პროდუქტი დაემატა თქვენს კალათას")).isDisplayed());
        $(".ty-minicart-count").click();
        $(byText("კალათის ნახვა")).click();
        Assert.assertTrue($(byText("შეკვეთის განთავსება"),0).isDisplayed());
    }*/

    @Test
    public void Basket_Case2() {
        open("https://gorgia.ge/ka/"); //გაიხსნას გორგიას საიტი
        $(byClassName("ui-icon-closethick")).click(); // დაიხუროს სარეკლამო ბანერი
        $("#search_input").setValue("კისრის ბალიში").pressEnter();
        $(byText("მარაგი")).click();
        Assert.assertTrue($(byText("მარაგშია"), 0).is(Condition.visible));
        $(byText("მარაგშია"), 0).click();
        sleep(5000);
        $(".abt-single-image", 0).click();
        $(".cm-image-previewer", 0).hover();
        $(byAttribute("precision", "1")).click();
        sleep(5000);
        $(byClassName("m-icon__add-to-cart"), 0).click();
        sleep(5000);
        $("#sw_dropdown_265").click();
        $(byText("კალათის ნახვა")).click();
        Assert.assertTrue($(by("value", "2")).isDisplayed());
    }

   /* @Test
    public void PriceFilter_Increase() {
        open("https://gorgia.ge/ka/"); //გაიხსნას გორგიას საიტი
        $(byClassName("ui-icon-closethick")).click(); // დაიხუროს სარეკლამო ბანერი
        $("#search_input").setValue("კედლის კონდიციონერი").pressEnter();
        sleep(5000);
        $("#sw_elm_sort_fields").click();
        $(byText("ფასით: დაბლიდან მაღლისკენ")).click();
        sleep(5000);
        int count = $$(".ypi-grid-list__item_body").size();
        //String price = $(".ty-price-num", 0).$(byTagName("span")).getText().replaceAll("[^\\d.]","");
        String price = $(".ty-price", 0).$(".ty-price-num",0).$(byTagName("span"),0).getText();
                //(byTagName("span"),0).getText();
        //  String price = $("#sec_discounted_price", 0).getText();
        System.out.println(count);
        System.out.println(price);
        float firstPriceFLoat = Float.parseFloat(price);
        for (int i = 1; i < count; i++) {
            String secondPrice = $(".ty-price", i).$(".ty-price-num",0).$(byTagName("span"),0).getText();
            float secondPriceFloat = Float.parseFloat(secondPrice);
            Assert.assertTrue(secondPriceFloat >= firstPriceFLoat);
            firstPriceFLoat = secondPriceFloat;
            System.out.println(secondPriceFloat);

        }
    }*/
 /* @Test
  public void ProductName () {
      open("https://gorgia.ge/ka/"); //გაიხსნას გორგიას საიტი
      $(byClassName("ui-icon-closethick")).click(); // დაიხუროს სარეკლამო ბანერი
      $("#search_input").setValue("კედლის კონდიციონერი").pressEnter();
      sleep(5000);
      $(byText("ბრენდი"),0).click();
      $(byText("BAUF")).click();
      sleep(5000);
      int count = $$(".ypi-grid-list__item_body").size();
      String ProductName = $(".product-title",0).$(withText("BAUF")).getText();
      String firstName = ProductName;
      System.out.println(count);
      System.out.println(firstName);
       for(int i = 0; i < count; i++) {
         String SecondName = $(".product-title",i).$(withText("BAUF")).getText();
        System.out.println(SecondName);
      }

  }*/
    @Test
    public void AuthorizationNegative(){
        open("https://gorgia.ge/ka/"); //გაიხსნას გორგიას საიტი
        $(byClassName("ui-icon-closethick")).click();
        $(byClassName("cm-tooltip"), 1).click();
        $(byText("ავტორიზაცია"),0).click();
        $(byName("user_login")).setValue("123123");
        $(byName("password")).setValue("8888");
        sleep(5000);
        $(byName("dispatch[auth.login]")).click();
        $(byId("login_popup600_error_message")).shouldBe(Condition.visible);
        $(".ty-password-forgot__a").click();
        $(".ty-mainbox-title").shouldBe(Condition.visible);




    }



}




