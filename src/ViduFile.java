import java.io.File;

public class ViduFile {
  File file;

  public ViduFile(String tenFile) {
    this.file = new File(tenFile);
  }

  // 1. Kiểm tra file có thể thực thi
  public boolean kiemTraThuThi() {
    return this.file.canExecute();
  }

  // 2. Kiểm tra file có thể đọc
  public boolean kiemTraDoc() {
    return this.file.canRead();
  }

  // 3. Kiểm tra file có thể ghi
  public boolean kiemTraGhi() {
    return this.file.canWrite();
  }

  // 4. In đường dẫn
  public void inDuongDan() {
    System.out.println(this.file.getPath());
  }

  // 5. In tên file
  public void inTen() {
    System.out.println(this.file.getName());
  }

  // 6. Kiểm tra file là thư mục hoặc tệp tin
  public void kiemTraLaThuMucHoacTapTin() {
    if (this.file.isFile())
      System.out.println("Là tệp tin!");
    else if (this.file.isDirectory())
      System.out.println("Là thư mục!");
    else
      System.out.println("Không xác định!");
  }

  // 7. In ra danh sách các file con
  public void inDanhSachCacFileCon() {
    if (this.file.isDirectory()) {
      System.out.println("Các tệp tin con/ thư mục con là: ");
      File[] mangCon = this.file.listFiles();

      for (File file : mangCon)
        System.out.println(file.getAbsolutePath());
    } else if (this.file.isFile()) {
      System.out.println("Đây là tệp tin, không có dữ liệu con bên trong.");
      return;
    } else
      System.out.println("Không xác định!");
  }

  // 8. In ra cây thư mục
  public void inCayThuMuc() {
    if (this.file.isDirectory()) {
      System.out.println("Các tệp tin con/ thư mục con là: ");
      inChiTietCayThuMuc(this.file, 0);
    } else if (this.file.isFile())
      System.out.println("Đây là tệp tin, không có dữ liệu con bên trong.");
    else
      System.out.println("Không xác định!");
  }

  public void inChiTietCayThuMuc(File f, int bac) {
    for (int i = 0; i < bac; i++)
      System.out.print("   ");
    System.out.print("|___");

    System.out.println(f.getName());
    if (f.canRead() && f.isDirectory()) {
      File[] mangCon = f.listFiles();
      if (mangCon == null)
        return;

      for (File fx : mangCon)
        inChiTietCayThuMuc(fx, bac + 1);
    }
  }
}
