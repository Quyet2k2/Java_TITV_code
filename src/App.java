import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class App {
  public static void copyAll(File f1, File f2) {
    try {
      // Copy bản thân nó
      Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (f1.isDirectory()) {
      // Copy các tập tin và thư mục con
      File[] mangCon = f1.listFiles();
      for (File file : mangCon) {
        File file_new = new File(f2.getAbsoluteFile() + "/" + file.getName());
        copyAll(file, file_new);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    File f0 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\File_1.txt");
    File f1 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\File_2.txt");
    File f2 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\File_2xyz.txt");

    // f0.createNewFile();
    // f1.createNewFile();
    // f2.createNewFile();

    // // ******** 1.Thay đổi tên tập tin hoặc thư mục
    // // **** Sử dụng File để thay đổi tên
    // f0.renameTo(f1);

    // // **** Sử dụng Files để thay đổi tên
    // try {
    // Files.move(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // // ******** 2. Di chuyển file
    // File f_2new = new
    // File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\f0\\___f2_xyz.txt");
    // try {
    // Files.move(f2.toPath(), f_2new.toPath(),
    // StandardCopyOption.REPLACE_EXISTING);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // File folder_1 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\F1");
    // File folder_1new = new
    // File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\F0\\F1");
    // folder_1.mkdirs();
    // folder_1new.mkdirs();
    // try {
    // Files.move(folder_1.toPath(), folder_1new.toPath(),
    // StandardCopyOption.REPLACE_EXISTING);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // // ******** 3. Copy file
    File f_0 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\F0");
    File f_0_copy = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\F0_copy");
    // f_0.mkdirs();
    // f_0_copy.mkdirs();

    // try {
    // Files.copy(f_0.toPath(), f_0_copy.toPath(),
    // StandardCopyOption.REPLACE_EXISTING);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    App.copyAll(f_0, f_0_copy);
  }
}