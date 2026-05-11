import javax.swing.UIManager;

import controller.CounterListener;
import view.CounterView;

public class App {
  public static void main(String[] args) throws Exception {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      new CounterListener(new CounterView());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
