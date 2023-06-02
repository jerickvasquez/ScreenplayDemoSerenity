package is.demo.serenity.interactions;

import is.demo.serenity.ui.PaginaInicioUI;
import is.demo.serenity.utils.Excel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static is.demo.serenity.ui.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresoCredenciales implements Interaction {

    @Page
    PaginaInicioUI paginaInicioUI;

    private static ArrayList<Map<String, String>> datosExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "InicioSesion");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        WebElement usuario = paginaInicioUI.getDriver().findElement(By.xpath(TXT_USUARIO.getCssOrXPathSelector()));
        WebElement clave = paginaInicioUI.getDriver().findElement(By.xpath(TXT_CLAVE.getCssOrXPathSelector()));
        WebElement iniciarSesion = paginaInicioUI.getDriver().findElement(By.xpath(BUTTON_INICIAR_SESION.getCssOrXPathSelector()));

        usuario.clear();
        usuario.sendKeys(datosExcel.get(0).get("Usuario"));
        clave.clear();
        clave.sendKeys(datosExcel.get(0).get("Clave"));
        iniciarSesion.click();

    }

    public static Performable IngresoCredenciales(){
        return  instrumented(IngresoCredenciales.class);
    }
}
