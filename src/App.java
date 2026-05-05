import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int luaChon = 0;

    System.out.print("Nhập tên file: ");
    ViduFile f = new ViduFile(sc.nextLine());

    Utils.clearScreen();
    do {
      System.out.println("MENU ---------");
      System.out.println("1. Kiểm tra file có thể thực thi: ");
      System.out.println("2. Kiểm tra file có thể đọc: ");
      System.out.println("3. Kiểm tra file có thể ghi: ");
      System.out.println("4. In đường dẫn: ");
      System.out.println("5. In tên file: ");
      System.out.println("6. Kiểm tra file là thư mục hoặc tệp tin: ");
      System.out.println("7. In ra danh sách các file con: ");
      System.out.println("8. In ra cây thư mục: ");
      System.out.println("0. Thoát chương trình.");
      System.out.println("===================");

      luaChon = Integer.parseInt(sc.nextLine());

      switch (luaChon) {
        // 1. Kiểm tra file có thể thực thi
        case 1:
          Utils.clearScreen();
          System.out.println(f.kiemTraThuThi());
          System.out.println("===================");
          break;

        // 2. Kiểm tra file có thể đọc
        case 2:
          Utils.clearScreen();
          System.out.println(f.kiemTraDoc());
          System.out.println("===================");
          break;

        // 3. Kiểm tra file có thể ghi
        case 3:
          Utils.clearScreen();
          System.out.println(f.kiemTraGhi());
          System.out.println("===================");
          break;

        // 4. In đường dẫn
        case 4:
          Utils.clearScreen();
          f.inDuongDan();
          System.out.println("===================");
          break;

        // 5. In tên file
        case 5:
          Utils.clearScreen();
          f.inTen();
          System.out.println("===================");
          break;

        // 6. Kiểm tra file là thư mục hoặc tệp tin
        case 6:
          Utils.clearScreen();
          f.kiemTraLaThuMucHoacTapTin();
          System.out.println("===================");
          break;

        // 7. In ra danh sách các file con
        case 7:
          Utils.clearScreen();
          f.inDanhSachCacFileCon();
          System.out.println("===================");
          break;

        // 8. In ra cây thư mục
        case 8:
          Utils.clearScreen();
          f.inCayThuMuc();
          System.out.println("===================");
          break;

        case 0:
          Utils.clearScreen();
          System.out.println("Chương trình kết thúc!");
          System.out.println("===================");
          return;

        default:
          Utils.clearScreen();
          System.out.println("Lựa chọn không tồn tại!");
          System.out.println("===================");
          break;
      }
    } while (luaChon != 0);
  }
}