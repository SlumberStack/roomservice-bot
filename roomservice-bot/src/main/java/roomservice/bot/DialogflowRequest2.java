package roomservice.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DialogflowRequest2 {

    QueryResult queryResult;
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


    public QueryResult getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResult queryResultObject) {
        this.queryResult = queryResultObject;
    }

    public OriginalDetectIntentRequest getOriginalDetectIntentRequest() {
        return originalDetectIntentRequest;
    }

    public void setOriginalDetectIntentRequest(OriginalDetectIntentRequest originalDetectIntentRequestObject) {
        this.originalDetectIntentRequest = originalDetectIntentRequestObject;
    }


    class OriginalDetectIntentRequest {


    }

    class QueryResult {
        Map<String, String> parameters;
        List<Map<String,Map<String,List<String>>>> fulfillmentMessages = new ArrayList<>();
        List<OutputContext> outputContexts = new ArrayList<>();
        Intent intent;
        DiagnosticInfo diagnosticInfo;
        private String queryText;
        private boolean allRequiredParamsPresent;
        private String fulfillmentText;
        private float intentDetectionConfidence;
        private String languageCode;

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

        public boolean isAllRequiredParamsPresent() {
            return allRequiredParamsPresent;
        }

        public String getQueryText() {
            return queryText;
        }

        public void setQueryText(String queryText) {
            this.queryText = queryText;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }

        public void setParameters( Map<String, String> parameters) {
            this.parameters = parameters;
        }

        public boolean getAllRequiredParamsPresent() {
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


        public Intent getIntent() {
            return intent;
        }

        public void setIntent(Intent intentObject) {
            this.intent = intentObject;
        }

        public float getIntentDetectionConfidence() {
            return intentDetectionConfidence;
        }

        public void setIntentDetectionConfidence(float intentDetectionConfidence) {
            this.intentDetectionConfidence = intentDetectionConfidence;
        }

        public DiagnosticInfo getDiagnosticInfo() {
            return diagnosticInfo;
        }

        public void setDiagnosticInfo(DiagnosticInfo diagnosticInfoObject) {
            this.diagnosticInfo = diagnosticInfoObject;
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
    class DiagnosticInfo {


    }

    class Intent {
        private String name;
        private String displayName;

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

}
