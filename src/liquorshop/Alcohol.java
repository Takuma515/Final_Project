package liquorshop;

abstract class Alcohol {
  private String name;
  private int price;
  private int stockNum = 0;

  public Alcohol(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {return name;}
  public int getPrice() {return price;}
  public int getStockNum() {return stockNum;}
  public void setStockNum(int num) {
    if(num<0) {
      System.out.println("エラー: 在庫が足りません");
      return;
    }
    stockNum = num;
  }



}
