package roomservice.bot;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> specials = Arrays.asList("Tofu");

    public List<String> getSpecials() {
        return specials;
    }

    public void setSpecials(List<String> specials) {
        this.specials = specials;
    }
}
