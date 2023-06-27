package questions;

import models.Data;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetEmpleadosQuestion implements Question {
    @Override
    public Data answeredBy(Actor actor) {

        //estamos devolviendo la respuesta JSON y la encapsulamos dentro del modelo data
        return SerenityRest.lastResponse().as(Data.class);
    }
}
