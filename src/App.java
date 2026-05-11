import javax.swing.UIManager;

import controller.MyColorListener;
import view.MyColorView;

public class App {
  public static void main(String[] args) throws Exception {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      new MyColorListener(new MyColorView());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
