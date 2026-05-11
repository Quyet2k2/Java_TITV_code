import javax.swing.UIManager;

import controller.MiniCalculatorListener;
import view.MiniCalculatorView;

public class App {
  public static void main(String[] args) throws Exception {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      new MiniCalculatorListener(new MiniCalculatorView());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
