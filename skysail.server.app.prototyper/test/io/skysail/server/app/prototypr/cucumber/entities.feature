@entities
Feature: [DesignerApplication] - entity specific features 

    Todo: Entities...
    
    These tests assume that the user (called "admin") is authenticated and has the appropriate roles; 
    initially, the database is empty (but there is no guarantee of the execution order of the tests).
    
    The media type used here is not relevant as nothing gets actually rendered in these tests.

Background: 
    Given a running DesignerApplication
	Given I add an application like this:
      | name | testapp |

Scenario: adding a simple entity to the application
    When I add an entity like this:
      | name | entity_<random> |
    And I query all applications
    Then the applications list page contains such an application:
       | name      | entity_<random> |
 
