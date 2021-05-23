package roomservice.bot;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client(
        value = "${menu_service.url}",
        path = "${menu_service.path}",
        configuration = MenuClientConfiguration.class)
public interface MenuClient {

    @Get("/menu")
    Menu fetchMenu();

}
