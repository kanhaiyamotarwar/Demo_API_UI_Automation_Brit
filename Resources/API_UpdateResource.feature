Feature: Verify update device API

  @API_Sanity
  Scenario: Update newly created device details and verify details are updated correctly
    Given Create Device with product name as "iPhone 15" and with below data
      | Attribute      | Value         |
      | Year           |          2024 |
      | price          |       1849.99 |
      | CPU model      | Intel Core i7 |
      | Hard disk size | 1 TB          |
    Then Verify response code is 200
    Then Extract product id from response
    And Get newly device with "valid" id
    Then Verify response code is 200
    Then Verify response property "[0].name" is "iPhone 15"
    Then Verify response property "[0].data.Year" is "2024"
    Then Verify response property "[0].data.price" is "1849.99"
    Then Verify response property "[0].data['CPU model']" is "Intel Core i7"
    Then Verify response property "[0].data['Hard disk size']" is "1 TB"
    When update Device with product id as "valid" and with below data
      | Attribute      | Value         |
      | Year           |          2025 |
      | price          |       1849.99 |
      | CPU model      | Intel Core i9 |
      | Hard disk size | 2 TB          |
    And Get newly device with "valid" id
    Then Verify response code is 200
    And Get newly device with "valid" id
    Then Verify response property "[0].name" is "iPhone 15"
    Then Verify response property "[0].data.Year" is "2025"
    Then Verify response property "[0].data.price" is "1849.99"
    Then Verify response property "[0].data['CPU model']" is "Intel Core i9"
    Then Verify response property "[0].data['Hard disk size']" is "2 TB"

  @API_Sanity
  Scenario: Verify validation message when trung to update device with incorrect id
    Given Create Device with product name as "iPhone 15" and with below data
      | Attribute      | Value         |
      | Year           |          2024 |
      | price          |       1849.99 |
      | CPU model      | Intel Core i7 |
      | Hard disk size | 1 TB          |
    Then Verify response code is 200
    Then Extract product id from response
    And Get newly device with "valid" id
    Then Verify response code is 200
    Then Verify response property "[0].name" is "iPhone 15"
    Then Verify response property "[0].data.Year" is "2024"
    Then Verify response property "[0].data.price" is "1849.99"
    Then Verify response property "[0].data['CPU model']" is "Intel Core i7"
    Then Verify response property "[0].data['Hard disk size']" is "1 TB"
    When update Device with product id as "invalid" and with below data
      | Attribute      | Value         |
      | Year           |          2025 |
      | price          |       1849.99 |
      | CPU model      | Intel Core i9 |
      | Hard disk size | 2 TB          |
    Then Verify response code is 404
    Then Verify response property "error" is "The Object with id = invalid doesn't exist. Please provide an object id which exists or generate a new Object using POST request and capture the id of it to use it as part of PATCH request after that."
    
