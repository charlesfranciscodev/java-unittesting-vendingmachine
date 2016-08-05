package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinTest {
  private Bin bin;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    bin = new Bin(10);
  } // setUp()

  @Test
  public void restockingWithDifferentItemsIsNotAllowed() throws Exception {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Cannot restock Cheetos with Doritos");
    bin.restock("Cheetos", 1, 100, 50);
    bin.restock("Doritos", 1, 100, 50);
  } // restockingWithDifferentItemsIsNotAllowed()

  @Test
  public void whenEmptyPriceIsZero() throws Exception {
    assertEquals(0, bin.getItemPrice());
  } // whenEmptyPriceIsZero()

  @Test
  public void whenEmptyNameIsNull() throws Exception {
    assertNull(bin.getItemName());
  } // whenEmptyNameIsNull()

  @Test
  public void overstockingNotAllowed() throws Exception {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("There are only 10 spots left");
    bin.restock("Fritos", 2600, 100, 50);
  } // overstockingNotAllowed()
} // BinTest