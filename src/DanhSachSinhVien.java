import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSinhVien {
  private ArrayList<SinhVien> sinhVienList;

  public DanhSachSinhVien() {
    this.sinhVienList = new ArrayList<>();
  }

  public DanhSachSinhVien(ArrayList<SinhVien> sinhVienList) {
    this.sinhVienList = sinhVienList;
  }

  public void addSinhVien(SinhVien sv) {
    this.sinhVienList.add(sv);
  }

  public ArrayList<SinhVien> getSinhVienList() {
    return this.sinhVienList;
  }

  public void setSinhVienList(ArrayList<SinhVien> sinhVienList) {
    this.sinhVienList = sinhVienList;
  }

  public DanhSachSinhVien sinhVienList(ArrayList<SinhVien> sinhVienList) {
    setSinhVienList(sinhVienList);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
        " sinhVienList='" + getSinhVienList() + "'" +
        "}";
  }

  public void themSinhVien() {
    int luaChon = 0;
    Scanner sc = new Scanner(System.in);

    do {
      try {
        System.out.println("Nhan (1) de them sinh vien!");
        luaChon = Integer.parseInt(sc.nextLine());
      } catch (Exception e) {
        System.out.println("Nhap sai ky tu!");
      }
      if (luaChon != 1)
        break;

      boolean isOK = false;
      SinhVien sv = new SinhVien();

      do {
        try {
          System.out.println("Nhap thong tin sinh vien");

          if (sv.getMaSinhVien() == null) {
            System.out.print("Nhap ma sinh vien: ");
            sv.setMaSinhVien(sc.nextLine());
          }

          if (sv.getHoVaTen() == null) {
            System.out.print("Nhap HoVaTen: ");
            sv.setHoVaTen(sc.nextLine());
          }

          if (sv.getNamSinh() == 0) {
            System.out.print("Nhap NamSinh: ");
            sv.setNamSinh(Integer.parseInt(sc.nextLine()));
          }

          if (sv.getDiemTrungBinh() == 0.0) {
            System.out.print("Nhap DiemTrungBinh: ");
            sv.setDiemTrungBinh(Double.parseDouble(sc.nextLine()));
          }
        } catch (Exception e) {
          System.out.println("Nhap sai dinh dang thong tin sinh vien!");
        }

        isOK = true;
        this.addSinhVien(sv);
      } while (isOK == false);

      System.out.println("===================================");
    } while (luaChon == 1);
    System.out.println("Ket thuc them sinh vien!");
  }
}