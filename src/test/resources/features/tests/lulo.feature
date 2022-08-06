Feature: Lulo Test

  Scenario Outline: Get list employes
    When I consult the list of employees
    Then list result contains employee data:
      | <Name> | <Salary> |
    Examples:
      | Name        | Salary |
      | Tiger Nixon | 320800 |

  Scenario Outline: Create Employe
    When I create an employee
      | <Name> | <Salary> | <Age> |
    Then I verify the data and the message
      | <Status> | <Message> |
    Examples:
      | Name    | Salary  | Age | Status  | Message                              |
      | Gabriel | 8000000 | 30  | success | Successfully! Record has been added. |

  Scenario Outline: Get data employe
    When I query employee data by id <ID>
    Then I verify the employe data
      | <ID> | <Name> | <Salary> | <Age> |
    Examples:
      | ID | Name        | Salary | Age |
      | 1  | Tiger Nixon | 320800 | 61  |

  Scenario Outline: Delete employe data
    When I delete employe data by <ID>
    Then I see the message "Successfully! Record has been deleted"
    Examples:
      | ID |
      | 2  |