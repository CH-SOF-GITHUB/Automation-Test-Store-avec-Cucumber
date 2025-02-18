package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DeleteProduct {
    // déclaration d'un web driver et ouverture un navigateur chrome
    WebDriver driver;
    // déclaration d'une liste des noms des produits supprimés
    List<String> names = new ArrayList<>();

    @Given("je suis sur le site e-commerce Autoamtion Test Store")
    public void je_suis_sur_le_site_e_commerce_autoamtion_test_store() {
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
    }

    @When("je clique sur categorie")
    public void jeCliqueSurCategorie() {
        // cliquer sur la categorie "Makeup"
        WebElement categorie1 = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[3]/a"));
        categorie1.click();
    }

    @And("je clique sur le produit un")
    public void jeCliqueSurLeProduitUn() {
        // cliquer sur le produit "Tropiques Minerale Loose Bronzer"
        WebElement produit1 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[2]/div[2]/a"));
        produit1.click();
    }

    @And("je clique sur le bouton Add To Chart du produit un")
    public void jeCliqueSurLeBoutonAddToChartDuProduitUn() {
        // cliquer sur Add To Chart du produit "Tropiques Minerale Loose Bronzer"
        WebElement AddToChart1 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[5]/ul/li/a"));
        AddToChart1.click();
    }

    @And("je retourne à la page produits")
    public void jeRetourneÀLaPageProduits() {
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    @And("je clique sur autre categorie")
    public void jeCliqueSurAutreCategorie() {
        // cliquer sur la catégorie "Men"
        WebElement categorie2 = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[6]/a"));
        categorie2.click();
    }

    @And("je clique sur le produit deux")
    public void jeCliqueSurLeProduitDeux() {
        // cliquer sur le produit "Dove Men +Care Body Wash"
        WebElement produit2 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[3]/div[2]/a"));
        produit2.click();
    }

    @And("je clique sur le bouton Add To Chart du produit deux")
    public void jeCliqueSurLeBoutonAddToChartDuProduitDeux() {
        // cliquer sur Add To Chart du produit
        WebElement AddToChart2 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/a"));
        AddToChart2.click();
    }

    @And("je supprime le produit un")
    public void jeSupprimeLeProduitUn() {
        String nameProduit1 = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[2]/a")).getText();
        names.add(nameProduit1);
        WebElement btnDelete1 = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[7]/a"));
        btnDelete1.click();
    }

    @Then("vérification la suppression du produit un")
    public void vérificationLaSuppressionDuProduitUn() {
        // définir le contenu du tableau au panier
        String table = driver.findElement(By.className("product-list")).getText();

        for (int i = 0; i < names.size(); i++) {
            if (!table.contains(names.get(i))) {
                System.out.println("Le produit " + names.get(i) + " est supprimé avec succès");
            } else {
                System.out.println("échec suppression du produit " + names.get(i));
            }
        }
    }
}