package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    @Given("je suis sur le Site Web Automation Test Store")
    public void je_suis_sur_le_site_web_automation_test_store() {
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
    }

    @When("je clique sur le bouton login or register")
    public void jeCliqueSurLeBoutonLoginOrRegister() {
        WebElement loginOrRegister = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        loginOrRegister.click();
    }

    @And("je saisie username")
    public void jeSaisieUsername() {
        WebElement username = driver.findElement(By.xpath("//input[@name=\"loginname\"]"));
        username.sendKeys("ChakerStore1");
    }

    @And("je saisie password")
    public void jeSaisiePassword() {
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("Azerty123");
    }

    @And("je clique sur le bouton Login")
    public void jeCliqueSurLeBoutonLogin() {
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@title=\"Login\"]"));
        buttonLogin.click();
    }

    @Then("redirection vers la page home")
    public void redirectionVersLaPageHome() {
        String url = driver.getCurrentUrl();
        if(url.equals("https://automationteststore.com/index.php?rt=account/account")){
            System.out.println("Connexion avec succès");
        }else {
            System.out.println("Echec de connexion");
        }
    }
}