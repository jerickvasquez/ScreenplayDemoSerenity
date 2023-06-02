package is.demo.serenity.questions;

import is.demo.serenity.ui.PaginaProductoUI;
import is.demo.serenity.utils.EscrituraExcel;
import is.demo.serenity.utils.EsperaImplicita;
import is.demo.serenity.utils.Excel;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static is.demo.serenity.ui.PaginaProductoUI.BUTTON_SIGUIENTE_PAGINA;
import static is.demo.serenity.ui.PaginaProductoUI.LIST_PRODUCTO_BUSCAR;

public class ProductoValidacionQuestion implements Question<Boolean> {

    @Page
    PaginaProductoUI paginaProductoUI;

    private static ArrayList<Map<String, String>> datosExcel = new ArrayList<>();


    @Override
    public Boolean answeredBy(Actor actor) {
        String nombreProductoAsignado= "";
        boolean encontrado = false;

        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "NuevoProducto");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nombreProductoAsignado = datosExcel.get(0).get("NombreProducto");

        JavascriptExecutor js = (JavascriptExecutor) paginaProductoUI.getDriver();

        WebElement siguientePagina = BUTTON_SIGUIENTE_PAGINA.resolveFor(actor);

        ListOfWebElementFacades productosABuscar = LIST_PRODUCTO_BUSCAR.resolveAllFor(actor);


        do {
            for (WebElement producto : productosABuscar) {
                if (producto.getText().equals(nombreProductoAsignado)) {
                    EscrituraExcel.escrituraExcel("datos/Data.xlsx","ProductoPagina",producto.getText(),1,0);
                    js.executeScript("arguments[0].scrollIntoView(true);", producto);
                    EsperaImplicita.esperaImplicita(5);
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado) {
                WebElement ultimoElemento = productosABuscar.get(productosABuscar.size() - 1);
                js.executeScript("arguments[0].scrollIntoView(true);", ultimoElemento);

                EsperaImplicita.esperaImplicita(2);

                 productosABuscar = LIST_PRODUCTO_BUSCAR.resolveAllFor(actor);

                if (productosABuscar.size() > 0 && productosABuscar.get(productosABuscar.size() - 1).getText().equals(ultimoElemento.getText())) {
                    siguientePagina.click();
                    return false;
                }
            }
        } while (!encontrado);

        return encontrado;
    }

    public static Question validacionNombreProducto(){
        return new ProductoValidacionQuestion();
    }
}
