package is.demo.serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.serenity.is/Account/Login/?ReturnUrl=%2F")
public class PaginaInicioUI extends PageObject {

    public static final Target TXT_USUARIO = Target.the("Nombre de usuario")
            .locatedBy("//input[@id='LoginPanel0_Username']");

    public static final Target TXT_CLAVE = Target.the("Clave")
            .locatedBy("//input[@id='LoginPanel0_Password']");

    public static final Target BUTTON_INICIAR_SESION = Target.the("Enviar nombre credenciales de inicio de sesion")
            .locatedBy("//button[@id='LoginPanel0_LoginButton']");
}
