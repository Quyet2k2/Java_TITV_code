import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
* Một người chơi sẽ có tài khoản. Người chơi có quyền đặt cược số tiền ít hơn hoặc bằng
* số tiền họ đang có.
* Luật chơi như sau:
* Có 3 viên xúc xắc. Mõi viên xúc có 6 mặt có giá tị từ 1 đến 6.
* Mỗi lần lắc sẽ ra một kết quả. Kết quả = giá trị xx1 + giá trị xx2 + giá xx3
* 1. Nếu tổng = 3 hoặc 18 => Cái ăn hết, người chơi thua.
* 2. Nếu tổng = (4->10) <- > xỉu => nếu người chơi đặt xỉu thì người chơi thắng, ngược lại thua
* 3. Nếu tổng = (11-17) <- > tài => nếu người chơi đặt xỉu thì người chơi thắng, ngược lại thua
*/

public class __TaiXiuGame {
  public void choi() {
    double taiKhoanNguoiChoi = 5000000;
    Scanner sc = new Scanner(System.in);
    Locale lc = new Locale("vi", "VN");
    NumberFormat numf = NumberFormat.getInstance(lc);

    int luaChon = 1;
    do {
      System.out.println("====== MOI BAN LUA CHON ==========");
      System.out.println("Chon (1) de tiep tuc choi. ");
      System.out.println("Chon (phim bat ky) de thoat.");
      try {
        luaChon = sc.nextInt();
      } catch (Exception e) {
        System.out.println("****************************");
        System.out.println("Ban da thoat!");
        break;
      }

      if (luaChon == 1) {
        System.out.println("*** BAT DAU CHOI ***");

        // Dat cuoc
        double datCuoc = 0;
        System.out.println("***** Tai khoan cua ban: " + numf.format(taiKhoanNguoiChoi) + ", ban muon cuoc bao nhieu?");
        do {
          System.out.print("****** Dat cuoc (0 < so tien cuoc <= " + numf.format(taiKhoanNguoiChoi) + "): ");
          datCuoc = sc.nextDouble();
        } while (datCuoc <= 0 || datCuoc > taiKhoanNguoiChoi);
        taiKhoanNguoiChoi -= datCuoc;

        // Chon tai/xiu
        int luaChonTaiXiu = 0;
        do {
          System.out.println("--------");
          System.out.println("Nhan (1) de chon 'Tai', nhan (2) de chon 'Xiu'!");
          System.out.println();
          luaChonTaiXiu = sc.nextInt();

          if (luaChonTaiXiu != 1 && luaChonTaiXiu != 2) {
            System.out.println("--------");
            System.out.println("Nhap khong dung, vui long nhap lai!");
          }
        } while (luaChonTaiXiu != 1 && luaChonTaiXiu != 2);

        // Tung xuc xac
        int x1 = (int) Math.floor(Math.random() * 6) + 1;
        int x2 = (int) Math.floor(Math.random() * 6) + 1;
        int x3 = (int) Math.floor(Math.random() * 6) + 1;
        int sum = x1 + x2 + x3;

        // Xu ly ket qua
        System.out.printf("Diem x1=%d, x2=%d, x3=%d => Tong diem=%d. ", x1, x2, x3, sum);
        System.out.println();
        if (sum == 3 || sum == 18)
          System.out.print("BAN THUA!");

        else if (sum >= 4 && sum <= 10) {
          System.out.print("TAI, ");
          if (luaChonTaiXiu == 1) {
            System.out.println("BAN THANG");
            taiKhoanNguoiChoi += (datCuoc * 2);
          } else
            System.out.println("BAN THUA");

        } else if (sum >= 11 && sum <= 17) {
          System.out.print("XIU, ");
          if (luaChonTaiXiu == 2) {
            System.out.println("BAN THANG");
            taiKhoanNguoiChoi += (datCuoc * 2);
          } else
            System.out.println("BAN THUA");
        }

        datCuoc = 0;
        System.out.println("****** Tai khoan cua ban la: " + numf.format(taiKhoanNguoiChoi));
      }
    } while (luaChon == 1);

    sc.close();
    System.out.println("Hen gap lai!");
  }
}
