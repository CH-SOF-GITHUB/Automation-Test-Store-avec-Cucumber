Feature: Tester la fonctionnalité de connexion

  Scenario Outline: tester la connexion au site e-commerce avec données valides et invalides
    Given je suis sur la page home de site Automation Test Store
    When je clique sur Login or Register
    And je saisie username <username>
    And je saisie password <password>
    And je clique sur le bouton de connexion
    Then échec de connexion et affichage un message d'erreur
    Examples:
    |username                  |password|
    |"ChakerStore1"              |"Azerty123"|
    |"ChakerStore34"             |"AzertY123"     |
    |"ChakerStore1"              |"Azert12345"|
    |"ChakerStore40"             |"Azerty1" |
    |"ChakerStore1"              |""        |
    |"ChakerStore110"            |""        |
    |""                        |"Azerty123" |
    |""                        |"Azert123"  |
    |""                        |""        |