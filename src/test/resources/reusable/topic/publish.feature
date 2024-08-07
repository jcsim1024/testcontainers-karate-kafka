Feature: Publish

  Background:
    * url kafbatUiUrl
    * configure followRedirects = true
    * configure charset = null


  @publishUser
  Scenario: publishUser to topic
    * def topic = 'users'
    * def key =
    """
    {
        "id": 1
    }
    """
    * string stringKey = key

    * def valueAvroFormat =
    """
    {
      "id": {
        "int": 1
      },
      "name": {"string": "John Doe"},
      "email": {"string":"jone@dot.com"}
    }
    """

    * string stringValue = valueAvroFormat

    * def publishRequest =
    """
    {
      "partition": 0,
      "keySerde": "String",
      "valueSerde": "SchemaRegistry",
      "key": "#(stringKey)",
      "content": "#(stringValue)"
    }
    """
    * print publishRequest

    Given path '/api/clusters/testCluster/topics/' + topic + '/messages'
    And request publishRequest
    And header Content-Type = 'application/json'
    When method POST
    Then status 200
