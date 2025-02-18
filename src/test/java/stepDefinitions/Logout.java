package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout {
    // déclaration d'un web driver et ouverture un navigateur chrome
    WebDriver driver;

    @Given("je suis sur le site Ecommerce Automation Test Store")
    public void je_suis_sur_le_site_ecommerce_automation_test_store() {
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
    }

    @When("je clique sur le bouton Login or register")
    public void jeCliqueSurLeBoutonLoginOrRegister() {
        WebElement loginOrRegister = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        loginOrRegister.click();
    }

    @And("je saisie login name")
    public void jeSaisieLoginName() {
        WebElement username = driver.findElement(By.xpath("//input[@name=\"loginname\"]"));
        username.sendKeys("ChakerStore1");
    }

    @And("je saisie  password")
    public void jeSaisiePassword() {
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("Azerty123");
    }

    @And("je clique sur le bouton  Login")
    public void jeCliqueSurLeBoutonLogin() {
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@title=\"Login\"]"));
        buttonLogin.click();
    }

    @And("je clique sur le bouton Logoff en sidebar")
    public void jeCliqueSurLeBoutonLogoffEnSidebar() {
        WebElement buttonLogoff = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[2]/div[1]/div/ul/li[10]/a"));
        buttonLogoff.click();
    }

    @Then("redirection vers la page confirmation logout")
    public void redirectionVersLaPageConfirmationLogout() {
        String msg = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/section/p[2]")).getText();
        if (msg.equals("You have been logged off your account. It is now safe to leave the computer.")) {
            System.out.println("déconnexion et redirection vers la page confirmation logout");
        } else {
            System.out.println("échec de déconnexion");
        }
    }
}