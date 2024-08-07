Feature: Schema creator service

  Background:
    * url kafbatUiUrl
    * configure followRedirects = true
    * configure charset = null
    * configure headers = { Accept: '*/*' , Content-Type: 'application/json', Origin: 'http://kafbat-ui:8080'}


  @createSchema
  Scenario: create Avro Schema

    #Clean
    Given path 'api/clusters/testCluster/schemas/users'
    And method DELETE

      # Fomat json to string , TODO set as param
    * def avro_schema = karate.readAsString('avro/User.avsc')

    * def schemaCreationRequest =
    """
      {
        "subject": "users",
        "schema": "##(avro_schema)",
        "schemaType": "AVRO"
      }
    """



    Given path 'api/clusters/testCluster/schemas'
#    add content type json
    And request schemaCreationRequest
    When method POST
    Then status 200
