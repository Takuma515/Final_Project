import java.util.Scanner;

import liquorshop.Clerk;

public class Main{
  public static void main(String[] args){
    Clerk clerk = new Clerk();
    int cnt = 0;   //日数を数える
    boolean isOperation = true;
    int select_num = 0;
    Scanner scan = new Scanner(System.in);
    while(cnt<1) {
      /* 在庫の追加と予約の処理*/
      clerk.purchase();
      clerk.processResvList();
      if(!isOperation) isOperation = true;

      /* 注文などの操作 */
      while(isOperation) {
        System.out.println("要件を選択してください");
        System.out.println("1.注文, 2.検索, 3.予約のキャンセル");
        select_num = scan.nextInt();
        switch (select_num) {
          case 1:
            clerk.processOrder(scan);
            break;
          case 2:
            clerk.searchItem(scan);
            break;
          case 3:
            clerk.calcelResv(scan);
            break;
          default:
            System.out.println("エラー: 想定外の入力です");
            break;
        }
        System.out.println("操作を続けますか？");
        System.out.println("1.はい, 2.いいえ");
        select_num = scan.nextInt();
        switch (select_num) {
        case 1:
          // 何もしない
          break;
        case 2:
          isOperation = false;
          break;
        default:
          System.out.println("エラー: 想定外の入力です");
          break;
        }
      }
      cnt++;
    }
  }

}
