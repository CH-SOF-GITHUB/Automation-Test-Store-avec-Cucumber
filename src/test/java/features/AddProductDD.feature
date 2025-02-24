Feature: Tester la fonctionnalité ajouter un ou plusieurs produits

  Scenario Outline: Ajouter un produit ou plusieurs produits depuis la page des produits
    Given L'utilisateur est déjà sur la page home Automation Test Store
    When je navigue vers la catégorie <categorie>
    And je clique sur le produit <produit>
    And je clique sur le bouton Add To Chart du poduit <produit>
    Then le produit <produit> doit etre ajouté au panier avec succès
    Examples:
      | categorie   | produit                            |
      | "Skincare"  | "Flash Bronzer Body Gel"           |
      | "Fragrance" | "Gucci Guilty"                     |
      | "Men"       | "Men+Care Clean Comfort Deodorant" |
      | "Books"     | "Paper Towns by John Green"        |