Feature: Schema creator service

  Background:
    * url kafbatUiUrl
    * configure followRedirects = true
    * configure charset = null
    * configure headers = { Accept: '*/*' , Content-Type: 'application/json', Origin: 'http://kafbat-ui:8080'}


  @createSchema
  Scenario: create Avro Schema


    * def topic = 'users'
      # See topic name strategy https://docs.confluent.io/platform/current/schema-registry/fundamentals/serdes-develop/index.html#overview
    * def subject = topic+'-value'

      #Clean
    Given path 'api/clusters/testCluster/schemas/' + subject
    And method DELETE

      # Fomat json to string , TODO set as param
    * def avro_schema = karate.readAsString('avro/User.avsc')

    * def schemaCreationRequest =
    """
      {
        "subject": "#(subject)",
        "schema": "#(avro_schema)",
        "schemaType": "AVRO"
      }
    """



    Given path 'api/clusters/testCluster/schemas'
#    add content type json
    And request schemaCreationRequest
    When method POST
    Then status 200
