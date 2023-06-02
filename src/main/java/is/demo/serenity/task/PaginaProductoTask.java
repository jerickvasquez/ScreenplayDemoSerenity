package is.demo.serenity.task;

import is.demo.serenity.interactions.AgregarNuevoProducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PaginaProductoTask implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                AgregarNuevoProducto.AgregarNuevoProducto()

        );
    }

    public static Performable PaginaProductoTask(){
        return instrumented(PaginaProductoTask.class);
    }
}
