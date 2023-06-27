Feature: consumir servicio para obtener todos los empleados

  @GETS
  Scenario: Obtener todos los empleados
    Given envia la solictud al api
    When realiza la peticion para obtener todos los empleados
    Then valida el nombre de un empleado