Feature: Users api tests

  Background:
    Given baseUri is https://jsonplaceholder.typicode.com


  Scenario: Add new data to jsonplaceholder
    When I set body to {"name":"Tony","username":"Stark","email":"tony.stark@gmail.com"}
    And I POST /posts
    Then response header Content-Type should not be application/xml
    And response code should be 201
    And response header Content-Type should be application/json
    And response body path $.name should be Tony
    And response body path $.username should be Stark
    And response body path $.email should be tony.stark@gmail.com

  Scenario: Get users
    When I GET /users
    And response body should be valid json
    Then response code should be 200
    And response body is typed as array for path $
    And response body path $.[0].email should be Sincere@april.biz

  Scenario: Add new data to jsonplaceholder
    When I set body to []
    And I POST /posts
    Then response header Content-Type should not be application/xml
    And response code should be 201
    And response header Content-Type should be application/json

  Scenario: Add invalid data to jsonplaceholder
    When I set body to []
    And I POST /postss
    Then response header Content-Type should not be application/xml
    And response code should be 404
    And response header Content-Type should be application/json

  Scenario: Get users with invalid data
    When I GET /user
    And response body should be valid json
    Then response code should be 404

  Scenario: Get users with valid data
    When I GET /users
    And response body should be valid json
    Then response code should be 200
    And response body is typed as array for path $
    Then response body should contain Leanne

  Scenario: Get users with valid email data
    When I GET /users
    And response body should be valid json
    Then response code should be 200
    And response body is typed as array for path $
    Then response body should contain @april.

  Scenario: Get users with valid email data
    When I GET /users
    And response body should be valid json
    Then response code should be 200
    And response body is typed as array for path $
    Then response body should contain @april.

  Scenario: Get users with valid company data
    When I GET /users
    And response body should be valid json
    Then response code should be 200
    And response body is typed as array for path $
    Then response body should contain Romaguera-Crona
    And response body path $.[0].company.name should be Romaguera-Crona

  Scenario: Get users with valid catchPhrase data
    When I GET /users
    And response body should be valid json
    Then response code should be 200
    And response body is typed as array for path $
    Then response body should contain Multi-layered client-server neural-net
    And response body path $.[0].company.catchPhrase should be Multi-layered client-server neural-net
