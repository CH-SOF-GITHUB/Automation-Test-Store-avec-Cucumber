package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginDD {
    WebDriver driver;

    @Given("je suis sur la page home de site Automation Test Store")
    public void je_suis_sur_la_page_home_de_site_automation_test_store() {
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur Login or Register")
    public void jeCliqueSurLoginOrRegister() {
        WebElement loginOrRegister = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        loginOrRegister.click();
    }

    @And("je saisie username {string}")
    public void jeSaisieUsernameUsername(String username) {
        WebElement Username;
        Username = driver.findElement(By.xpath("//input[@name=\"loginname\"]"));
        Username.sendKeys(username);
    }

    @And("je saisie password {string}")
    public void jeSaisiePasswordPassword(String password) {
        WebElement Password;
        Password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        Password.sendKeys(password);
    }

    @And("je clique sur le bouton de connexion")
    public void jeCliqueSurLeBoutonDeConnexion() {
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@title=\"Login\"]"));
        buttonLogin.click();
    }

    @Then("échec de connexion et affichage un message d'erreur")
    public void échecDeConnexionEtAffichageUnMessageDErreur() {
        String url = driver.getCurrentUrl();
        if (url.equals("https://automationteststore.com/index.php?rt=account/account")) {
            System.out.println("Connexion avec succès");
        } else {
            System.out.println("Echec de connexion");
        }
        // fermer le navigateur
        driver.quit();
    }
}