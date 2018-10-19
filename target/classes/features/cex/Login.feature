Feature: Login page module

  @Login
  Scenario Outline: Title of your scenario
    Given As a user I want to see the login page
    And I enter the <product> in the search box

    Examples: 
      | product    | 
      | TD:PRODUCT |  

      
   @FundSort
   Scenario: Test table sort and file download
   
    Given As a user I want to see the Toolkit page
    And I sort the Fund table
    #And I export the funds
    #When I download the funds
    #Then I see the funds downloaded in specified path