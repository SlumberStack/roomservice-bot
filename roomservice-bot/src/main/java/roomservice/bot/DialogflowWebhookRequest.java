package roomservice.bot;

import java.util.List;
import java.util.Map;

public class DialogflowWebhookRequest {
    OriginalDetectIntentRequest originalDetectIntentRequest;
    QueryResult queryResult;
    private String responseId;
    private String session;

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

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

    public static class QueryResult {
        String queryText;
        String action;
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

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
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

    static class Intent {
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

    static class OriginalDetectIntentRequest {
        String source;
        String version;
        Payload payload;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Payload getPayload() {
            return payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }

    static class Payload {
        boolean inSandbox;
        List<Input> inputs;

        public boolean isInSandbox() {
            return inSandbox;
        }

        public void setInSandbox(boolean inSandbox) {
            this.inSandbox = inSandbox;
        }

        public List<Input> getInputs() {
            return inputs;
        }

        public void setInputs(List<Input> inputs) {
            this.inputs = inputs;
        }
    }

    static class Input {
        String intent;
        List<RawInput> rawInputs;
        List<InputArgument> inputArguments;

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        public List<RawInput> getRawInputs() {
            return rawInputs;
        }

        public void setRawInputs(List<RawInput> rawInputs) {
            this.rawInputs = rawInputs;
        }

        public List<InputArgument> getInputArguments() {
            return inputArguments;
        }

        public void setInputArguments(List<InputArgument> inputArguments) {
            this.inputArguments = inputArguments;
        }
    }

    static class RawInput {
        String query;
        String inputType;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getInputType() {
            return inputType;
        }

        public void setInputType(String inputType) {
            this.inputType = inputType;
        }
    }

    static class InputArgument {
        String rawText;
        String textValue;
        String name;

        public String getRawText() {
            return rawText;
        }

        public void setRawText(String rawText) {
            this.rawText = rawText;
        }

        public String getTextValue() {
            return textValue;
        }

        public void setTextValue(String textValue) {
            this.textValue = textValue;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
