Feature: customer features

Background:

  * def sleep = function(millis){ java.lang.Thread.sleep(millis) }
  # Docker compose is not aware of readiness we need to await everything has booted.
  * sleep(20000)

  * call read('classpath:reusable/topic/schema_creator.feature')
  * call read('classpath:reusable/topic/topic_creator.feature')


Scenario: should get all customers

  # Await everything has booted

  Given call read('classpath:reusable/topic/publish.feature')
  # Await message consumed
  And sleep(3000)

  When url baseUrl
  And path '/api/customers'
  And method get
  And status 200

  # Should get 2 customers
  * def response = response

  Then match response == '#[1]'
  And match response[0] == { id: 1, name: 'John Doe',email: 'jone@dot.com'}
