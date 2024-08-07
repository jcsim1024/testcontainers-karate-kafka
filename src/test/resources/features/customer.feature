Feature: customer features

Background:
  * call read('classpath:reusable/topic/schema_creator.feature')




Scenario: should get all customers
  * url baseUrl
  * path '/api/customers'
  * method get
  * status 200

  # Should get 2 customers
  * def response = response
  * match response == '#[2]'
