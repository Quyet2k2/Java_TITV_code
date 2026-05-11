package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CounterListener;
import model.CounterModel;

public class CounterView extends JFrame {
  private CounterModel counterModel;
  private JButton jButton_up;
  private JButton jButton_down;
  private JButton jButton_reset;
  private JLabel jLabel_value;

  public CounterView() {
    this.counterModel = new CounterModel();
    this.init();
    this.setVisible(true);
  }

  public void init() {
    this.setTitle("Counter");
    this.setSize(300, 300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ActionListener ac = new CounterListener(this);

    jButton_up = new JButton("UP");
    jButton_down = new JButton("DOWN");
    jButton_reset = new JButton("RESET");
    jLabel_value = new JLabel(this.counterModel.getValue() + "", JLabel.CENTER);

    jButton_up.addActionListener(ac);
    jButton_down.addActionListener(ac);
    jButton_reset.addActionListener(ac);

    JPanel jPanel = new JPanel(new BorderLayout(10, 10));
    JLabel jLabel_title = new JLabel(this.getTitle());
    jLabel_title.setBorder(
        BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 20)));

    jPanel.add(jButton_up, BorderLayout.WEST);
    jPanel.add(jLabel_value, BorderLayout.CENTER);
    jPanel.add(jButton_down, BorderLayout.EAST);
    jPanel.add(jButton_reset, BorderLayout.SOUTH);
    jPanel.add(jLabel_title, BorderLayout.NORTH);
    jPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
    this.add(jPanel);

  }

  public void increment() {
    counterModel.setValue(counterModel.getValue() + 1);
    this.jLabel_value.setText(counterModel.getValue() + "");
  }

  public void decrement() {
    counterModel.setValue(counterModel.getValue() - 1);
    this.jLabel_value.setText(counterModel.getValue() + "");
  }

  public void reset() {
    counterModel.setValue(0);
    this.jLabel_value.setText(counterModel.getValue() + "");
  }

  public CounterModel getCounterModel() {
    return this.counterModel;
  }

  public void setCounterModel(CounterModel counterModel) {
    this.counterModel = counterModel;
  }

  public JButton getJButton_up() {
    return this.jButton_up;
  }

  public void setJButton_up(JButton jButton_up) {
    this.jButton_up = jButton_up;
  }

  public JButton getJButton_down() {
    return this.jButton_down;
  }

  public void setJButton_down(JButton jButton_down) {
    this.jButton_down = jButton_down;
  }

  public JButton getJButton_reset() {
    return this.jButton_reset;
  }

  public void setJButton_reset(JButton jButton_reset) {
    this.jButton_reset = jButton_reset;
  }

  public JLabel getJLabel_value() {
    return this.jLabel_value;
  }

  public void setJLabel_value(JLabel jLabel_value) {
    this.jLabel_value = jLabel_value;
  }

  public CounterView counterModel(CounterModel counterModel) {
    setCounterModel(counterModel);
    return this;
  }

  public CounterView jButton_up(JButton jButton_up) {
    setJButton_up(jButton_up);
    return this;
  }

  public CounterView jButton_down(JButton jButton_down) {
    setJButton_down(jButton_down);
    return this;
  }

  public CounterView jLabel_value(JLabel jLabel_value) {
    setJLabel_value(jLabel_value);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
        " counterModel='" + getCounterModel() + "'" +
        ", jButton_up='" + getJButton_up() + "'" +
        ", jButton_down='" + getJButton_down() + "'" +
        ", jLabel_value='" + getJLabel_value() + "'" +
        "}";
  }
}
