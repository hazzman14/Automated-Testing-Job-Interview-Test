Feature: Checking car registration information

  Scenario Outline: user checks if their valid car registration number is registered on cartaxcheck.co.uk
    Given user opens chrome and goes to cartextcheck.co.uk
    When user enters their car registration number <number>
    Then the info for car <number> appears

    Examples:
    |number|
    |0     |
    |1     |
    |2     |
    |3     |

  Scenario Outline: user checks if their invalid car registration number is registered on cartaxcheck.co.uk
    Given user opens chrome and goes to cartextcheck.co.uk
    When user enters their car registration number <number>
    Then the info for car <number> does not appear

    Examples:
      |number|
      |0     |
      |1     |
      |2     |
      |3     |