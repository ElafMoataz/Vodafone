Feature: Add products to cart functionality
  In order to do shopping
  As a Vodafone customer

  Background:
    Given Navigated successfully to URL

  Scenario: validate that products are added to cart successfully
    When User adds first product to the basket
    When User adds second product to the basket
    When User adds first search product to the basket
    Then All products should be added to basket successfully
