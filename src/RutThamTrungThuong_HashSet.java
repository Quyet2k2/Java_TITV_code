import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RutThamTrungThuong_HashSet {
  private Set<String> thungPhieuDuThuong = new HashSet<String>();
  // private Set<String> thungPhieuDuThuong = new TreeSet<String>();
  private Scanner sc;

  public RutThamTrungThuong_HashSet(Scanner sc) {
    this.sc = sc;
  }

  // 1. Thêm mã số dự thưởng.
  private boolean themPhieu(String giaTri) {
    return this.thungPhieuDuThuong.add(giaTri);
  }

  // 2. Xoá mã số dự thưởng
  private boolean xoaPhieu(String giaTri) {
    return this.thungPhieuDuThuong.remove(giaTri);
  }

  // 3. Kiểm tra mã số dự thưởng có tồn tại hay không?
  private boolean kiemTraPhieuTonTai(String giaTri) {
    return this.thungPhieuDuThuong.contains(giaTri);
  }

  // 4. Xoá tất cả các phiếu dự thưởng.
  private void xoaTatCaPhieuDuThuong() {
    this.thungPhieuDuThuong.clear();
    System.out.println("Đã xoá hết tất cả phiếu!");
  }

  // 5. Số lượng phiếu dự thưởng.
  private int laySoLuong() {
    return this.thungPhieuDuThuong.size();
  }

  // 6. Rút thăm trúng thưởng.
  private String rutMotPhieu() {
    Random rd = new Random();

    int viTri = rd.nextInt(this.thungPhieuDuThuong.size());
    return (String) this.thungPhieuDuThuong.toArray()[viTri];
  }

  // 7. In ra tất cả các phiếu.
  private void inTatCa() {
    System.out.println(Arrays.toString(this.thungPhieuDuThuong.toArray()));
  }

  public void menu() {
    int luaChon = 0;
    Utils.clearScreen();

    do {
      System.out.println("---------------------------------------------------");
      System.out.println("MENU:");
      System.out.println("1. Thêm mã số dự thưởng.");
      System.out.println("2. Xoá mã số dự thưởng.");
      System.out.println("3. Kiểm tra mã số dự thưởng có tồn tại hay không?");
      System.out.println("4. Xoá tất cả các phiếu dự thưởng.");
      System.out.println("5. Số lượng phiếu dự thưởng.");
      System.out.println("6. Rút thăm trúng thưởng.");
      System.out.println("7. In ra tất cả các phiếu.");
      System.out.println("0. Thoát khỏi chương trình.");
      System.out.println("---------------------------------------------------");

      String giaTri = "";
      System.out.print("*** Nhập lựa chọn: ");
      try {
        luaChon = Integer.parseInt(sc.nextLine());
      } catch (Exception e) {
        System.out.println("Lựa chọn không hợp lệ!");
        luaChon = -1;
        continue;
      }

      if (luaChon == 1 || luaChon == 2 || luaChon == 3) {
        System.out.println("Nhập vào mã phiếu dự thưởng: ");
        giaTri = sc.nextLine();
      }

      switch (luaChon) {
        case 1:
          Utils.clearScreen();
          this.themPhieu(giaTri);
          break;

        case 2:
          Utils.clearScreen();
          this.xoaPhieu(giaTri);
          break;

        case 3:
          Utils.clearScreen();
          System.out.println("Kết quả kiểm tra tồn tại: " + this.kiemTraPhieuTonTai(giaTri));
          break;

        case 4:
          Utils.clearScreen();
          this.xoaTatCaPhieuDuThuong();
          break;

        case 5:
          Utils.clearScreen();
          System.out.println("Số lượng phiếu là: " + this.laySoLuong());
          break;

        case 6:
          Utils.clearScreen();
          System.out.println("Mã số trúng thưởng là: " + this.rutMotPhieu());
          break;

        case 7:
          Utils.clearScreen();
          this.inTatCa();
          break;

        default:
          Utils.clearScreen();
          System.out.println("Lựa chọn không tồn tại!");
          break;
      }

    } while (luaChon != 0);
  }
}