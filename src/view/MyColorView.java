package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MyColorListener;

public class MyColorView extends JFrame {
  private JLabel jLabel;

  public MyColorView() {
    this.init();
    this.setVisible(true);
  }

  public void init() {
    this.setTitle("MyColor");
    this.setSize(1400, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ActionListener ac = new MyColorListener(this);

    Font font = new Font("Arial", Font.BOLD, 40);
    JPanel jPanel = new JPanel(new GridLayout(2, 3, 5, 5));
    jPanel.setBorder(new EmptyBorder(0, 20, 0, 20));

    Font font_text = new Font("Arial", Font.BOLD, 100);
    jLabel = new JLabel("TEXT, ......");
    jLabel.setFont(font_text);

    //
    JButton jButton_text_red = new JButton("Red Text");
    jButton_text_red.setFont(font);
    jButton_text_red.setForeground(Color.RED);
    jButton_text_red.addActionListener(ac);
    jPanel.add(jButton_text_red);

    JButton jButton_text_yellow = new JButton("Yellow Text");
    jButton_text_yellow.setFont(font);
    jButton_text_yellow.setForeground(Color.YELLOW);
    jButton_text_yellow.addActionListener(ac);
    jPanel.add(jButton_text_yellow);

    JButton jButton_text_green = new JButton("Green Text");
    jButton_text_green.setFont(font);
    jButton_text_green.setForeground(Color.GREEN);
    jButton_text_green.addActionListener(ac);
    jPanel.add(jButton_text_green);

    //
    JButton jButton_background_red = new JButton("Red Background");
    jButton_background_red.setFont(font);
    jButton_background_red.setBackground(Color.RED);
    // jButton_background_red.setOpaque(true);
    jButton_background_red.setBorderPainted(false);
    jButton_background_red.addActionListener(ac);
    jPanel.add(jButton_background_red);

    JButton jButton_background_yellow = new JButton("Yellow Background");
    jButton_background_yellow.setFont(font);
    jButton_background_yellow.setBackground(Color.YELLOW);
    // jButton_background_yellow.setOpaque(true);
    jButton_background_yellow.setBorderPainted(false);
    jButton_background_yellow.addActionListener(ac);
    jPanel.add(jButton_background_yellow);

    JButton jButton_background_green = new JButton("Green Background");
    jButton_background_green.setFont(font);
    jButton_background_green.setBackground(Color.GREEN);
    // jButton_background_green.setOpaque(true);
    jButton_background_green.setBorderPainted(false);
    jButton_background_green.addActionListener(ac);
    jPanel.add(jButton_background_green);

    //
    jPanel.add(jButton_text_red);
    jPanel.add(jButton_text_yellow);
    jPanel.add(jButton_text_green);
    jPanel.add(jButton_background_red);
    jPanel.add(jButton_background_yellow);
    jPanel.add(jButton_background_green);

    //
    this.setLayout(new BorderLayout(5, 5));
    this.add(jLabel, BorderLayout.NORTH);
    this.add(jPanel, BorderLayout.CENTER);
  }

  public JLabel getJLabel_footer() {
    return this.jLabel;
  }

  public void setJLabel_footer(JLabel jLabel) {
    this.jLabel = jLabel;
  }

  public void changeTextColor(Color color) {
    jLabel.setForeground(color);
  }

  public void changeBackground(Color color) {
    jLabel.setBackground(color);
    jLabel.setOpaque(true);
  }
}
