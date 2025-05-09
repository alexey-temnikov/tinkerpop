# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

@HelperUuid @ConstructorUuid
Feature: Helper - uuid()

  @GraphComputerVerificationInjectionNotSupported
  Scenario: g_injectXUUIDX47af10b_58cc_4372_a567_0f02b2f3d479XX
    Given the empty graph
    And the traversal of
      """
      g.inject(UUID("f47af10b-58cc-4372-a567-0f02b2f3d479"))
      """
    When iterated to list
    Then the result should be unordered
      | result |
      | uuid[f47af10b-58cc-4372-a567-0f02b2f3d479] |

  @GraphComputerVerificationInjectionNotSupported
  Scenario: g_injectXUUIDXXX
    Given the empty graph
    And the traversal of
      """
      g.inject(UUID())
      """
    When iterated to list
    Then the result should have a count of 1
