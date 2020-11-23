package liquorshop;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReservationTest{
  /* インスタンス化して使用するテスト */
  @Test public void instantiate(){
    Reservation r = new Reservation(10);
    int itemNum = 5;
    r.setItemNum("Wine", itemNum);
    r.setItemNum("Sake", itemNum+1);
    r.print();
    r.setItemNum("Wine", -1);
  }

  @Test public void canShipTest() {
    LiquorShop ls = LiquorShop.getInstance();
    Reservation r = new Reservation(10);
    int itemNum = 5;
    r.setItemNum("Wine", itemNum);
    assertEquals(false,r.canShip(ls));
    ls.addStock("Wine", itemNum);
    assertEquals(true,r.canShip(ls));
  }
}
