swagger: "2.0"
info:
  title: RoomService API
  description: Rooms Service.
  version: 1.0.0
host: api.example.com
basePath: /v1
securityDefinitions:
  auth0_jwk:
    authorizationUrl: ""
    flow: "implicit"
    type: "oauth2"
    x-google-issuer: "${TOKEN_ISSUER}"
    x-google-jwks_uri: "${JWKS_URI}"
    x-google-audiences: "${CLIENT_ID}"
  apiKeyAuth:
    type: apiKey
    in: header
    name: X-API-Key
schemes:
  - https
paths:
  /ping:
    get:
      operationId: ping operation
      x-google-backend:
        address: ${function_endpoint}
      summary: Returns a list of users.
      description: Sample function
      produces:
        - text/plain
      security:
        - auth0_jwk: []
      responses:
        200:
          description: OK
  /fulfillment:
    post:
      operationId: Fulfillment operation
      x-google-backend:
        address: https://us-central1-ayo-terraform-admin.cloudfunctions.net/roomservice_bot/roomServiceDispatcher/
      summary: Performs fulfillment.
      description: Chatbot fulfillment
      produces:
        - application/json
      security:
        - apiKeyAuth: []
      responses:
        200:
          description: OK
  /kitchen:
    post:
      operationId: Kitchen operation
      x-google-backend:
        address: ${function_endpoint}
      summary: Performs Kitchen operations.
      description: Chatbot fulfillment
      produces:
        - application/json
      security:
        - auth0_jwk: []
      responses:
        200:
          description: OK
