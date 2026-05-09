
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class App {
  public static void main(String[] args) throws Exception {
    MyWindow m1 = new MyWindow();
    m1.showIt();
  }
}

class MyWindow extends JFrame {
  public MyWindow() {
    this.setSize(600, 400);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // FlowLayout
    // this.setLayout(new FlowLayout());
    // this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    // this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

    // GridLayout
    // this.setLayout(new GridLayout());
    // this.setLayout(new GridLayout(4, 4));
    // this.setLayout(new GridLayout(4, 4, 25, 25));

    // BorderLayout
    String[] locationLayout = new String[] {
        BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH, BorderLayout.CENTER };
    this.setLayout(new BorderLayout());
    this.setLayout(new BorderLayout(15, 15));

    for (int i = 1; i <= 6; i++) {
      JButton jButton = new JButton(i + "");
      // this.add(jButton);

      this.add(jButton, locationLayout[i <= locationLayout.length ? i - 1 : 0]);
    }
  }

  public void showIt() {
    this.setVisible(true);
  }

  public void showIt(String title) {
    this.setTitle(title);
    this.setVisible(true);
  }

  public void showIt(String title, int width, int height) {
    this.setTitle(title);
    this.setSize(width, height);
    this.setVisible(true);
  }
}
