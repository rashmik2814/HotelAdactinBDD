Feature: Hotel Booking
  Scenario: Book a hotel successfully
    Given the user is on the login page
    When the user logs in with valid credentials
    And the user searches for a hotel with specific details
    And the user selects a hotel
    And the user enters booking details
    Then the user should see the booking confirmation
    And the user logs out successfully
