package roomservice.bot;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.Introspected;

@ConfigurationProperties(MenuConfiguration.MENU_SERVICE_URL)
public class MenuConfiguration {
    public static final String MENU_SERVICE_URL = "http://localhost:8081/kitchenservice";

    private boolean vegetarianOnly;
    private boolean nightMenu;

    public boolean isVegetarianOnly() {
        return vegetarianOnly;
    }

    public void setVegetarianOnly(boolean vegetarianOnly) {
        this.vegetarianOnly = vegetarianOnly;
    }

    public boolean isNightMenu() {
        return nightMenu;
    }

    public void setNightMenu(boolean nightMenu) {
        this.nightMenu = nightMenu;
    }
}
