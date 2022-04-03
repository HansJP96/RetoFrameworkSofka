# new feature
# Tags: optional

@FeatureName:contactUsForVisitors
Feature: Contact Us for visitors
  As a visitor to the Your Logo website
  I want to be able to send a message to the store
  To resolve any concerns or needs i have


  Background: Visitor on the Home page
    Given the visitor is already on the Home page
    And visitor goes to Contact Us page

  @ScenarioName:SuccessfulSentMessage
  Scenario: Successful sent message
    When fill the required fields and send the information
    Then a successful action message appears

  @ScenarioName:ErrorByNotSelectedSubjectHeading
  Scenario: Error by not selected subject heading
    When fill the required fields except the subject heading and send the information
    Then an error message appears related to subject heading