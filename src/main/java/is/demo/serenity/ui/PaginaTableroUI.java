package is.demo.serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaTableroUI extends PageObject {

    public static final Target LINK_USUARIO = Target.the("Click a la seccion de productos")
            .locatedBy("//a[@href='/Northwind/Product'][@class='card-footer']");


}
