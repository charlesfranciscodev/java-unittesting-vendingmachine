package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AlphaNumericChooserTest {
  AlphaNumericChooser chooser;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    chooser = new AlphaNumericChooser(26, 10);
  } // setUp()

  @Test
  public void validInputReturnsProperLocation() throws Exception {
    AlphaNumericChooser.Location location = chooser.locationFromInput("B4");
    assertEquals(1, location.getRow());
    assertEquals(3, location.getColumn());
    //assertEquals("column", 4, location.getColumn());
  } // validInputReturnsProperLocation()

  @Test(expected = InvalidLocationException.class)
  public void choosingWrongInputIsNotAllowed() throws Exception {
    chooser.locationFromInput("WRONG");
  } // choosingWrongInputIsNotAllowed()

  @Test(expected = InvalidLocationException.class)
  public void choosingLargerThanMaxIsNotAllowed() throws Exception {
    chooser.locationFromInput("B52");
  } // choosingLargerThanMaxIsNotAllowed()

  @Test
  public void constructingLargerThenAlphabetNotAllowed() throws Exception {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Maximum rows supported is 26");
    new AlphaNumericChooser(27, 10);
  } // constructingLargerThenAlphabetNotAllowed()
} // AlphaNumericChooserTest