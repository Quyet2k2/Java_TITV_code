import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class App {

  public static void main(String[] args) throws Exception {
    // // ****** Cách 1
    // File f = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\file.txt");
    // try {
    // BufferedReader br = Files.newBufferedReader(f.toPath(),
    // StandardCharsets.UTF_8);
    // String line = null;
    // while (true) {
    // line = br.readLine();
    // if (line == null) {
    // break;
    // } else {
    // System.out.println(line);
    // }
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // // *********** Cách 2
    File f2 = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\file.txt");
    try {
      List<String> allText = Files.readAllLines(f2.toPath(), StandardCharsets.UTF_8);
      for (String line : allText) {
        System.out.println(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}