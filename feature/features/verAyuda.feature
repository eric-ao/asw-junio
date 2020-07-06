Feature: Visitar la página de ayuda de la aplicación

  Scenario: Se encuentra con la sesión iniciada en la página principal
    Given Un usuario que quiere ver la pestaña de ayuda
    When Le hago click a Ayuda en la barra de navegación superior
    Then Se carga la pestaña de Ayuda