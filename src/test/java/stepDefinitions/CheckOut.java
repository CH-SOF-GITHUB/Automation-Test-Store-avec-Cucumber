package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckOut {
    // déclaration d'un web driver et ouverture un navigateur chrome
    WebDriver driver;

    @Given("je suis sur site Automation Test Store")
    public void je_suis_sur_site_automation_test_store() {
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
    }

    @When("je clique sur bouton login or register")
    public void jeCliqueSurBoutonLoginOrRegister() {
        WebElement loginOrRegister = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        loginOrRegister.click();
    }

    @And("je saisie un username")
    public void jeSaisieUnUsername() {
        WebElement username = driver.findElement(By.xpath("//input[@name=\"loginname\"]"));
        username.sendKeys("ChakerStore1");
    }

    @And("je saisie un password")
    public void jeSaisieUnPassword() {
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("Azerty123");
    }

    @And("je clique sur bouton Login")
    public void jeCliqueSurBoutonLogin() {
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@title=\"Login\"]"));
        buttonLogin.click();
    }

    @And("je clique sur une ctaegorie produit au menu")
    public void jeCliqueSurUneCtaegorieProduitAuMenu() {
        // cliquer sur categorie "Apparel & accessories"
        WebElement categorie = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[2]/a"));
        categorie.click();
    }

    @And("je clique sur un produit pour accéder aux détails")
    public void jeCliqueSurUnProduitPourAccéderAuxDétails() {
        // cliquer sur le produit "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie"
        WebElement produit = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[4]/div[2]/a"));
        produit.click();
    }

    @And("je clique sur bouton Add To Chart")
    public void jeCliqueSurBoutonAddToChart() {
        // cliquer sur le bouton add to chart du produit "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie"
        WebElement AddToChart = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[6]/ul/li/a"));
        AddToChart.click();
    }

    @And("je clique sur bouton Checkout")
    public void jeCliqueSurBoutonCheckout() {
        // cliquer sur le bouton checkout du produit "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie"
        WebElement Checkout = driver.findElement(By.xpath("//*[@id=\"cart_checkout1\"]"));
        Checkout.click();
    }

    @And("je clique sur bouton Confirm Order")
    public void jeCliqueSurBoutonConfirmOrder() throws InterruptedException {
        WebElement ConfirmOrder = driver.findElement(By.className("lock-on-click"));
        ConfirmOrder.click();
        Thread.sleep(5000);
    }

    @Then("redirection vers page de confirmation Checkout")
    public void redirectionVersPageDeConfirmationCheckout() {
        String msg_confirm = driver.findElement(By.className("maintext")).getText();
        System.out.println(msg_confirm);
        if (msg_confirm.equals("YOUR ORDER HAS BEEN PROCESSED!")) {
            System.out.println("confirmation Checkout avec succès");
        } else {
            System.out.println("échec confirmation Checkout");
        }
    }
}
