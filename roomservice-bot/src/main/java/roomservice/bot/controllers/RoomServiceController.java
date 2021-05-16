package roomservice.bot.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Flowable;
import roomservice.bot.DialogflowRequest;
import roomservice.bot.Menu;
import roomservice.bot.MenuClient;

@Controller("/menuservice")
public class RoomServiceController {

    private MenuClient menuClient;

    public RoomServiceController(MenuClient menuClient) {
        this.menuClient = menuClient;
    }

    @Get(uri = "/menu")
    Flowable<Menu> menu() {
        return this.menuClient.fetchMenu();
    }

    @Get(uri = "/menu2")
    public String menu2() {
        return "Today's specials";
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello World";
    }

    @Post(uri = "/df-webhook", produces = MediaType.APPLICATION_JSON)
    public String dfWebHook(DialogflowRequest dialogflowWebHookReq) {
        return "{\"a\": true}";
    }
}
