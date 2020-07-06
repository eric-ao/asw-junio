Feature: Iniciar sesión en la aplicación

  Scenario: Un usuario ya registrado quiere iniciar sesión en la aplicación
    Given Un usuario que ya tiene cuenta registrada
    When Relleno el formulario con mi webid
    And Relleno el formulario en la página de Solid con mi usuario y contraseña
    Then Inicio sesión y voy a inicio