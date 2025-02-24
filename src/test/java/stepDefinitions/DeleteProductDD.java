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

public class DeleteProductDD {
    // déclaration et initialisation de web driver
    WebDriver driver;

    @Given("L'utilisateur est déjà sur la page d'accueil Automation Test Store")
    public void l_utilisateur_est_déjà_sur_la_page_d_accueil_automation_test_store() {
        // controle et ouverture d'un navigateur Google Chrome
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();
        // attendre un temps implicite de 10s avant de générer une exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur la catégorie un {string}")
    public void jeCliqueSurLaCatégorieUnCategorieUn(String categorie1) {
        WebElement category1Link = driver.findElement(By.linkText(categorie1.toUpperCase()));
        category1Link.click();
        System.out.println("je clique sur la catégorie 1: " + categorie1);
    }

    @And("je clique sur le produit un {string}")
    public void jeCliqueSurLeProduitUnProduitUn(String produit1) {
        WebElement product1Link = driver.findElement(By.linkText(produit1.toUpperCase()));
        product1Link.click();
        System.out.println("je clique sur le produit 1: " + produit1);
    }

    @And("je clique sur le bouton Add To Chart du produit un {string}")
    public void jeCliqueSurLeBoutonAddToChartDuProduitUnProduitUn(String produit1) {
        WebElement AddToChart1 = driver.findElement(By.className("productpagecart"));
        AddToChart1.click();
        System.out.println("je clique sur le bouton add to chart du produit 1: " + produit1);
    }

    @And("je clique sur la catégorie deux {string}")
    public void jeCliqueSurLaCatégorieDeuxCategorieDeux(String categorie2) {
        WebElement category2Link = driver.findElement(By.linkText(categorie2.toUpperCase()));
        category2Link.click();
        System.out.println("je clique sur la catégorie 2: " + categorie2);
    }

    @And("je clique sur le produit deux {string}")
    public void jeCliqueSurLeProduitDeuxProduitDeux(String produit2) {
        WebElement product2Link = driver.findElement(By.linkText(produit2.toUpperCase()));
        product2Link.click();
        System.out.println("je clique sur le produit 2: " + produit2);
    }

    @And("je clique sur le bouton Add To Chart du produit deux {string}")
    public void jeCliqueSurLeBoutonAddToChartDuProduitDeuxProduitDeux(String produit2) {
        WebElement AddToChart2 = driver.findElement(By.className("productpagecart"));
        AddToChart2.click();
        System.out.println("je clique sur le bouton add to chart du produit 2: " + produit2);
    }

    @And("je clique sur la catégorie trois {string}")
    public void jeCliqueSurLaCatégorieTroisCategorieTrois(String categorie3) {
        WebElement category3Link = driver.findElement(By.linkText(categorie3.toUpperCase()));
        category3Link.click();
        System.out.println("je clique sur la catégorie 3: " + categorie3);
    }

    @And("je clique sur le produit trois {string}")
    public void jeCliqueSurLeProduitTroisProduitTrois(String produit3) {
        WebElement product3Link = driver.findElement(By.linkText(produit3.toUpperCase()));
        product3Link.click();
        System.out.println("je clique sur le produit 3: " + produit3);
    }

    @And("je clique sur le bouton Add To Chart du produit trois {string}")
    public void jeCliqueSurLeBoutonAddToChartDuProduitTroisProduitTrois(String produit3) {
        WebElement AddToChart3 = driver.findElement(By.className("productpagecart"));
        AddToChart3.click();
        System.out.println("je clique sur le bouton add to chart du produit 3: " + produit3);
    }

    @And("je clique sur le bouton suppression du produit {int} {string} pour le supprimer")
    public void jeCliqueSurLeBoutonSuppressionDuProduitNbProduit_a_suppriméPourLeSupprimer(int nb, String produit_a_supprimé) {
        WebElement BtnDelete = driver.findElement(By.xpath("//*[@id='cart']/div/div[1]/table/tbody/tr[" + (nb + 1) + "]/td[7]/a"));
        BtnDelete.click();
        System.out.println("je clique sur le bouton delete au panier pour supprimer le produit " + nb + " " + produit_a_supprimé);
    }

    @Then("le produit {string} est supprimé du panier avec succès")
    public void leProduitProduit_a_suppriméEstSuppriméDuPanierAvecSuccès(String produit_a_supprimé) {
        // définir le contenu du tableau au panier
        String table = driver.findElement(By.className("product-list")).getText();

        if (!table.contains(produit_a_supprimé)) {
            System.out.println("\nLe produit " + produit_a_supprimé + " a été supprimé avec succès !");
        } else {
            System.out.println("\nLe produit " + produit_a_supprimé + " n'a pas été supprimé correctement");
        }
        // fermer le navigateur
        driver.close();
    }
}