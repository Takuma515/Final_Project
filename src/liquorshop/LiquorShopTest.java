package liquorshop;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiquorShopTest{

  @Test public void stockmethodTest() {
    /* add/reduceStock()のテスト */
    int add_num = 10, sub_num = 6;
    String query = "Wine";
    LiquorShop ls = LiquorShop.getInstance();
    assertEquals(0,ls.getStockNum(query));
    ls.addStock(query, add_num);               // 0+10=10
    assertEquals(10,ls.getStockNum(query));
    ls.reduceStock(query, sub_num);            // 10-6=4
    assertEquals(4,ls.getStockNum(query));
    ls.reduceStock(query, sub_num);            // 実行されない
    assertEquals(4,ls.getStockNum(query));
  }

}
