package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditorTest {
  private Creditor creditor;

  @Before
  public void setUp() throws Exception {
    // Arrange
    creditor = new Creditor();
  } // setUp()

  @Test
  public void addingFundsIncrementsAvailableFunds() throws Exception {
    // Act
    creditor.addFunds(25);
    creditor.addFunds(25);
    // Assert
    assertEquals(50, creditor.getAvailableFunds());
  } // addingFundsIncrementsAvailableFunds()

  @Test
  public void refundingReturnsAllAvailableFunds() throws Exception {
    // Act
    creditor.addFunds(10);
    // Act
    int refund = creditor.refund();
    // Assert
    assertEquals(10, refund);
  } // refundingReturnsAllAvailableFunds()

  @Test
  public void refundingResetsAvailableFundsToZero() throws Exception {
    // Act
    creditor.addFunds(10);
    // Act
    creditor.refund();
    // Assert
    assertEquals(0, creditor.getAvailableFunds());
  } // refundingResetsAvailableFundsToZero()
} // CreditorTest