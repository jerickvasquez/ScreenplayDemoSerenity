package is.demo.serenity.interactions;

import is.demo.serenity.ui.PaginaAgregarProductoUI;
import is.demo.serenity.ui.PaginaProductoUI;
import is.demo.serenity.utils.EsperaImplicita;
import is.demo.serenity.utils.Excel;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
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

import static is.demo.serenity.ui.PaginaAgregarProductoUI.*;
import static is.demo.serenity.ui.PaginaProductoUI.BUTTON_NUEVO_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarNuevoProducto implements Interaction {




    private static ArrayList<Map<String, String>> datosExcel = new ArrayList<>();


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "NuevoProducto");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ListOfWebElementFacades nuevoProducto = BUTTON_NUEVO_PRODUCTO.resolveAllFor(actor);

        nuevoProducto.get(0).click();

        WebElement nombreProducto = TXT_NOMBRE_PRODUCTO.resolveFor(actor);
        WebElement unidadesStock = TXT_UNIDADES_PRODUCTO.resolveFor(actor);
        WebElement unidadesPedido = TXT_UNIDADES_PEDIDO.resolveFor(actor);
        WebElement nivelReorden = TXT_NIVEL_REORDEN.resolveFor(actor);
        ListOfWebElementFacades guardarProducto = BUTTON_GUARDAR.resolveAllFor(actor);

        nombreProducto.sendKeys(datosExcel.get(0).get("NombreProducto"));
        unidadesStock.sendKeys(datosExcel.get(0).get("UnidadesStock"));
        unidadesPedido.sendKeys(datosExcel.get(0).get("UnidadesPedido"));
        nivelReorden.sendKeys(datosExcel.get(0).get("NivelReorden"));
        EsperaImplicita.esperaImplicita(1);
        guardarProducto.get(6).click();

    }

    public static Performable AgregarNuevoProducto(){
        return  instrumented(AgregarNuevoProducto.class);
    }
}
