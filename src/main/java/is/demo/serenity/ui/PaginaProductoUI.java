package is.demo.serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaProductoUI extends PageObject {

    public static final Target BUTTON_NUEVO_PRODUCTO = Target.the("Click nuevo producto")
            .locatedBy("//span[@class='button-inner']");

    public static final Target BUTTON_SIGUIENTE_PAGINA = Target.the("Click siguiente pagina")
            .locatedBy("//div[@class='slick-pg-next slick-pg-btn']");

    public static final Target LIST_PRODUCTO_BUSCAR = Target.the("Lista productos a buscar")
            .locatedBy("//div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']/div[@class ='slick-cell l1 r1']/a[starts-with(@href,'#Demo-Northwind-Product/')]");


}
