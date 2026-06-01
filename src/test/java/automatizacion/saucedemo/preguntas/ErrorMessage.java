package automatizacion.saucedemo.preguntas;

import automatizacion.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ErrorMessage implements Question<String> {
    public static ErrorMessage displayed() {
        return new ErrorMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ERROR_MESSAGE).answeredBy(actor).trim();
    }
}
