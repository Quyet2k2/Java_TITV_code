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
    if (!file.exists()) {
      System.out.println("❌ Không tồn tại!");
      return;
    }

    printTree(this.file, "", true);
  }

  private void printTree(File file, String prefix, boolean isLast) {
    // In node hiện tại
    System.out.println(prefix + (isLast ? "└── " : "├── ") + file.getName());

    // Nếu là thư mục thì duyệt tiếp
    if (file.isDirectory() && file.canRead()) {
      File[] children = file.listFiles();
      if (children == null)
        return;

      for (int i = 0; i < children.length; i++) {
        boolean last = (i == children.length - 1);

        printTree(
            children[i],
            prefix + (isLast ? "    " : "│   "),
            last);
      }
    }
  }
}
