Feature: Usar búsqueda

  Scenario: Búsqueda por categoría
    Given Un usuario que quiere filtrar por categoría
    When Voy a la pestaña del mapa
    And Hace click en la categoría de busqueda y en buscar
    Then Se muestra las rutas correspondientes

  Scenario: Búsqueda por nombre
    Given Un usuario que quiere filtrar por nombre
    When Voy a la pestaña del mapa
    And Introduce el nombre y da a buscar
    Then Se muestra las rutas correspondientes