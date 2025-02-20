package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RegisterDD {
    WebDriver driver;

    @Given("je suis sur page home du site Automation Test Store")
    public void je_suis_sur_page_home_du_site_automation_test_store() {
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur lien Login or register")
    public void jeCliqueSurLienLoginOrRegister() {
        WebElement LoginOrRegister = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        LoginOrRegister.click();
    }

    @And("je clique sur  le bouton Continue")
    public void jeCliqueSurLeBoutonContinue() {
        WebElement Continue = driver.findElement(By.xpath("//button[@title=\"Continue\"]"));
        Continue.click();
    }

    @And("je saisie firstname {string}")
    public void jeSaisieFirstname(String firstname) {
        WebElement FirstName;
        FirstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        FirstName.sendKeys(firstname);
    }

    @And("je saisie lastname {string}")
    public void jeSaisieLastname(String lastname) {
        WebElement LastName;
        LastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        LastName.sendKeys(lastname);
    }

    @And("je saisie email {string}")
    public void jeSaisieEmail(String email) {
        WebElement Email;
        Email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        Email.sendKeys(email);
    }

    @And("je saisie telephone {string}")
    public void jeSaisieTelephone(String telephone) {
        WebElement Telephone;
        Telephone = driver.findElement(By.xpath("//input[@name=\"telephone\"]"));
        Telephone.sendKeys(telephone);
    }

    @And("je saisie fax {string}")
    public void jeSaisieFax(String fax) {
        WebElement Fax;
        Fax = driver.findElement(By.xpath("//input[@name=\"fax\"]"));
        Fax.sendKeys(fax);
    }

    @And("je saisie company {string}")
    public void jeSaisieCompany(String companyname) {
        WebElement Company;
        Company = driver.findElement(By.xpath("//input[@name=\"company\"]"));
        Company.sendKeys(companyname);
    }

    @And("je saisie address{int} {string}")
    public void jeSaisieAddress(int nb, String adresse) {
        WebElement Address;
        Address = driver.findElement(By.xpath(String.format("//input[@name='address_%d']", nb)));
        Address.sendKeys(adresse);
    }

    @And("je saisie city {string}")
    public void jeSaisieCity(String city) {
        WebElement City;
        City = driver.findElement(By.xpath("//input[@name=\"city\"]"));
        City.sendKeys(city);
    }

    @And("je sélectionne country {string}")
    public void jeSélectionneCountry(String countrynumber) throws InterruptedException {
        WebElement Country = driver.findElement(By.xpath("//select[@name=\"country_id\"]"));
        Select selectcountry = new Select(Country);
        selectcountry.selectByValue(countrynumber);
        Thread.sleep(2000);
    }

    @And("je électionne region {string}")
    public void jeÉlectionneRegion(String regionnumber) {
        WebElement Region = driver.findElement(By.xpath("//select[@name=\"zone_id\"]"));
        Select selectregion = new Select(Region);
        selectregion.selectByValue(regionnumber);
    }

    @And("je saisie zipcode {string}")
    public void jeSaisieZipcode(String zipcode) {
        WebElement ZipCode;
        ZipCode = driver.findElement(By.xpath("//input[@name=\"postcode\"]"));
        ZipCode.sendKeys(zipcode);
    }

    @And("je saisie loginname {string}")
    public void jeSaisieLoginname(String loginname) {
        WebElement Loginname;
        Loginname = driver.findElement(By.xpath("//input[@name=\"loginname\"]"));
        Loginname.sendKeys(loginname);
    }

    @And("je saisie motdepasse {string}")
    public void jeSaisieMotdepasse(String motdepasse) {
        WebElement Password;
        Password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        Password.sendKeys(motdepasse);
    }

    @And("je saisie confirmmotdepasse {string}")
    public void jeSaisieConfirmmotdepasse(String confirmmotdepasse) {
        WebElement PasswordConfirm;
        PasswordConfirm = driver.findElement(By.xpath("//input[@name=\"confirm\"]"));
        PasswordConfirm.sendKeys(confirmmotdepasse);
    }

    @And("je clique sur privacy policy")
    public void jeCliqueSurPrivacyPolicy() {
        WebElement PrivacyPolicy = driver.findElement(By.xpath("//input[@name=\"agree\"]"));
        PrivacyPolicy.click();
    }

    @And("je clique sur un bouton Continue")
    public void jeCliqueSurUnBoutonContinue() {
        WebElement BtnContinue = driver.findElement(By.xpath("//button[@title=\"Continue\"]"));
        BtnContinue.click();
    }

    @Then("vérification que le compte est crée")
    public void vérificationQueLeCompteEstCrée() {
        // vérification register
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://automationteststore.com/index.php?rt=account/success")) {
            System.out.println("compte crée avec succéss et affichage d'un message de confirmation");
        } else {
            System.out.println("échec de création d'un comte Store");
        }
    }
}
