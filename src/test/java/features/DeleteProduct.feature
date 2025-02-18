Feature: Tester la fonctionnalité suppression un ou plusieurs produits

  Scenario: tester la suppression un ou plusieurs produits
    Given je suis sur le site e-commerce Autoamtion Test Store
    When je clique sur categorie
    And je clique sur le produit un
    And je clique sur le bouton Add To Chart du produit un
    And je retourne à la page produits
    And je clique sur autre categorie
    And je clique sur le produit deux
    And je clique sur le bouton Add To Chart du produit deux
    And je supprime le produit un
    Then vérification la suppression du produit un