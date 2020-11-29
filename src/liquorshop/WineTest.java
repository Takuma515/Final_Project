package liquorshop;

import static org.junit.Assert.*;

import org.junit.Test;

public class WineTest{

  /* インスタンス化して使用するテスト */
  @Test public void instantiate(){
    Alcohol al = new Wine("Wine",1000);
    assertEquals("Wine",al.getName());
    assertEquals(1000,al.getPrice());
    assertEquals(0,al.getStockNum());
  }

  /* setStockNum()のテスト */
  @Test public void StockNumTest() {
    Alcohol al = new Wine("Wine",1000);
    al.setStockNum(-1);                    // Error
    assertEquals(0,al.getStockNum());
  }
}
