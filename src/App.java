import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class App {

  public static void main(String[] args) throws Exception {
    Utils.clearScreen();
    // zipFile();
    // zipMultipleFiles();
    // zipDirectory();
    unZipFile();
  }

  public static void unZipFile() throws IOException {
    String fileZip = "E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\dirCompressed.zip";
    File destDir = new File("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\unzipTest");
    byte[] buffer = new byte[1024];
    ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
    ZipEntry zipEntry = zis.getNextEntry();

    while (zipEntry != null) {
      File newFile = newFile(destDir, zipEntry);

      // Nếu là folder
      if (zipEntry.isDirectory()) {
        if (!newFile.isDirectory() && !newFile.mkdirs()) {
          zis.close();
          throw new IOException("Failed to create directory " + newFile);
        }
      }

      // Nếu là file
      else {
        // fix for Windows-created archives
        File parent = newFile.getParentFile();
        if (!parent.isDirectory() && !parent.mkdirs()) {
          zis.close();
          throw new IOException("Failed to create directory " + parent);
        }

        // write file content
        int len;
        FileOutputStream fos = new FileOutputStream(newFile);
        while ((len = zis.read(buffer)) > 0)
          fos.write(buffer, 0, len);

        fos.close();
      }

      zipEntry = zis.getNextEntry();
    }
    zis.closeEntry();
    zis.close();
  }

  public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
    File destFile = new File(destinationDir, zipEntry.getName());

    String destDirPath = destinationDir.getCanonicalPath();
    String destFilePath = destFile.getCanonicalPath();

    if (!destFilePath.startsWith(destDirPath + File.separator))
      throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());

    return destFile;
  }

  public static void zipDirectory() throws IOException {
    String sourceFile = "E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\zipTest";
    FileOutputStream fos = new FileOutputStream("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\dirCompressed.zip");
    ZipOutputStream zipOut = new ZipOutputStream(fos);
    File fileToZip = new File(sourceFile);

    zipNestedFile(fileToZip, fileToZip.getName(), zipOut);
    zipOut.close();
    fos.close();
  }

  private static void zipNestedFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
    if (fileToZip.isHidden())
      return;

    if (fileToZip.isDirectory())
      if (fileName.endsWith("/")) {
        zipOut.putNextEntry(new ZipEntry(fileName));
        zipOut.closeEntry();
      } else {
        zipOut.putNextEntry(new ZipEntry(fileName + "/"));
        zipOut.closeEntry();

        File[] children = fileToZip.listFiles();
        for (File childFile : children) {
          zipNestedFile(childFile, fileName + "/" + childFile.getName(), zipOut);
        }
        return;
      }

    FileInputStream fis = new FileInputStream(fileToZip);
    ZipEntry zipEntry = new ZipEntry(fileName);
    zipOut.putNextEntry(zipEntry);
    byte[] bytes = new byte[1024];
    int length;
    while ((length = fis.read(bytes)) >= 0)
      zipOut.write(bytes, 0, length);

    fis.close();
  }

  public static void zipMultipleFiles() throws IOException {
    String sourceFile1 = "E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\test.txt";
    String sourceFile2 = "E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\test 2.txt";

    List<String> srcFiles = Arrays.asList(sourceFile1, sourceFile2);
    FileOutputStream fos = new FileOutputStream("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\multiCompressed.zip");
    ZipOutputStream zipOut = new ZipOutputStream(fos);
    for (String srcFile : srcFiles) {
      File fileToZip = new File(srcFile);
      FileInputStream fis = new FileInputStream(fileToZip);
      ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
      zipOut.putNextEntry(zipEntry);

      byte[] bytes = new byte[1024];
      int length;
      while ((length = fis.read(bytes)) >= 0)
        zipOut.write(bytes, 0, length);
      fis.close();
    }

    zipOut.close();
    fos.close();
  }

  public static void zipFile() throws IOException {
    String sourceFile = "E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\test.txt";
    FileOutputStream fos = new FileOutputStream("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\compressed.zip");
    ZipOutputStream zipOut = new ZipOutputStream(fos);

    File fileToZip = new File(sourceFile);
    FileInputStream fis = new FileInputStream(fileToZip);

    ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
    zipOut.putNextEntry(zipEntry);
    byte[] bytes = new byte[1024];
    int length;
    while ((length = fis.read(bytes)) >= 0)
      zipOut.write(bytes, 0, length);

    zipOut.close();
    fis.close();
    fos.close();
  }

}
