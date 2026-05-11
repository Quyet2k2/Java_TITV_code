package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LastButtonListener;
import model.LastButtonModel;

public class LastButtonView extends JFrame {
  private JLabel jLabel_footer;
  private LastButtonModel lastButtonModel = new LastButtonModel();

  public LastButtonView() {
    this.init();
    this.setVisible(true);
  }

  public void init() {
    this.setTitle("LastButton");
    this.setSize(300, 300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ActionListener ac = new LastButtonListener(this);

    Font font = new Font("Arial", Font.BOLD, 40);

    JPanel jPanel_Center = new JPanel(new GridLayout(2, 2));
    for (int i = 1; i <= 4; i++) {
      JButton jButton = new JButton(i + "");
      jButton.setFont(font);
      jPanel_Center.add(jButton);
      jButton.addActionListener(ac);
    }

    jLabel_footer = new JLabel("----------", JLabel.CENTER);
    jLabel_footer.setFont(font);

    this.setLayout(new BorderLayout());
    this.add(jPanel_Center, BorderLayout.CENTER);
    this.add(jLabel_footer, BorderLayout.SOUTH);
    jPanel_Center.setBorder(new EmptyBorder(20, 20, 20, 20));
  }

  public JLabel getJLabel_footer() {
    return this.jLabel_footer;
  }

  public void setJLabel_footer(JLabel jLabel_footer) {
    this.jLabel_footer = jLabel_footer;
  }

  public void changeTo(int value) {
    this.jLabel_footer.setText("Last Button: " + value);
    lastButtonModel.setValue(value);
  }
}
