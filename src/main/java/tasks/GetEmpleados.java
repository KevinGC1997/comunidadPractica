package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class GetEmpleados implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/employees")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("Content-Type","application/json")
                        )
        );
    }
    public static GetEmpleados here(){
        return Instrumented.instanceOf(GetEmpleados.class).withProperties();
    }
}
