Feature: Tester la fonctionnalité ajout un ou plusieurs produits

  Scenario: tester ajout un ou plusieurs produits
    Given je suis sur Automation Test Store
    When je clique sur une categorie
    And je clique sur produit un
    And je clique sur le bouton Add To Chart en produit un
    And je retourne à la page des produits
    And je clique sur produit deux
    And je clique sur le bouton Add To Chart en produit deux
    And affichage des produits ajoutés au panier
