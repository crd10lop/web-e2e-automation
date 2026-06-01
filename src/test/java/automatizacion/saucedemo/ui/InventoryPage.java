package automatizacion.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {
    public static final Target CART_BADGE = Target.the("contador del carrito").locatedBy(".shopping_cart_badge");
    public static final Target PAGE_TITLE  = Target.the("titulo de pagina").locatedBy(".title");

    public static Target addToCartButton(String product) {
        String selector = "[data-test='add-to-cart-" + product.toLowerCase().replace(" ", "-") + "']";
        return Target.the("boton agregar " + product).locatedBy(selector);
    }

    public static Target removeFromCartButton(String product) {
        String selector = "[data-test='remove-" + product.toLowerCase().replace(" ", "-") + "']";
        return Target.the("boton eliminar " + product).locatedBy(selector);
    }
}
