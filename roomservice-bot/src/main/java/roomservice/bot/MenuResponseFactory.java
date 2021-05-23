package roomservice.bot;

import java.util.ArrayList;
import java.util.List;

public class MenuResponseFactory {
    public static List<DialogflowWebHookResponse.Card> asCardList(Menu menu) {
        List<DialogflowWebHookResponse.Card> menuCardList = new ArrayList<>();
        makeMenuCard(menu, menuCardList);
        return menuCardList;
    }

    private static void makeMenuCard(Menu menu, List<DialogflowWebHookResponse.Card> cardList) {

        cardList.add(
                DialogflowWebHookResponse
                        .Card
                        .builder()
                        .title(menu.getTitle())
                        .subtitle(menu.getSubtitle())
                        .imageUri(menu.getImageUri())
                        .text(menu.getDescription())
                        .build());
        if ( menu.getSubMenus() != null ) {
            for (Menu subMenu : menu.getSubMenus()) {
                makeMenuCard(subMenu, cardList);
            }
        }
    }
}
