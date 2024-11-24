Feature: Manage settings scenario for organization and sub organization

@SmokeTest
  Scenario: verify save setting for time window and workflow call
    Given user is on Home page of application and login
    And navigate to settings page
    When fill details for time window workflow call and save
        | Action |
        | Save   |
    Then verify saved ovation settings 
    