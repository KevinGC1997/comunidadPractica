Feature: consumir servicio para crear un empleado

  @POST
  Scenario: Crear un empleado
    Given envia la solictud al api
    When realiza la peticion para crear un empleado
    Then valida el status de la peticion