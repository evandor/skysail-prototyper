@applications
Feature: DesignerApplication] - application specific features 

    Todo: An account is an entity with a non-empty name, an iban and a non-empty creation date.
    
    These tests assume that the user is authenticated and has the appropriate roles; initially,
    the database is empty (but there is no guarantee of the execution order of the tests).
    
    The media type used here is not relevant as nothing gets actually rendered in these tests.

Background: 
    Given a running DesignerApplication

Scenario: adding a simple application entity
    When I add an application like this:
      | name | application_<random> |
    And I query all applications
    Then the applications list page contains such an application:
       | name      | application_<random> |

