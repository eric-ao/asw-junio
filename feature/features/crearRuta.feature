Feature: Crear una nueva ruta

  Scenario: Un usuario quiere crear una nueva ruta
    Given Un usuario que quiere crear una nueva ruta
    When Voy a la pestaña del mapa
    And Hago click sobre el mapa para añadir dos puntos
    And Relleno el formulario de la ruta
    Then Se guarda la ruta correctamente y aparece en mi lista de rutas.