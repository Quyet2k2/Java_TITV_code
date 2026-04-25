import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TuDien {
  // private Map<String, String> duLieu = new TreeMap<String, String>();
  private Map<String, String> duLieu = new HashMap<String, String>();
  private Scanner sc;

  public TuDien(Scanner sc) {
    this.sc = sc;
  }

  // 1. Thêm từ (Từ khoá, Ý nghĩa).
  private String themTu(String tuKhoa, String yNghia) {
    return this.duLieu.put(tuKhoa, yNghia);
  }

  // 2. Xoá từ.
  private String xoaTu(String tuKhoa) {
    return this.duLieu.remove(tuKhoa);
  }

  // 3. Tìm ý nghĩa của từ khoá => Tra từ.
  private String traTu(String tuKhoa) {
    String yNghia = this.duLieu.get(tuKhoa);
    return yNghia;
  }

  // 4. In ra danh sách từ khoá.
  private void inTuKhoa() {
    Set<String> tapHopTuKhoa = this.duLieu.keySet();
    System.out.println(Arrays.toString(tapHopTuKhoa.toArray()));
  }

  // 5. In ra số lượng từ.
  private int laySoluong() {
    return this.duLieu.size();
  }

  // 6. Xoá tất cả các từ khoá.
  private void xoaTatCa() {
    this.duLieu.clear();
    System.out.println("Đã xoá hết tất cả!");
  }

  public void menu() {
    int luaChon = 0;
    Utils.clearScreen();

    do {
      System.out.println("---------------------------------------------------");
      System.out.println("MENU:");
      System.out.println("1. Thêm từ (Từ khoá, Ý nghĩa).");
      System.out.println("2. Xoá từ.");
      System.out.println("3. Tìm ý nghĩa của từ khoá => Tra từ.");
      System.out.println("4. In ra danh sách từ khoá.");
      System.out.println("5. In ra số lượng từ.");
      System.out.println("6. Xoá tất cả các từ khoá.");
      System.out.println("0. Thoát khỏi chương trình.");
      System.out.println("---------------------------------------------------");

      System.out.print("*** Nhập lựa chọn: ");
      try {
        luaChon = Integer.parseInt(sc.nextLine());
      } catch (Exception e) {
        luaChon = -1;
        Utils.clearScreen();
        System.out.println("Lựa chọn không hợp lệ!");
        continue;
      }

      String tuKhoa = "";
      if (luaChon == 1 || luaChon == 2 || luaChon == 3) {
        Utils.clearScreen();
        System.out.print("Nhập vào từ khoá: ");
        tuKhoa = sc.nextLine();
      }

      switch (luaChon) {
        // 1. Thêm từ (Từ khoá, Ý nghĩa).
        case 1:
          System.out.print("Nhập vào ý nghĩa: ");
          this.themTu(tuKhoa, sc.nextLine());
          break;

        // 2. Xoá từ.
        case 2:
          this.xoaTu(tuKhoa);
          break;

        // 3. Tìm ý nghĩa của từ khoá => Tra từ.
        case 3:
          System.out.println("Ý nghĩa là: " + this.traTu(tuKhoa));
          break;

        // 4. In ra danh sách từ khoá.
        case 4:
          Utils.clearScreen();
          this.inTuKhoa();
          break;

        // 5. In ra số lượng từ.
        case 5:
          Utils.clearScreen();
          System.out.println("Số lượng từ là: " + this.laySoluong());
          break;

        // 6. Xoá tất cả các từ khoá.
        case 6:
          Utils.clearScreen();
          this.xoaTatCa();
          break;

        // 0. Xoá tất cả các từ khoá.
        case 0:
          Utils.clearScreen();
          System.out.println("Kết thúc chương trình, hẹn gặp lại!");
          break;

        default:
          Utils.clearScreen();
          System.out.println("Lựa chọn không tồn tại!");
          break;
      }

    } while (luaChon != 0);
  }
}