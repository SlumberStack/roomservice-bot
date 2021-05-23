# Room Service Virtual Assistant Dispatcher

Receives WebHook requests from Google Dialogflow and dispatches to back-end services

## Running locally
```cmd
./gradlew runFunction
```

### Verify locally
```bash
curl -X POST \
    -H "Content-type: application/json" \
    -d @src/test/resources/webHookRequest2.json \
    localhost:8080/roomServiceDispatcher
```


## Deployment

```bash
./gradlew clean shadowJar
(cd build/libs
gcloud beta functions deploy roomservice_bot \
    --allow-unauthenticated \
    --entry-point io.micronaut.gcp.function.http.HttpFunction \
    --runtime java11 --trigger-http)
```

### Test invocation
```bash
HTTP_TRIGGER_URL=$(gcloud beta functions describe roomservice_bot \
    --format='value(httpsTrigger.url)')
curl -X POST \
    -H "Content-type: application/json" \
    -d @src/test/resources/webHookRequest2.json \
    ${HTTP_TRIGGER_URL}/roomServiceDispatcher
```
