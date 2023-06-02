package is.demo.serenity.interactions;

import is.demo.serenity.ui.PaginaAgregarProductoUI;
import is.demo.serenity.ui.PaginaProductoUI;
import is.demo.serenity.utils.EsperaImplicita;
import is.demo.serenity.utils.Excel;
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


    @Page
    PaginaProductoUI paginaProductoUI;

    @Page
    PaginaAgregarProductoUI paginaAgregarProductoUI;

    private static ArrayList<Map<String, String>> datosExcel = new ArrayList<>();


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "NuevoProducto");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> nuevoProducto = paginaProductoUI.getDriver().findElements(By.xpath(BUTTON_NUEVO_PRODUCTO.getCssOrXPathSelector()));

        nuevoProducto.get(0).click();

        WebElement nombreProducto = paginaAgregarProductoUI.getDriver().findElement(By.xpath(TXT_NOMBRE_PRODUCTO.getCssOrXPathSelector()));
        WebElement unidadesStock = paginaAgregarProductoUI.getDriver().findElement(By.xpath(TXT_UNIDADES_PRODUCTO.getCssOrXPathSelector()));
        WebElement unidadesPedido = paginaAgregarProductoUI.getDriver().findElement(By.xpath(TXT_UNIDADES_PEDIDO.getCssOrXPathSelector()));
        WebElement nivelReorden = paginaAgregarProductoUI.getDriver().findElement(By.xpath(TXT_NIVEL_REORDEN.getCssOrXPathSelector()));
        List<WebElement> guardarProducto = paginaAgregarProductoUI.getDriver().findElements(By.xpath(BUTTON_GUARDAR.getCssOrXPathSelector()));

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
