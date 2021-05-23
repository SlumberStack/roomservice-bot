package roomservice.bot.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import roomservice.bot.*;

import java.util.ArrayList;
import java.util.List;

@Controller("/roomServiceDispatcher")
public class RoomServiceDispatcherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomServiceDispatcherController.class);

    private MenuClient menuClient;

    public RoomServiceDispatcherController(MenuClient menuClient) {
        this.menuClient = menuClient;
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    public String index() {
        return "Example Response";
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Post
    public DialogflowWebHookResponse postMethod(@Body DialogflowWebhookRequest request) {
        Menu menu = this.menuClient.fetchMenu();
//        LOGGER.info("Got menu [body = {}]", new GsonBuilder().create().toJson(menu));
        DialogflowWebHookResponse response =
                DialogflowWebHookResponse
                        .builder()
                        .fulfillmentMessages(
                                makeMeuCards(menu)
                        ).build();
        return response;
    }

    List<DialogflowWebHookResponse.FulfillmentMessage> makeMeuCards(Menu menu) {
        List<DialogflowWebHookResponse.Card> menuCards = MenuResponseFactory.asCardList(menu);
        List<DialogflowWebHookResponse.FulfillmentMessage> fulfillmentMessages = new ArrayList<>();

        for (DialogflowWebHookResponse.Card menuCard : menuCards) {
            fulfillmentMessages.add(
                    DialogflowWebHookResponse
                            .FulfillmentMessage
                            .builder().card(menuCard).build()
            );
        }
        return fulfillmentMessages;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get(uri = "/menu")
    public DialogflowWebHookResponse getMenu() {
        DialogflowWebHookResponse response =
                DialogflowWebHookResponse
                        .builder()
                        .fulfillmentMessage(
                                DialogflowWebHookResponse.FulfillmentMessage
                                        .builder()
                                        .text(
                                                DialogflowWebHookResponse
                                                        .TextFulfillmentMessagePart
                                                        .builder()
                                                        .textItem("Bar")
                                                        .textItem("foo")
                                                        .build()
                                        ).build()
                        ).build();
        return response;
    }
}

