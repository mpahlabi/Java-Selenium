Feature: Login
  As a user of MCT i want to login



	Background: Landing On MCT Home Page
  	Given I am on mct-website home page




  Scenario: User Can Login with valid Credentails
    * I complete login with valid credentails
    * I see my profile as "james williams"

  Scenario: User Can Sign Up
    * I go to reg page
    * I complete registration with Fname "MR" and Lname as "James001"
    * I see my profile as "Mr James001"





  Scenario Outline: Signup with multiple users data
    And I go to reg page
    When I complete registration with Fname <Fname> and Lname as <Lname>
    Then I see my profile as <ExpResult>

    Examples: 
      | Fname | Lname      | ExpResult     |
      | "MR"  | "James001" | "MR James001" |
      | "MR"  | "James002" | "MR James002" |
#
  #Scenario: valid registration
    #And I go to reg page
    #When I complete registration with below data
      #| mrjames007@gmail.com |
      #| MRJames007           |
      #| MR                   |
      #| James 007            |
