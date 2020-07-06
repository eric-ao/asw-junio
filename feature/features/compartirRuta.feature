Feature: Compartir ruta con un amigo

  Scenario: Un usuario quiere compartir una de sus rutas con uno de sus amigos
    Given Un usuario con una ruta creada
    When Voy a la lista de amigos
    And Selecciono una ruta
    Then Le da a compartir con un amigo