package liquorshop;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiquorShopTest{
  /* LiquorShopがSingletonとなっているかのテスト*/
  @Test public void singletonTest() {
    LiquorShop ls1 = LiquorShop.getInstance();
    LiquorShop ls2 = LiquorShop.getInstance();
    assertEquals(true,ls1.equals(ls2));
  }

  /* add/reduceStock()のテスト */
  @Test public void stockMethodTest() {
    int add_num = 10, reduce_num = 6;
    String query = "Wine";
    LiquorShop ls = LiquorShop.getInstance();
    assertEquals(0,ls.getStockNum(query));
    ls.addStock(query, add_num);               // 0+10=10
    assertEquals(10,ls.getStockNum(query));
    ls.reduceStock(query, reduce_num);            // 10-6=4
    assertEquals(4,ls.getStockNum(query));
    ls.reduceStock(query, reduce_num);            // 4-6=-2 :Error
    assertEquals(4,ls.getStockNum(query));
    ls.searchItem("All");
    ls.searchItem(query);
  }
}
