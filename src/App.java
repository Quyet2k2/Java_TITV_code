import java.io.File;

public class App {
  public static void main(String[] args) throws Exception {
    File folder1 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\folder1");
    File folder2 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\folder2");
    System.out.println("Kiểm tra folder1 có tồn tại hay không: " + folder1.exists());
    System.out.println("Kiểm tra folder2 có tồn tại hay không: " + folder2.exists());

    File d1 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\directory_1");
    // d1.mkdir(); // không tạo được nhiều thư mục

    File d2 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\directory_1\\d2\\d3\\d4");
    d2.mkdirs(); // tạo được nhiều thư mục

    // Tạo tệp tin (có phần mở rộng)
    File f1 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\directory_1\\vidu.txt");
    try {
      f1.createNewFile();
    } catch (Exception e) {
      // Không có quyền tạo tệp tin
      // Ổ cứng bị đầy
      // Đường dẫn sai
      e.printStackTrace();
    }
  }
}