import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSinhVien {
  private ArrayList<SinhVien> sinhVienList = new ArrayList<>();
  private Scanner sc = new Scanner(System.in);

  public void fakeData() {
    this.addSinhVien(new SinhVien("1", "Phạm Văn Quyết", 2002, 10.0));
    this.addSinhVien(new SinhVien("2", "Phạm Văn Chiến", 2002, 6.0));
    this.addSinhVien(new SinhVien("3", "Phạm Anh Thần", 2002, 7.0));
    this.addSinhVien(new SinhVien("4", "Phạm Anh Vương", 2002, 2.0));
  }

  private void addSinhVien(SinhVien sv) {
    if (!this.kiemTraTonTai(sv.getMaSinhVien()))
      this.sinhVienList.add(sv);
  }

  private void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void menu() {
    clearScreen();
    while (true) {
      System.out.println("Menu ứng dụng:");
      System.out.println("(1): Thêm sinh viên vào danh sách.");
      System.out.println("(2): In danh sách sinh viên ra màn hình.");
      System.out.println("(3): Kiểm tra danh sách có rỗng hay không.");
      System.out.println("(4): Lấy ra số lượng sinh viên trong danh sách.");
      System.out.println("(5): Làm rỗng danh sách sinh viên.");
      System.out.println("(6): Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.");
      System.out.println("(7): Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên.");
      System.out.println("(8): Tìm kiếm một sinh viên dựa trên Tên.");
      System.out.println("(9): Xuất ra danh sách sinh viên có điểm từ cao đến thấp.");
      System.out.println("(10): Ghi dữ liệu xuống file.");
      System.out.println("(0): Thoát ứng dụng.");
      System.out.println("==================");
      System.out.print("Nhập lựa chọn của bạn: ");
      int luaChon;

      try {
        luaChon = Integer.parseInt(sc.nextLine().trim());
      } catch (Exception e) {
        System.out.println("Nhập sai!");
        continue;
      }

      switch (luaChon) {
        // (1): Thêm sinh viên vào danh sách.
        case 1:
          clearScreen();
          this.themSinhVien();
          System.out.println("==================");
          break;

        // (2): In danh sách sinh viên ra màn hình."
        case 2:
          clearScreen();
          this.hienThiDanhSach(this.sinhVienList);
          System.out.println("==================");
          break;

        // (3): Kiểm tra danh sách có rỗng hay không.
        case 3:
          clearScreen();
          System.out.println(this.kiemTraRong(this.sinhVienList) ? "Danh sách rỗng!" : "Danh sách có phần tử!");
          System.out.println("==================");
          break;

        // (4): Lấy ra số lượng sinh viên trong danh sách.
        case 4:
          clearScreen();
          System.out
              .println("Hiện tại trong danh sách có số lượng phần tử là: " + this.laySoLuongSV(this.sinhVienList));
          System.out.println("==================");
          break;

        // (5): Làm rỗng danh sách sinh viên.
        case 5:
          clearScreen();
          this.lamRongDS(this.sinhVienList);
          System.out.println("Đã làm rỗng danh sách.");
          System.out.println("==================");
          break;

        // (6): Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.
        case 6:
          clearScreen();
          System.out.print("Nhập mã sinh viên cần xoá: ");
          this.xoaTheoMaSV(sc.nextLine());
          System.out.println("==================");
          break;

        // (7): Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã
        // sinh viên.
        case 7:
          clearScreen();
          System.out.print("Nhập mã sinh viên cần kiểm tra tồn tại: ");
          System.out.println("Sinh viên " + (this.kiemTraTonTai(sc.nextLine()) ? "có tồn tại" : "không tồn tại"));
          System.out.println("==================");
          break;

        // (8): Tìm kiếm một sinh viên dựa trên Tên.
        case 8:
          clearScreen();
          System.out.print("Nhập tên sinh viên cần tìm kiếm: ");
          this.timKiemSV(sc.nextLine());
          System.out.println("==================");
          break;

        // (9): Xuất ra danh sách sinh viên có điểm từ cao đến thấp.
        case 9:
          clearScreen();
          this.hienThiDanhSachTheoDiemXuongThap(this.sinhVienList);
          System.out.println("==================");
          break;

        // (10): Ghi dữ liệu xuống file
        case 10:
          clearScreen();
          this.ghiDuLieuXuongFile();
          System.out.println("==================");
          break;

        case 0:
          clearScreen();
          System.out.println("Chương trình kết thúc!");
          System.out.println("==================");
          return;

        default:
          break;
      }
    }
  }

  // 10. Ghi dữ liệu xuống file
  private void ghiDuLieuXuongFile() {
    System.out.print("Nhập tên file dữ liệu: ");
    String tenFile = sc.nextLine();
    File file = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\" + tenFile + ".data");
    try {
      OutputStream os = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(os);

      for (SinhVien st : this.sinhVienList)
        oos.writeObject(st);

      oos.flush();
      oos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 9.Xuất ra danh sách sinh viên có điểm từ cao đến thấp
  private void hienThiDanhSachTheoDiemXuongThap(ArrayList<SinhVien> sinhViens) {
    if (this.kiemTraRong(this.sinhVienList)) {
      System.out.println("Danh sách sinh viên hiện tại đang rỗng!");
      return;
    }

    this.sinhVienList.sort((o1, o2) -> Double.compare(o2.getDiemTrungBinh(), o1.getDiemTrungBinh()));
    this.hienThiDanhSach(sinhViens);
  }

  // 8.Tìm kiếm một sinh viên dựa trên Tên
  private void timKiemSV(String tenSV) {
    for (int i = 0; i < this.sinhVienList.size(); i++)
      if (this.sinhVienList.get(i).getHoVaTen().toLowerCase().contains(tenSV.toLowerCase())) {
        System.out.println(this.sinhVienList.get(i));
        return;
      }

    System.out.println("Sinh viên không tồn tại");
  }

  // 7.Kiểm tra sinh viên có tồn tại trong danh sách
  // hay không, dựa trên mã sinh viên
  private boolean kiemTraTonTai(String maSV) {
    for (int i = 0; i < this.sinhVienList.size(); i++) {
      if (this.sinhVienList.get(i).getMaSinhVien().equals(maSV)) {
        return true;
      }
    }
    return false;
  }

  // 6.Xóa một sinh viên ra khỏi danh sách dựa trên mã
  private void xoaTheoMaSV(String maSV) {
    for (int i = 0; i < sinhVienList.size(); i++) {
      if (sinhVienList.get(i).getMaSinhVien().equals(maSV)) {
        this.sinhVienList.remove(i);
        System.out.println("Xoá sinh viên thành công!");
        return;
      }
    }

    System.out.println("Sinh viên không tồn tại!");
  }

  // 5.Làm rỗng danh sách sinh viên
  private void lamRongDS(ArrayList<SinhVien> sinhViens) {
    sinhViens.clear();
  }

  // 4.Lấy ra số lượng sinh viên trong danh sách
  private int laySoLuongSV(ArrayList<SinhVien> sinhViens) {
    return sinhViens.size();
  }

  // 3.Kiểm tra danh sách có rỗng hay không
  private boolean kiemTraRong(ArrayList<SinhVien> sinhViens) {
    return sinhViens.isEmpty();
  }

  // 2.In danh sách sinh viên ra màn hình
  private void hienThiDanhSach(ArrayList<SinhVien> sinhViens) {
    if (this.kiemTraRong(sinhViens)) {
      System.out.println("Danh sách sinh viên hiện tại đang rỗng!");
      return;
    }

    for (SinhVien sv : sinhVienList) {
      System.out.println(sv);
    }
  }

  // ===== INPUT CHÍNH =====
  // 1.Thêm sinh viên vào danh sách
  private void themSinhVien() {
    this.addSinhVien(inputSv());
    System.out.println("Thêm thành công!");
  }

  // ===== TÁCH INPUT =====
  private SinhVien inputSv() {
    SinhVien sv = new SinhVien();

    sv.setMaSinhVien(inputMaSV());
    clearScreen();
    sv.setHoVaTen(inputHoVaTenSV());
    clearScreen();
    sv.setNamSinh(inputNamSinhSV());
    clearScreen();
    sv.setDiemTrungBinh(inputDiemTBSV());
    clearScreen();

    return sv;
  }

  // ===== VALIDATE TỪNG FIELD =====
  private String inputMaSV() {
    while (true) {
      System.out.print("Nhập mã sinh viên: ");
      String ma = sc.nextLine().trim();

      if (ma.isEmpty()) {
        System.out.println("Mã không được rỗng!");
        continue;
      }

      if (this.kiemTraTonTai(ma)) {
        System.out.println("Mã sinh viên đã tồn tại!");
        continue;
      }

      return ma;
    }
  }

  private String inputHoVaTenSV() {
    while (true) {
      System.out.print("Nhập họ và tên sinh viên: ");
      String hoten = sc.nextLine().trim();

      if (!hoten.isEmpty())
        return hoten;

      System.out.println("Họ tên sinh viên không được để rỗng!");
    }
  }

  private int inputNamSinhSV() {
    while (true) {
      try {
        System.out.print("Nhập năm sinh của sinh viên: ");
        int namSinh = Integer.parseInt(sc.nextLine().trim());

        if (namSinh >= 1970 && namSinh <= (LocalDate.now().getYear() - 18))
          return namSinh;

        System.out.println("Nhập năm sinh của sinh viên không hợp lệ!");
      } catch (Exception e) {
        System.out.println("Sai định dạng!");
      }
    }
  }

  private double inputDiemTBSV() {
    while (true) {
      try {
        System.out.print("Nhập điểm trung bình của sinh viên: ");
        double diemTB = Double.parseDouble(sc.nextLine());

        if (diemTB < 0 || diemTB > 10) {
          System.out.println("Điểm trung bình của sinh viên phải trong khoảng từ 0-10!");
          continue;
        }

        return diemTB;
      } catch (Exception e) {
        System.out.println("Sai định dạng!");
      }
    }
  }

}