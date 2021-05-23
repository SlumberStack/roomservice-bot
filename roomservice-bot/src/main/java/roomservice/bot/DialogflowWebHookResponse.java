package roomservice.bot;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class DialogflowWebHookResponse {

    String fulfillmentText;
    @Singular
    List<FulfillmentMessage> fulfillmentMessages;
    String source;
    Payload payload;
    @Singular
    List<OutputContext> outputContexts;
    EventInput followupEventInput;

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public void setFulfillmentText(String fulfillmentText) {
        this.fulfillmentText = fulfillmentText;
    }

    public List<FulfillmentMessage> getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public List<OutputContext> getOutputContexts() {
        return outputContexts;
    }

    public void setOutputContexts(List<OutputContext> outputContexts) {
        this.outputContexts = outputContexts;
    }

    public EventInput getFollowupEventInput() {
        return followupEventInput;
    }

    public void setFollowupEventInput(EventInput followupEventInput) {
        this.followupEventInput = followupEventInput;
    }

    @Data
    @Builder
    public static class Card {
        String title;
        String subtitle;
        String imageUri;
        @Singular
        List<Button> buttons;
        String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getImageUri() {
            return imageUri;
        }

        public void setImageUri(String imageUri) {
            this.imageUri = imageUri;
        }

        public List<Button> getButtons() {
            return buttons;
        }

        public void setButtons(List<Button> buttons) {
            this.buttons = buttons;
        }
    }

    @Data
    @Builder
    public static class Button {
        String text;
        String postback;
        String buttonUrl;

        public String getButtonUrl() {
            return buttonUrl;
        }

        public void setButtonUrl(String buttonUrl) {
            this.buttonUrl = buttonUrl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getPostback() {
            return postback;
        }

        public void setPostback(String postback) {
            this.postback = postback;
        }
    }

    @Data
    @SuperBuilder
    public static class TextFulfillmentMessage {
        TextFulfillmentMessagePart text;

        public TextFulfillmentMessagePart getText() {
            return text;
        }

        public void setText(TextFulfillmentMessagePart text) {
            this.text = text;
        }
    }

    @Data
    @Builder
    public static class TextFulfillmentMessagePart {
        @Singular("textItem")
        List<String> text;

        public List<String> getText() {
            return text;
        }

        public void setText(List<String> text) {
            this.text = text;
        }
    }

    @Data
    @SuperBuilder
    public static class FulfillmentMessage extends TextFulfillmentMessage {
        Card card;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            FulfillmentMessage that = (FulfillmentMessage) o;

            return card != null ? card.equals(that.card) : that.card == null;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (card != null ? card.hashCode() : 0);
            return result;
        }

        public Card getCard() {
            return card;
        }

        public void setCard(Card card) {
            this.card = card;
        }
    }

    static class Payload extends HashMap<String, Object> {
    }

    static class OutputContext {
        String name;
        int lifespanCount;
        Map<String, String> parameters;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLifespanCount() {
            return lifespanCount;
        }

        public void setLifespanCount(int lifespanCount) {
            this.lifespanCount = lifespanCount;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, String> parameters) {
            this.parameters = parameters;
        }
    }

    @Data
    @Builder
    static class EventInput {
        String name;
        String languageCode;
        Map<String, String> parameters;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLanguageCode() {
            return languageCode;
        }

        public void setLanguageCode(String languageCode) {
            this.languageCode = languageCode;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, String> parameters) {
            this.parameters = parameters;
        }
    }
}
