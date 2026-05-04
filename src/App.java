
public class App {
  public static void main(String[] args) throws Exception {
    // Không thể truyền kiểu dữ liệu khác được.
    Box box = new Box(15);
    System.out.println("Gia tri: " + box.getValue());

    // Có thể truyền kiểu dữ liệu khác được.
    Box2<Double> box2 = new Box2<Double>(15.5);
    System.out.println("Gia tri: " + box2.getValue());

    Box2<String> box2_2 = new Box2<String>("Muoi lam");
    System.out.println("Gia tri: " + box2_2.getValue());
  }
}