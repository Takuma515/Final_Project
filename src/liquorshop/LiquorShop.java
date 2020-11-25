package liquorshop;

import java.util.Map;
import java.util.TreeMap;

class LiquorShop{
  private Map<String, Alcohol> stockList = new TreeMap<String, Alcohol>();  //在庫リスト
  private static LiquorShop theInstance;  //唯一のインスタンス保存用変数

  private LiquorShop() {
    /* 各商品インスタンスの生成と格納 */
    stockList.put("Sake", new Sake("Sake",500));
    stockList.put("Wine", new Wine("Wine",1000));
  }

  /* 必ず同一のインスタンスを返す */
  public static LiquorShop getInstance() {
    if(theInstance==null) {
      theInstance = new LiquorShop();
    }
    return theInstance;
  }

  /* 在庫リストを返す*/
  public Map getStockList() {
    return stockList;
  }

  /* 在庫の検索 */
  public void searchItem(String query) {
    System.out.println("商品名 : 値段 , 在庫数");
    if(query.equals("All")) {
      for(String key : stockList.keySet()) {
        Alcohol value = stockList.get(key);
        System.out.println(value.getName() + " : " + value.getPrice() + "円 , " + value.getStockNum());
      }
    }else {
      Alcohol value = stockList.get(query);
      if(value == null) {
        System.out.println("商品が存在しません");
        return;
      }
      System.out.println(value.getName() + " : " + value.getPrice() + "円 , " + value.getStockNum());
    }
  }

  /* 在庫の追加 */
  public void addStock(String query, int add_num) {
    Alcohol value = stockList.get(query);
    value.setStockNum(value.getStockNum() + add_num);
  }

  /* 在庫の削除 */
  public void reduceStock(String query, int sub_num) {
    Alcohol value = stockList.get(query);
    value.setStockNum(value.getStockNum() - sub_num);
  }

  /* 指定商品の在庫数を返す */
  public int getStockNum(String query) {
    return stockList.get(query).getStockNum();
  }

}
