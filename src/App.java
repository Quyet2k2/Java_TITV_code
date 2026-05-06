import java.io.PrintWriter;

public class App {

  public static void main(String[] args) throws Exception {
    try {
      PrintWriter pw = new PrintWriter("E:\\JAVA_WORKSPACE\\Java_TITV_code\\src\\file.txt", "UTF-8");

      pw.println("Xin chào, mình là Quyết!");

      pw.print("Dữ liệu: ");
      pw.print(3.14);
      pw.print(' ');
      pw.print("là số PI!");

      pw.println();
      Student student = new Student(100, "Phạm Văn Quyết");
      pw.println(student);

      pw.flush();
      pw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class Student {
  private int id;
  private String name;

  public Student() {
  }

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Student id(int id) {
    setId(id);
    return this;
  }

  public Student name(String name) {
    setName(name);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", name='" + getName() + "'" +
        "}";
  }

}