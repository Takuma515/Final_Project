package liquorshop;

import java.util.Map;
import java.util.TreeMap;

public class Reservation{
  private int resvNum;
  private Map<String, Integer> itemsNum = new TreeMap<String, Integer>();  //予約商品リスト
  private int totalPrice = 0;

  public Reservation(int reservationNum) {
    this.resvNum = reservationNum;
  }

  /* 注文商品の個数をセット */
  public void setItemNum(String query, int itemNum) {
    if(itemNum<0) {
      System.out.println("エラー: 負の値は設定できません");
      return;
    }

    if(itemsNum.containsKey(query)) {
      itemsNum.remove(query);
      itemsNum.put(query, itemNum);
    }else {
      // キーが存在しない場合(こちらが主に実行される)
      itemsNum.put(query, itemNum);
    }
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

   /* 出荷可能かどうか判定 */
  public boolean canShip(LiquorShop ls) {
    for(String key : itemsNum.keySet()) {
      int ItemNum = itemsNum.get(key);
      int stockNum = ls.getStockNum(key);
      if(stockNum<ItemNum) return false;
    }
    return true;
  }

  /* 出荷処理 */
  public void ship(LiquorShop ls) {
    System.out.println("出荷処理を行います");
    for(String key : itemsNum.keySet()) {
      int ItemNum = itemsNum.get(key);
      ls.reduceStock(key, ItemNum);
    }
    System.out.println("出荷処理が完了しました");
  }

  /* 予約内容の表示 */
  public void print() {
    System.out.println("------------------------");
    System.out.println("注文番号: " + resvNum);
    System.out.println("注文商品:");

    for(String key : itemsNum.keySet()) {
      int itemNum = itemsNum.get(key);
      System.out.println(key + " : " + itemNum);
    }
    System.out.println("合計金額: " + totalPrice);
    System.out.println("------------------------");
  }
}
