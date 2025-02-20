Feature: Tester la fonctionnalité inscription

  Scenario: tester la création d'un compte sur le site Automation Test Store
    Given je suis sur page home du site Automation Test Store
    When je clique sur lien Login or register
    And je clique sur  le bouton Continue
    And je saisie firstname "Saleh"
    And je saisie lastname "Ben Ali"
    And je saisie email "saleh.benali@gmail.com"
    And je saisie telephone "+21623444980"
    And je saisie fax "+21689665390"
    And je saisie company "Société network global"
    And je saisie address1 "Contre de ville, sfax, Tunisie"
    And je saisie address2 "Centre de ville, rue tenour, sfax, Tunisie"
    And je saisie city "Mednine"
    And je sélectionne country "214"
    And je électionne region "3307"
    And je saisie zipcode "26353"
    And je saisie loginname "Saleh122"
    And je saisie motdepasse "Azert1234"
    And je saisie confirmmotdepasse "Azert1234"
    And je clique sur privacy policy
    And je clique sur un bouton Continue
    Then vérification que le compte est crée