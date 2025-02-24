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
import java.util.ArrayList;
import java.util.List;

public class AddProductDD {
    // déclaration et initialisation de web driver
    WebDriver driver;

    // déclaration d'une liste des noms des produits ajoutés
    List<String> namesOfproducts = new ArrayList<>();

    @Given("L'utilisateur est déjà sur la page home Automation Test Store")
    public void l_utilisateur_est_déjà_sur_la_page_home_automation_test_store() {
        // controle et ouverture d'un navigateur Google Chrome
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        // attendre un temps implicite de 10s avant de générer une exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je navigue vers la catégorie {string}")
    public void jeNavigueVersLaCatégorieCategorie(String categorie) {
        WebElement categoryLink = driver.findElement(By.linkText(categorie.toUpperCase()));
        categoryLink.click();
        System.out.println("je clique sur la catégorie " + categorie);
    }

    @And("je clique sur le produit {string}")
    public void jeCliqueSurLeProduitProduit(String produit) {
        WebElement productLink = driver.findElement(By.linkText(produit.toUpperCase()));
        productLink.click();
        namesOfproducts.add(produit);
        System.out.println("je clique sur le produit " + produit);
    }

    @And("je clique sur le bouton Add To Chart du poduit {string}")
    public void jeCliqueSurLeBoutonAddToChartDuPoduitProduit(String produit) {
        WebElement AddToChart = driver.findElement(By.className("productpagecart"));
        AddToChart.click();
        System.out.println("je clique sur le bouton add to chart du produit " + produit);
    }

    @Then("le produit {string} doit etre ajouté au panier avec succès")
    public void leProduitProduitDoitEtreAjoutéAuPanierAvecSuccès(String produit) {
        // déclaration de tableau de panier qui contient les produits
        String table_product_list = driver.findElement(By.className("product-list")).getText();

        for (int i = 0; i < namesOfproducts.size(); i++) {
            if (table_product_list.contains(namesOfproducts.get(i))) {
                System.out.println("\nLe produit " + produit + " est ajouté et dans le panier !");
            } else {
                System.out.println("\nLe produit " + produit + " n'est pas dans le panier !");
            }
        }

        // fermer le navigateur
        driver.close();
    }
}