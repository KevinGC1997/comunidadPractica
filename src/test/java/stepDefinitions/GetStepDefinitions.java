package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Datum;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.GetEmpleadosQuestion;
import tasks.GetEmpleados;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetStepDefinitions {

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^envia la solictud al api$")
    public void enviaLaSolictudAlApi() {
        OnStage.theActorCalled("Brandon")
                .can(CallAnApi.at("https://dummy.restapiexample.com/api/v1"));
    }


    @When("^realiza la peticion para obtener todos los empleados$")
    public void realizaLaPeticionParaObtenerTodosLosEmpleados() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetEmpleados.here());
    }

    @Then("^valida el nombre de un empleado$")
    public void validaElNombreDeUnEmpleado() {

        //filtro por el getId deseado o el valor  deseado.
        Datum empleados = new GetEmpleadosQuestion()
                .answeredBy(OnStage.theActorInTheSpotlight()).getData()
                .stream().filter(x -> x.getId() == 1).findFirst().orElse(null);

        //assertions para el get
        OnStage.theActorInTheSpotlight().should(
                seeThat("usuario no es nulo", actor -> empleados, notNullValue()),
                seeThat("el nombre del usuario", actor -> empleados.getEmployee_name(), equalTo("Tiger Nixon"))
        );
    }
}
