Feature: Tester la fonctionnalité login

  Scenario: tester login avec des données valides
    Given je suis sur le Site Web Automation Test Store
    When  je clique sur le bouton login or register
    And  je saisie username
    And  je saisie password
    And je clique sur le bouton Login
    Then redirection vers la page home