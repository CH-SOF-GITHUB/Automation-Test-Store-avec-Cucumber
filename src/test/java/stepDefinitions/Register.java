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

public class Register {
    WebDriver driver;

    @Given("je suis sur le site web Automation Test Store")
    public void je_suis_sur_le_site_web_automation_test_store() {
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
    }

    @When("je clique sur le bouton loginorregister")
    public void jeCliqueSurLeBoutonLoginorregister() {
        WebElement LoginOrRegister = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        LoginOrRegister.click();
    }

    @And("je clique sur le bouton Continue")
    public void jeCliqueSurLeBoutonContinue() {
        WebElement Continue = driver.findElement(By.xpath("//button[@title=\"Continue\"]"));
        Continue.click();
    }

    @And("je saisie FirstName")
    public void jeSaisieFirstName() {
        WebElement FirstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        FirstName.sendKeys("John");
    }

    @And("je saisie LastName")
    public void jeSaisieLastName() {
        WebElement LastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        LastName.sendKeys("Doe");
    }

    @And("je saisie Email")
    public void jeSaisieEmail() {
        WebElement Email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        Email.sendKeys("john@gmail.com");
    }

    @And("je saisie Telephone")
    public void jeSaisieTelephone() {
        WebElement Telephone = driver.findElement(By.xpath("//input[@name=\"telephone\"]"));
        Telephone.sendKeys("1234567890");
    }

    @And("je saisie Fax")
    public void jeSaisieFax() {
        WebElement Fax = driver.findElement(By.xpath("//input[@name=\"fax\"]"));
        Fax.sendKeys("1234567890");
    }

    @And("je saisie Company")
    public void jeSaisieCompany() {
        WebElement Company = driver.findElement(By.xpath("//input[@name=\"company\"]"));
        Company.sendKeys("Company AI");
    }

    @And("je saisie FirstAddress")
    public void jeSaisieFirstAddress() {
        WebElement FirstAddress = driver.findElement(By.xpath("//input[@name=\"address_1\"]"));
        FirstAddress.sendKeys("First Address");
    }

    @And("je saisie SecondAddress")
    public void jeSaisieSecondAddress() {
        WebElement SecondAddresse = driver.findElement(By.xpath("//input[@name=\"address_2\"]"));
        SecondAddresse.sendKeys("Second Address");
    }

    @And("je saisie City")
    public void jeSaisieCity() {
        WebElement City = driver.findElement(By.xpath("//input[@name=\"city\"]"));
        City.sendKeys("Sfax");
    }

    @And("je sélectionne Country")
    public void jeSélectionneCountry() throws InterruptedException {
        WebElement Country = driver.findElement(By.xpath("//select[@name=\"country_id\"]"));
        Select selectcountry = new Select(Country);
        selectcountry.selectByValue("214");
        Thread.sleep(2000);
    }

    @And("je sélectionne Region")
    public void jeSélectionneRegion() {
        WebElement Region = driver.findElement(By.xpath("//select[@name=\"zone_id\"]"));
        Select selectregion = new Select(Region);
        selectregion.selectByValue("3307");
    }

    @And("je saisie ZipCode")
    public void jeSaisieZipCode() {
        WebElement ZipCode = driver.findElement(By.xpath("//input[@name=\"postcode\"]"));
        ZipCode.sendKeys("12345");
    }

    @And("je saisie Loginname")
    public void jeSaisieLoginname() {
        WebElement Loginname = driver.findElement(By.xpath("//input[@name=\"loginname\"]"));
        Loginname.sendKeys("John10");
    }

    @And("je saisie Password")
    public void jeSaisiePassword() {
        WebElement Password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        Password.sendKeys("Admin123");
    }

    @And("je saisie PasswordConfirm")
    public void jeSaisiePasswordConfirm() {
        WebElement PasswordConfirm = driver.findElement(By.xpath("//input[@name=\"confirm\"]"));
        PasswordConfirm.sendKeys("Admin123");
    }

    @And("je sélectionne Newsletter")
    public void jeSélectionneNewsletter() {
        WebElement no = driver.findElement(By.xpath("//input[@id=\"AccountFrm_newsletter0\"]"));
        no.click();
    }

    @And("je sélectionne PrivacyPolicy")
    public void jeSélectionnePrivacyPolicy() {
        WebElement PrivacyPolicy = driver.findElement(By.xpath("//input[@name=\"agree\"]"));
        PrivacyPolicy.click();
    }

    @And("je clique sur le bouton de validation Continue")
    public void jeCliqueSurLeBoutonDeValidationContinue() {
        WebElement ValideContinue = driver.findElement(By.xpath("//button[@title=\"Continue\"]"));
        ValideContinue.click();
    }

    @Then("vérification de création de compte")
    public void vérificationDeCréationDeCompte() {
        // vérification register
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://automationteststore.com/index.php?rt=account/success")) {
            System.out.println("compte crée avec succéss et affichage d'un message de confirmation");
        } else {
            System.out.println("échec de création d'un comte Store");
        }
    }
}
