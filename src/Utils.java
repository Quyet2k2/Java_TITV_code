import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void ensureParentDir(File file) {
    File parent = file.getParentFile();

    if (parent != null && !parent.exists())
      parent.mkdirs();
  }

  public static List<File> getAllDataFiles(String folderPath) {
    File folder = new File(folderPath);
    List<File> result = new ArrayList<>();

    if (folder.exists() && folder.isDirectory()) {
      File[] files = folder.listFiles();

      if (files != null) {
        for (File f : files) {
          if (f.isFile() && f.getName().endsWith(".data")) {
            result.add(f);
          }
        }
      }
    }

    return result;
  }

  public static void readFile(File file) {
    System.out.println("Đang đọc file: " + file.getName());

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      while (true) {
        try {
          Object obj = ois.readObject();
          System.out.println(obj);
        } catch (EOFException e) {
          break;
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
