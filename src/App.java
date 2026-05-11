import javax.swing.UIManager;

import controller.LastButtonListener;
import view.LastButtonView;

public class App {
  public static void main(String[] args) throws Exception {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      new LastButtonListener(new LastButtonView());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
