package is.demo.serenity.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static is.demo.serenity.ui.PaginaTableroUI.LINK_USUARIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PaginaTableroTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(LINK_USUARIO)
        );

    }
    public static PaginaTableroTask paginaTablero() {
        return instrumented(PaginaTableroTask.class);
    }
}
