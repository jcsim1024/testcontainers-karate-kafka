Feature: customer features

Background:
  * call read('classpath:reusable/topic/schema_creator.feature')
  * call read('classpath:reusable/topic/topic_creator.feature')





Scenario: should get all customers

  * def message =
  """
      {
        "id": 1,
        "name": "John Doe"
      }
  """
  * call read('classpath:reusable/topic/publish.feature')

  * url baseUrl
  * path '/api/customers'
  * method get
  * status 200

  # Should get 2 customers
  * def response = response
  * match response == '#[1]'
