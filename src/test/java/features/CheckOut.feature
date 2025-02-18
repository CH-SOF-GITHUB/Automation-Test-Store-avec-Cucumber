Feature: Tester la fonctionnalité CheckOut

  Scenario: tester CheckOut pour un ou plusieurs produits aprés la connexion
    Given je suis sur site Automation Test Store
    When je clique sur bouton login or register
    And je saisie un username
    And je saisie un password
    And je clique sur bouton Login
    And je clique sur une ctaegorie produit au menu
    And je clique sur un produit pour accéder aux détails
    And je clique sur bouton Add To Chart
    And je clique sur bouton Checkout
    And je clique sur bouton Confirm Order
    Then redirection vers page de confirmation Checkout