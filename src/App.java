import java.io.File;
import java.nio.file.Files;

public class App {

  public static void xoaFile(File fx) {
    if (fx.isFile()) {
      // Xoá nếu là tập tin
      fx.delete();
      System.out.println("Đã xoá: " + fx.getAbsolutePath());
    }

    else if (fx.isDirectory()) {
      // Lấy các file con
      File[] mangCon = fx.listFiles();
      for (File f : mangCon)
        // Xoá các file con
        xoaFile(f);

      // Xoá bản thân thư mục sau khi đã xoá các file con
      fx.delete();
      System.out.println("Đã xoá: " + fx.getAbsolutePath());
    }
  }

  public static void xoaFile2(File fx) {
    if (fx.isFile()) {
      // Xoá nếu là tập tin
      try {
        Files.deleteIfExists(fx.toPath());
        System.out.println("Đã xoá: " + fx.getAbsolutePath());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    else if (fx.isDirectory()) {
      // Lấy các file con
      File[] mangCon = fx.listFiles();
      for (File f : mangCon)
        // Xoá các file con
        xoaFile(f);

      // Xoá bản thân thư mục sau khi đã xoá các file con
      try {
        Files.deleteIfExists(fx.toPath());
        System.out.println("Đã xoá: " + fx.getAbsolutePath());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    // File f1 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\f1");
    // f1.mkdir();
    // File f2 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\__f2.txt");
    // f2.createNewFile();
    // f1.deleteOnExit(); // Xoá được, vì là thư mục rỗng
    // f2.deleteOnExit(); // Xoá được, vì là tệp tin

    File f0_f2 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\f0\\f1\\f2");
    f0_f2.mkdirs();

    File f0 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\f0");
    f0.deleteOnExit(); // Không xoá được, vì có chứa tệp tin và thư mục

    // ***** Sử dụng class File xoá tập tin hoặc thư mục
    App.xoaFile(f0);

    // ***** Sử dụng class Files xoá tập tin và thư mục
    // App.xoaFile2(f0);
  }
}