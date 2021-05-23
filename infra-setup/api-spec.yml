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
