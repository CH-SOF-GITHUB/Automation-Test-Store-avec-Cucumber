package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddProduct {
    WebDriver driver;
    public List<String> names = new ArrayList<>();

    @Given("je suis sur Automation Test Store")
    public void je_suis_sur_automation_test_store() {
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        // methode de gestion d'attentes
        // que des éléments soient disponibles ou que certaines conditions soient remplies.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur une categorie")
    public void jeCliqueSurUneCategorie() {
        WebElement books = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[8]/a"));
        books.click();
    }

    @And("je clique sur produit un")
    public void jeCliqueSurProduitUn() {
        WebElement ProduitUn = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[1]/div[2]/a"));
        ProduitUn.click();
        String name1 = driver.findElement(By.xpath("//*[@id=\"product_details\"]/div/div[2]/div/div/h1/span")).getText();
        names.add(name1);
    }

    @And("je clique sur le bouton Add To Chart en produit un")
    public void jeCliqueSurLeBoutonAddToChartEnProduitUn() {
        WebElement AddToCart1 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/a"));
        AddToCart1.click();
    }

    @And("je retourne à la page des produits")
    public void jeRetourneÀLaPageDesProduits() {
        driver.navigate().back();
        driver.navigate().back();
    }

    @And("je clique sur produit deux")
    public void jeCliqueSurProduitDeux() {
        WebElement ProduitDeux = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[2]/div[2]/a"));
        ProduitDeux.click();
        String name2 = driver.findElement(By.xpath("//*[@id=\"product_details\"]/div/div[2]/div/div/h1/span")).getText();
        names.add(name2);
    }

    @And("je clique sur le bouton Add To Chart en produit deux")
    public void jeCliqueSurLeBoutonAddToChartEnProduitDeux() {
        WebElement AddToChart2 = driver.findElement(By.className("productpagecart"));
        AddToChart2.click();
    }

    @And("affichage des produits ajoutés au panier")
    public void affichageDesProduitsAjoutésAuPanier() {
        // définir le contenu du tableau au panier
        String table = driver.findElement(By.className("product-list")).getText();

        // vérifier que les noms des produits ajoutés s'affichent au panier
        for (int i = 0; i < names.size(); i++) {
            if (table.contains(names.get(i))) {
                System.out.println("le produit " + names.get(i) + " est ajouté avec succès");
            } else {
                System.out.println("échec ajout du produit " + names.get(i));
            }
        }
    }
}
