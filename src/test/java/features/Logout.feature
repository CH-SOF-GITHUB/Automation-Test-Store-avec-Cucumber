Feature: Tester la fonctionnalité Logout

  Scenario: tester la déconnexion de site web Automation Test Store
    Given je suis sur le site Ecommerce Automation Test Store
    When je clique sur le bouton Login or register
    And je saisie login name
    And je saisie  password
    And je clique sur le bouton  Login
    And je clique sur le bouton Logoff en sidebar
    Then redirection vers la page confirmation logout