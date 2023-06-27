package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.empleadoJson;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.responseCode;
import tasks.PostNuevoEmpleado;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PostStepDefinitions {

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^realiza la peticion para crear un empleado$")
    public void realizaLaPeticionParaCrearUnEmpleado() {
        //creamos nuestro objeto modelo, para setear los valores que necesitamos de nuestro Json
        empleadoJson empleado = new empleadoJson();
        empleado.setName("kevin");
        empleado.setSalary("2000");
        empleado.setAge("10");

        //para llamar la taks
        OnStage.theActorInTheSpotlight().attemptsTo(PostNuevoEmpleado.here(empleado));
    }

    @Then("^valida el status de la peticion$")
    public void validaElStatusDeLaPeticion() {
        //una assertions
        OnStage.theActorInTheSpotlight().should(
                seeThat("el codigo de la respuesta", responseCode.was(), equalTo(200)));
    }
}
