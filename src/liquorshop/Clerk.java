package liquorshop;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Clerk{
  private LiquorShop ls;
  private static Map<Integer, Reservation> resvList = new TreeMap<Integer, Reservation>(); //予約リスト
  private Map<String, Alcohol> stockList;
  private static int resvNum=1;  //予約番号

  public Clerk() {
    ls = LiquorShop.getInstance();
    stockList = ls.getStockList();
  }

  /* 仕入れ */
  public void purchase() {
    ls.addStock("Sake", 10);
    ls.addStock("Wine", 5);
  }

  /* 予約リストの処理*/
  public void processResvList() {
    System.out.println("予約リストの処理を開始します");
    for(int key : resvList.keySet()){
      Reservation resv = resvList.get(key);
      if(resv.canShip(ls)) {
        System.out.println("以下の予約を処理します");
        resv.print();
        resv.ship(ls);  // 出荷処理はReservationに任せる
        System.out.println("出荷しました");
      }
    }
    System.out.println("予約リストの処理が完了しました");
  }

  /* 注文処理 */
  public void processOrder(Scanner scan) {
    int totalPrice = 0;
    Reservation resv = new Reservation(resvNum);

    /* 注文内容の入力 */
    System.out.println("注文する商品の個数を入力してください");
    for(String key : stockList.keySet()) {
      System.out.println(key + ": ");
      int itemNum = scan.nextInt();
      resv.setItemNum(key, itemNum);
      totalPrice += stockList.get(key).getPrice() * itemNum;
    }
    resv.setTotalPrice(totalPrice);  // 合計金額を設定
    System.out.println("注文内容を確認します");
    resv.print();
    System.out.println("以上でよろしいでしょうか？");
    System.out.println("1.はい, 2.いいえ");
    int input_num = scan.nextInt();
    switch(input_num) {
    case 1:
      if(resv.canShip(ls)) {
        //出荷する
        resv.ship(ls);
      }else {
        //予約として処理
        System.out.println("在庫がなかったため、予約として処理します");
        System.out.println("予約番号: " + resvNum);
        resvList.put(resvNum, resv); //予約リストに追加
        resvNum++;
      }
      break;
    case 2:
      System.out.println("注文をキャンセルしました");
      break;
    default:
      System.out.println("エラー: 想定外の入力です");
      break;
    }
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
    if(resvList.size()==0) {
      System.out.println("予約が存在しません");
      return;
    }

    System.out.println("予約番号を入力してください");
    int resv_num = scan.nextInt();
    Reservation resv = resvList.get(resv_num);

    if(resv == null) {
      System.out.println("予約が存在しません");
      return;
    }

    System.out.println("以下の予約をキャンセルします");
    resv.print();
    System.out.println("1.はい, 2.いいえ");
    int input_num = scan.nextInt();
    switch (input_num) {
    case 1:
      resvList.remove(resv_num);
      System.out.println("キャンセルしました");
      break;
    case 2:
      System.out.println("キャンセルを中止しました");
      break;
    default:
      System.out.println("エラー: 想定外の入力です");
      break;
    }
  }
}
