package automatizacion.saucedemo.preguntas;

import automatizacion.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;

public class CartItemCount implements Question<Integer> {
    public static CartItemCount current() {
        return new CartItemCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        if (!Presence.of(InventoryPage.CART_BADGE).answeredBy(actor)) {
            return 0;
        }
        String text = Text.of(InventoryPage.CART_BADGE).answeredBy(actor).trim();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }
}
