package roomservice.bot;

import java.util.List;
import java.util.Map;

public class DialogflowRequest {
    OriginalDetectIntentRequest originalDetectIntentRequest;
    private String responseId;
    private String session;

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public OriginalDetectIntentRequest getOriginalDetectIntentRequest() {
        return originalDetectIntentRequest;
    }

    public void setOriginalDetectIntentRequest(OriginalDetectIntentRequest originalDetectIntentRequest) {
        this.originalDetectIntentRequest = originalDetectIntentRequest;
    }

    class QueryResult {
        String queryText;
        Map<String, String> parameters;
        boolean allRequiredParamsPresent;
        String fulfillmentText;
        List<Map<String, Map<String, List<String>>>> fulfillmentMessages;
        List<OutputContext> outputContexts;
        Intent intent;
        int intentDetectionConfidence;
        //                    diagnosticInfo
        String languageCode;

        public String getQueryText() {
            return queryText;
        }

        public void setQueryText(String queryText) {
            this.queryText = queryText;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, String> parameters) {
            this.parameters = parameters;
        }

        public boolean isAllRequiredParamsPresent() {
            return allRequiredParamsPresent;
        }

        public void setAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
            this.allRequiredParamsPresent = allRequiredParamsPresent;
        }

        public String getFulfillmentText() {
            return fulfillmentText;
        }

        public void setFulfillmentText(String fulfillmentText) {
            this.fulfillmentText = fulfillmentText;
        }

        public List<Map<String, Map<String, List<String>>>> getFulfillmentMessages() {
            return fulfillmentMessages;
        }

        public void setFulfillmentMessages(List<Map<String, Map<String, List<String>>>> fulfillmentMessages) {
            this.fulfillmentMessages = fulfillmentMessages;
        }

        public List<OutputContext> getOutputContexts() {
            return outputContexts;
        }

        public void setOutputContexts(List<OutputContext> outputContexts) {
            this.outputContexts = outputContexts;
        }

        public Intent getIntent() {
            return intent;
        }

        public void setIntent(Intent intent) {
            this.intent = intent;
        }

        public int getIntentDetectionConfidence() {
            return intentDetectionConfidence;
        }

        public void setIntentDetectionConfidence(int intentDetectionConfidence) {
            this.intentDetectionConfidence = intentDetectionConfidence;
        }

        public String getLanguageCode() {
            return languageCode;
        }

        public void setLanguageCode(String languageCode) {
            this.languageCode = languageCode;
        }
    }

    class OutputContext {
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

    class Intent {
        String name;
        String displayName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }

    class OriginalDetectIntentRequest {
        String source;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
