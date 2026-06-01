package automatizacion.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target CART_ITEMS = Target.the("productos en el carrito").locatedBy(".cart_item");
    public static final Target CART_BADGE  = Target.the("contador en el carrito").locatedBy(".shopping_cart_badge");
}
