Feature: Topic Creation service

  Background:
    * url kafbatUiUrl
    * configure followRedirects = true
    * configure charset = null


  Scenario: create Topic

    * def topic = 'users'
    Given path 'api/clusters/testCluster/topics/' + topic
    When method DELETE

    * def topicCreationRequest =
    """
      {
        "name": "#(topic)",
        "partitions": 3,
        "replicationFactor": 1,
        "configs": {"retention.ms": 1209600000 , "confluent.value.schema.validation": true }
      }
    """

    Given path 'api/clusters/testCluster/topics'
    And request topicCreationRequest
    When method POST
    Then status 200
