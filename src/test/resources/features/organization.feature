Feature: Manage crud operations for organization and sub organization

@SmokeTest
  Scenario: verify add organization and save
    Given user is on Home page of application and login
    When click on organization button fill details and save
        | Action |
        | Add    |
    Then verify saved organization on grid 
    
@SmokeTest
  Scenario: search organization or sub organization and verify result on grid
    Given user is on Home page of application and login
    Then input org name in search input field and verify searched result
   
@SmokeTest
  Scenario: verify edit organization and save
    Given user is on Home page of application and login
    When click on three dot icon and update details
        | Action |
        | Edit   |
    Then update organization and verify
       
@SmokeTest
  Scenario: verify add sub organization and save
    Given user is on Home page of application and login
    When click on sub organization button and fill details and save
        | Action |
        | AddSub |
    Then verify added sub organization
   
@SmokeTest
  Scenario: verify edit sub organization and save
    Given user is on Home page of application and login
    When click on three dot icon and change sub org details
        | Action  |
        | EditSub |
    Then verify updated sub organization

@SmokeTest
  Scenario: verify pagination on members added via bulk upload
    Given user is on Home page of application and login
    When navigate to member tab add members in bulk
        | Action           |
        | VerifyPagination |
    Then verify pagination by navigating to next page
    
@SmokeTest
  Scenario: verify delete multi members added via bulk upload
    Given user is on Home page of application and login
    When navigate to member tab select all member and delete
        | Action              |
        | DeleteMultiBulkData |
    Then verify all deleted member in organization
    
@SmokeTest
  Scenario: verify add member and save
    Given user is on Home page of application and login
    When click on add member button fill details and save
        | Action |
        | Add    |
    Then verify added member in organization
    
@SmokeTest1
  Scenario: verify generate report
    Given user is on Home page of application and login
    When navigate to member page and generate report
        | Action    |  
        | GenReport |
    Then verify generated report for member

@SmokeTest
  Scenario: verify edit member and save
    Given user is on Home page of application and login
    When click on three dot icon and change member details
        | Action |
        | Edit   |
    Then verify updated member in organization
        
@SmokeTest
  Scenario: verify add staff and save
    Given user is on Home page of application and login
    When click on add staff button fill details and save
        | Action |
        | Add    |
    Then verify added staff in organization

@SmokeTest
  Scenario: verify edit staff and save
    Given user is on Home page of application and login
    When click on three dot icon and change staff details
        | Action |
        | Edit   |
    Then verify updated staff in organization
  
@SmokeTest
  Scenario: verify add member via bulk upload
    Given user is on Home page of application and login
    When add member via bulk upload
        | Action  |
        | AddBulk |
    Then verify added member via bulk in organization  
     
@SmokeTest
  Scenario: delete single member added via bulk upload and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete member added via bulk
        | Action               |
        | DeleteSinglebulkData |
    Then verify deleted member added via bulk
    
@SmokeTest
  Scenario: verify upload history success file
    Given user is on Home page of application and login
    When navigate to upload history tab in a organization
    Then verify upload history
    
@SmokeTest
  Scenario: verify delete member added manually
    Given user is on Home page of application and login
    When click on three dot icon and delete member
        | Action |
        | Delete |
    Then verify deleted member
 
@SmokeTest
  Scenario: delete staff and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete staff
        | Action |
        | Delete |
    Then verify deleted staff
     
@SmokeTest
  Scenario: delete sub organization and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete sub org
        | Action    |
        | DeleteSub |
    Then verify deleted sub organization
    
@SmokeTest
  Scenario: delete organization and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete org
        | Action |
        | Delete |
    Then verify deleted organization