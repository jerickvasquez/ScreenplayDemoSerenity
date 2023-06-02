package is.demo.serenity.task;

import is.demo.serenity.interactions.IngresoCredenciales;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PaginaInicioTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IngresoCredenciales.IngresoCredenciales()
        );
    }

    public static Performable PaginaInicioTask(){
        return instrumented(PaginaInicioTask.class);
    }
}
