Feature: Ver detalles de una de nuestras rutas

  Scenario: Quiero ver los detalles de una de mis rutas
    Given Un usuario que quiere ver los detalles de una de sus rutas creadas
    When Voy a la pestaña del mapa
    And Hago click sobre una de mis rutas
    Then Se muestra la ruta y sus descripción