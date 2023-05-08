Feature: Comprar Passagem PO

  Scenario: : Comprar Passagem de "San Diego" para "Berlin PO"
    Given que acesso a pagina inicial PO
    When seleciono origem "San Diego" e destino "Berlin" PO
    And clico no botao Find Flights PO
    Then exibe pagina de voos entre "San Diego" e "Berlin" disponiveis PO