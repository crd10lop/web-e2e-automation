package automatizacion.saucedemo.tareas;

import automatizacion.saucedemo.Constants;
import automatizacion.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {
    private final String username;
    private final String password;

    private Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withCredentials(String username, String password) {
        return new Login(username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(Constants.BASE_URL),
            PauseDemo.of(800),
            WaitUntil.the(LoginPage.USERNAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
            Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
            PauseDemo.of(600),
            Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
            PauseDemo.of(600),
            Click.on(LoginPage.LOGIN_BUTTON),
            PauseDemo.of(1200)
        );
    }
}
