package liquorshop;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Clerk{
  private LiquorShop ls;
  private static Map<Integer, Reservation> resvList = new TreeMap<Integer, Reservation>(); //予約リスト
  private String[] inventory = new String[] {"Sake", "Wine"}; //商品一覧

  public Clerk() {
    ls = LiquorShop.getInstance();
  }

  /* 仕入れ */
  public void purchase() {
    ls.addStock(inventory[0], 10);
    ls.addStock(inventory[1], 10);
  }

  /* 予約リストの処理*/
  public void processResvList() {
    System.out.println("予約リストの処理を開始します");
    for(int key : resvList.keySet()){
      Reservation resv = resvList.get(key);
    }
  }

  /* 注文処理 */
  public void processOrder(Scanner scan) {
    System.out.println("");
  }

  /* 商品検索処理 */
  public void searchItem(Scanner scan) {
    System.out.println("検索したい商品名を入力してください");
    System.out.println("「All」と入力すると一覧が表示されます");
    String query = scan.next();
    ls.searchItem(query);
  }

  /* 予約のキャンセル処理 */
  public void calcelResv(Scanner scan) {

  }
}
