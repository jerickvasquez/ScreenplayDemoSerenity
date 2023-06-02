package is.demo.serenity.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import is.demo.serenity.questions.ProductoValidacionQuestion;
import is.demo.serenity.task.PaginaInicioTask;
import is.demo.serenity.task.PaginaProductoTask;
import is.demo.serenity.task.PaginaTableroTask;
import is.demo.serenity.ui.PaginaInicioUI;
import is.demo.serenity.utils.EsperaImplicita;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AgregarProductoStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver browser;

    private Actor user = Actor.named("user");

    private PaginaInicioUI paginaInicioUI= new PaginaInicioUI();


    @Before
    public void setUp(){
        user.can(BrowseTheWeb.with(browser));
    }

    @Dado("que el usuario abra el navegador en la url y ingrese las credenciales y el usuario de click en inicar sesion")
    public void queElUsuarioAbraElNavegadorEnLaYUrlYIngreseLasCredenciales() {

        user.wasAbleTo(
                Open.browserOn(paginaInicioUI),
                PaginaInicioTask.PaginaInicioTask()
        );
        EsperaImplicita.esperaImplicita(2);
    }

    @Cuando("el usuario de click en la categoria de productos")
    public void elUsuarioDeClickEnLaCategoriaDeProductos() {

        user.attemptsTo(
                PaginaTableroTask.paginaTablero()
        );

    }
    @Cuando("el usuario de click en Nuevo producto y el usuario ingrese los campos obligatorios y de click en guardar")
    public void elUsuarioIngreseLosCamposObligatoriosYDeClickEnGuardar() {

        user.attemptsTo(
                PaginaProductoTask.PaginaProductoTask()
        );
        EsperaImplicita.esperaImplicita(2);

    }
    @Entonces("el usuario podra visualizar el nombre del nuevo producto")
    public void elUsuarioPodraVisualizarElNombreDelProducto() {
        user.should(
                seeThat(
                        "Se visualiza el nombre del producto agregado",
                        ProductoValidacionQuestion.validacionNombreProducto(),
                        Matchers.equalTo(true)
                )
        );
    }


}
