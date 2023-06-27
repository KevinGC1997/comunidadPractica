package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;


public class PostNuevoEmpleado implements Task {

    private final Object userInfo;//ajustamos a tipo object para q nos reciba cualquier tipo

    public PostNuevoEmpleado(Object userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Post.to("/create").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo))
        );

    }
    public static PostNuevoEmpleado here(Object userInfo){
        return Instrumented.instanceOf(PostNuevoEmpleado.class).withProperties(userInfo);
    }
}
