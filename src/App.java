public class App {

  public static void main(String[] args) throws Exception {
    Utils.clearScreen();
    DanhSachSinhVien ds = new DanhSachSinhVien();
    ds.fakeData();
    ds.menu();
  }
}