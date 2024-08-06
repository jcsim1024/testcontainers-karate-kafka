Feature: customer features

Background:
  * url baseUrl

Scenario: should get all customers
  * path '/api/customers'
  * method get
  * status 200

  # Should get 2 customers
  * def response = response
  * match response == '#[2]'
