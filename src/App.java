import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    RutThamTrungThuong_HashSet hashSet = new RutThamTrungThuong_HashSet(sc);
    hashSet.menu();
  }
}