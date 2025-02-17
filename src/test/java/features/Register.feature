Feature: Tester la fonctionnalité register

  Scenario: tester la fonctionnalité register avec des données valides
    Given je suis sur le site web Automation Test Store
    When je clique sur le bouton loginorregister
    And je clique sur le bouton Continue
    And je saisie FirstName
    And je saisie LastName
    And je saisie Email
    And je saisie Telephone
    And je saisie Fax
    And je saisie Company
    And je saisie FirstAddress
    And je saisie SecondAddress
    And je saisie City
    And je sélectionne Country
    And je sélectionne Region
    And je saisie ZipCode
    And je saisie Loginname
    And je saisie Password
    And je saisie PasswordConfirm
    And je sélectionne Newsletter
    And je sélectionne PrivacyPolicy
    And je clique sur le bouton de validation Continue
    Then vérification de création de compte