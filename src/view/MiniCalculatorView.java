package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.MiniCalculatorListener;
import model.MiniCalculatorModel;

public class MiniCalculatorView extends JFrame {
  private MiniCalculatorModel miniCalculatorModel = new MiniCalculatorModel();
  JButton jButton_plus;
  JButton jButton_minus;
  JButton jButton_multiply;
  JButton jButton_divide;
  JButton jButton_power;
  JButton jButton_mod;

  JTextField jTextField_firstValue;
  JTextField jTextField_secondValue;
  JTextField jTextField_answer;

  public MiniCalculatorView() {
    this.init();
    this.setVisible(true);
  }

  public void init() {
    this.setTitle("MiniCalculator");
    this.setSize(600, 400);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ActionListener ac = new MiniCalculatorListener(this);
    Font font = new Font("Arial", Font.BOLD, 40);

    JLabel jLabel_firstValue = new JLabel("1st Value: ");
    jLabel_firstValue.setFont(font);
    JLabel jLabel_secondValue = new JLabel("2nd Value: ");
    jLabel_secondValue.setFont(font);
    JLabel jLabel_answer = new JLabel("Answer: ");
    jLabel_answer.setFont(font);

    jTextField_firstValue = new JTextField(50);
    jTextField_firstValue.setFont(font);
    jTextField_secondValue = new JTextField(50);
    jTextField_secondValue.setFont(font);
    jTextField_answer = new JTextField(50);
    jTextField_answer.setFont(font);

    JPanel jPanelIO = new JPanel(new GridLayout(3, 2, 10, 10));
    jPanelIO.add(jLabel_firstValue);
    jPanelIO.add(jTextField_firstValue);
    jPanelIO.add(jLabel_secondValue);
    jPanelIO.add(jTextField_secondValue);
    jPanelIO.add(jLabel_answer);
    jPanelIO.add(jTextField_answer);

    JPanel jPanel_buttons = new JPanel(new GridLayout(2, 3, 5, 5));
    jButton_plus = new JButton("+");
    jButton_plus.setFont(font);
    jPanel_buttons.add(jButton_plus);
    jButton_plus.addActionListener(ac);
    jButton_minus = new JButton("-");
    jButton_minus.setFont(font);
    jPanel_buttons.add(jButton_minus);
    jButton_minus.addActionListener(ac);
    jButton_multiply = new JButton("*");
    jButton_multiply.setFont(font);
    jPanel_buttons.add(jButton_multiply);
    jButton_multiply.addActionListener(ac);
    jButton_divide = new JButton("/");
    jButton_divide.setFont(font);
    jPanel_buttons.add(jButton_divide);
    jButton_divide.addActionListener(ac);
    jButton_power = new JButton("^");
    jButton_power.setFont(font);
    jPanel_buttons.add(jButton_power);
    jButton_power.addActionListener(ac);
    jButton_mod = new JButton("%");
    jButton_mod.setFont(font);
    jPanel_buttons.add(jButton_mod);
    jButton_mod.addActionListener(ac);

    jPanelIO.setBorder(new EmptyBorder(20, 20, 20, 20));
    jPanel_buttons.setBorder(new EmptyBorder(20, 20, 20, 20));
    this.setLayout(new BorderLayout());
    this.add(jPanelIO, BorderLayout.CENTER);
    this.add(jPanel_buttons, BorderLayout.SOUTH);
  }

  public void plus() {
    Double firstValue = Double.valueOf(this.jTextField_firstValue.getText());
    Double secondValue = Double.valueOf(this.jTextField_secondValue.getText());
    miniCalculatorModel.setFirstValue(firstValue);
    miniCalculatorModel.setSecondValue(secondValue);
    miniCalculatorModel.plus();
    this.jTextField_answer.setText(miniCalculatorModel.getAnswer() + "");
  }

  public void minus() {
    Double firstValue = Double.valueOf(this.jTextField_firstValue.getText());
    Double secondValue = Double.valueOf(this.jTextField_secondValue.getText());
    miniCalculatorModel.setFirstValue(firstValue);
    miniCalculatorModel.setSecondValue(secondValue);
    miniCalculatorModel.minus();
    this.jTextField_answer.setText(miniCalculatorModel.getAnswer() + "");
  }

  public void multiply() {
    Double firstValue = Double.valueOf(this.jTextField_firstValue.getText());
    Double secondValue = Double.valueOf(this.jTextField_secondValue.getText());
    miniCalculatorModel.setFirstValue(firstValue);
    miniCalculatorModel.setSecondValue(secondValue);
    miniCalculatorModel.multiply();
    this.jTextField_answer.setText(miniCalculatorModel.getAnswer() + "");
  }

  public void divide() {
    Double firstValue = Double.valueOf(this.jTextField_firstValue.getText());
    Double secondValue = Double.valueOf(this.jTextField_secondValue.getText());
    miniCalculatorModel.setFirstValue(firstValue);
    miniCalculatorModel.setSecondValue(secondValue);
    miniCalculatorModel.divide();
    this.jTextField_answer.setText(miniCalculatorModel.getAnswer() + "");
  }

  public void mod() {
    Double firstValue = Double.valueOf(this.jTextField_firstValue.getText());
    Double secondValue = Double.valueOf(this.jTextField_secondValue.getText());
    miniCalculatorModel.setFirstValue(firstValue);
    miniCalculatorModel.setSecondValue(secondValue);
    miniCalculatorModel.mod();
    this.jTextField_answer.setText(miniCalculatorModel.getAnswer() + "");
  }

  public void power() {
    Double firstValue = Double.valueOf(this.jTextField_firstValue.getText());
    Double secondValue = Double.valueOf(this.jTextField_secondValue.getText());
    miniCalculatorModel.setFirstValue(firstValue);
    miniCalculatorModel.setSecondValue(secondValue);
    miniCalculatorModel.power();
    this.jTextField_answer.setText(miniCalculatorModel.getAnswer() + "");
  }
}
