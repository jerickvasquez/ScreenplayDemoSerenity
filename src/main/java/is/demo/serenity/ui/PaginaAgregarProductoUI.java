package is.demo.serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaAgregarProductoUI extends PageObject {

    public static final Target TXT_NOMBRE_PRODUCTO = Target.the("Nombre producto")
            .locatedBy("//input[@id='Serenity_Demo_Northwind_ProductDialog9_ProductName']");

    public static final Target TXT_UNIDADES_PRODUCTO = Target.the("Unidades producto")
            .locatedBy("//input[@id='Serenity_Demo_Northwind_ProductDialog9_UnitsInStock']");

    public static final Target TXT_UNIDADES_PEDIDO = Target.the("Unidades pedido")
            .locatedBy("//input[@id='Serenity_Demo_Northwind_ProductDialog9_UnitsOnOrder']");

    public static final Target TXT_NIVEL_REORDEN= Target.the("Nivel de reorden")
            .locatedBy("//input[@id='Serenity_Demo_Northwind_ProductDialog9_ReorderLevel']");


    public static final Target BUTTON_GUARDAR= Target.the("Guardar producto")
            .locatedBy("//span[@class='button-inner']");

}
