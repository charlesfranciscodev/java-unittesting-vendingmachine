package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphaNumericChooserTest {
  AlphaNumericChooser chooser;

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
} // AlphaNumericChooserTest