package roomservice.bot;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client(MenuConfiguration.MENU_SERVICE_URL)
public interface MenuClient {

    @Get("/menu2")
    Flowable<Menu> fetchMenu();

}
