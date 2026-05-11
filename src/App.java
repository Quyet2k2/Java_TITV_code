import javax.swing.UIManager;

import controller.TimKiemListener;
import view.TimKiemView;

public class App {
  public static void main(String[] args) throws Exception {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      new TimKiemListener(new TimKiemView());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
