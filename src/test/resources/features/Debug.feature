Feature: MWP_Monitoring

  @QAREGR-T1
  Scenario: Positive Debug scenario 1
    Given I go to homepage
    And I click on LIVE
    Then I verify current URL contains "/live"

  @QAREGR-T2
  Scenario: Positive Debug scenario 2
    Given I go to homepage
    And I click on Pricing
    Then I verify current URL contains "/pricing"

  @QAREGR-T3
  Scenario: Negative Debug scenario 1
    Given I go to homepage
    And I click on LIVE
    Then I verify current URL contains "/sdfsfxv"

  @QAREGR-T4
  Scenario: Negative Debug scenario 2
    Given I go to homepage
    And I click on Pricing
    Then I verify current URL contains "/sdf3/sdfsfsd"