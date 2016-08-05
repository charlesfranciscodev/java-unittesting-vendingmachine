package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {
  private VendingMachine machine;

  public class NotifiierStub implements Notifier {
    @Override
    public void onSale(Item item) {
      return;
    } // onSale()
  } // NotifierStub

  @Before
  public void setUp() throws Exception {
    Notifier notifier = new NotifiierStub();
    machine = new VendingMachine(notifier, 10, 10, 10);
    machine.restock("A1", "Twinkies", 10, 30, 75);
  } // setUp()

  @Test
  public void vendingWhenStockedReturnsItem() throws Exception {
    machine.addMoney(75);
    Item item = machine.vend("A1");
    assertEquals("Twinkies", item.getName());
  } // vendingWhenStockedReturnsItem()

  @Test
  public void runningSalesTotalIsIncrementedWhenVendOperationIsSuccessful() throws Exception {
    machine.addMoney(75);
    Item item = machine.vend("A1");
    assertEquals(75, machine.getRunningSalesTotal());
  } // runningSalesTotalIsIncrementedWhenVendOperationIsSuccessful()
} // VendingMachineTest