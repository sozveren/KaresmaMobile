@US025
Feature:  As a visitor, I should be able to add the product I want to the cart from
  the relevant page by making a selection from any sub-menu of the Ev & Yaşam menu.

  Background:
    * The user goes to the relevant App.

  Scenario: It is verified that a desired product can be added
  to the cart from any sub-menu of the Ev & Yaşam menu.

    * Verifying "Aydınlatma" subMenu  elements  "EV & YAŞAM" subMenu  in the footer section "Kategoriler".
    * Click 2 .  product on the list
    * Click "SEPETE EKLE" button
    * Verify that the product in the cart is the correct product
    * The user closes the application.
