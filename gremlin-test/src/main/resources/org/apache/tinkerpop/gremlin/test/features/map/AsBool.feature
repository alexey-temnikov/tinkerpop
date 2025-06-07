@StepClassMap @StepAsBool
Feature: Step - asBool()

  @GraphComputerVerificationInjectionNotSupported
  Scenario: g_injectX1X_asBool
    Given the empty graph
    And the traversal of
      """
      g.inject(1).asBool()
      """
    When iterated to list
    Then the result should be unordered
      | result |
      | true |

  @GraphComputerVerificationInjectionNotSupported
  Scenario: g_injectX0X_asBool
    Given the empty graph
    And the traversal of
      """
      g.inject(0).asBool()
      """
    When iterated to list
    Then the result should be unordered
      | result |
      | false |

  @GraphComputerVerificationInjectionNotSupported
  Scenario: g_injectXstr_trueX_asBool
    Given the empty graph
    And the traversal of
      """
      g.inject('true').asBool()
      """
    When iterated to list
    Then the result should be unordered
      | result |
      | true |

  @GraphComputerVerificationInjectionNotSupported
  Scenario: g_injectXinvalidstrX_asBool
    Given the empty graph
    And the traversal of
      """
      g.inject('hello').asBool()
      """
    When iterated to list
    Then the traversal will raise an error with message containing text of "Can't parse"
