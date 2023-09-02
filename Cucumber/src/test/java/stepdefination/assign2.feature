Feature: Order with different quantities

  Scenario Outline: Adding HP Pen Drives to Cart
    Given User searches for HP Pen Drive
    When Add the first result on the page with quantity <qty>
    Then Cart should display <qty> pen drive

    Examples:
      | qty |
      | 1   |
      | 2   |
      | 3   |