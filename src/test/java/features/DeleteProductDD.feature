Feature: Tester la fonctionnalité de la suppression un ou plusieurs produits

  Scenario Outline: supprimer un ou plusieurs produits depuis le panier
    Given L'utilisateur est déjà sur la page d'accueil Automation Test Store
    When je clique sur la catégorie un <categorieUn>
    And je clique sur le produit un <produitUn>
    And je clique sur le bouton Add To Chart du produit un <produitUn>
    And je clique sur la catégorie deux <categorieDeux>
    And je clique sur le produit deux <produitDeux>
    And je clique sur le bouton Add To Chart du produit deux <produitDeux>
    And je clique sur la catégorie trois <categorieTrois>
    And je clique sur le produit trois <produitTrois>
    And je clique sur le bouton Add To Chart du produit trois <produitTrois>
    And je clique sur le bouton suppression du produit <nb> <produit_a_supprimé> pour le supprimer
    Then le produit <produit_a_supprimé> est supprimé du panier avec succès

    Examples:
      | categorieUn | produitUn                                    | categorieDeux | produitDeux                | categorieTrois | produitTrois                       | nb | produit_a_supprimé                 |
      | "Makeup"    | "Tropiques Minerale Loose Bronzer"           | "Skincare"    | "Flash Bronzer Body Gel"   | "Fragrance"    | "Armani Code Pour Femme"           | 2  | "Flash Bronzer Body Gel"           |
      | "Fragrance" | "Calvin Klein Obsession For Women EDP Spray" | "Men"         | "Dove Men +Care Body Wash" | "Hair Care"    | "Eau Parfumee au The Vert Shampoo" | 3  | "Eau Parfumee au The Vert Shampoo" |