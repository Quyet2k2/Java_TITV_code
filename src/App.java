import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    TuDien hashSet = new TuDien(sc);
    hashSet.menu();
  }
}