package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;


public class MainTest extends BaseTest {
    private String selectedProductName;

    private static final String testUserEmail = "__USER_EMAIL__";
    private static final String testUserPassword = "__USER_PASSWORD__";
    private static final String searchTextToTest = "samsung";
    private static final String pageNumberToNavigate = "2";

    @Test(priority = 1, groups = {"Home"})
    public void homePageTest_VerifyHomePage() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToGittiGidiyor();
        homePage.isOnPage();
        Assert.assertTrue(homePage.isOnPage());
    }

    @Test(priority = 1, groups = {"Login"})
    public void loginTest_UserNamePassword() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginToGittiGidiyor(testUserEmail, testUserPassword);
    }

    @Test(priority = 2, groups = {"Search"})
    public void searchProduct_VerifySearchFound() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.searchProduct(searchTextToTest);
        Assert.assertFalse(searchPage.isAnyResultFound());
    }

    @Test(priority = 3, groups = {"Search"})
    public void navigateToPage_VerifyPageNumber() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.navigateToPage(searchTextToTest, pageNumberToNavigate);
        Assert.assertEquals(searchPage.getPageNumber(), pageNumberToNavigate);
    }

    @Test(priority = 4, groups = {"Favorites"})
    public void addToFavorites_verifySelectedProduct() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.selectThirdProduct();

        ProductPage productPage = new ProductPage(driver, wait);
        

    }

}
