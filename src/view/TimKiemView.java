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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.TimKiemListener;
import model.TimKiemModel;

public class TimKiemView extends JFrame {
  private TimKiemModel timKiemModel = new TimKiemModel();
  private JTextArea jTextArea_vanBan;
  private JTextField jTextArea_tuKhoa;

  private JLabel jLabel_thongKe;
  private JButton jButton_thongKe;

  public TimKiemView() {
    this.init();
    this.setVisible(true);
  }

  public void init() {
    this.setTitle("TimKiem");
    this.setSize(800, 1000);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ActionListener ac = new TimKiemListener(this);
    Font font = new Font("Arial", Font.BOLD, 40);

    // Top
    JLabel jLabel_vanBan = new JLabel("Văn bản: ");
    jLabel_vanBan.setFont(font);
    jLabel_vanBan.setBorder(new EmptyBorder(20, 20, 0, 20));

    // Center
    JPanel jPanel_center = new JPanel(new GridLayout(2, 1, 10, 10));
    jPanel_center.setBorder(new EmptyBorder(10, 20, 20, 20));

    jTextArea_vanBan = new JTextArea(400, 100);
    jTextArea_vanBan.setFont(font);
    jPanel_center.add(jTextArea_vanBan);

    // Footer
    JPanel jPanel_footer = new JPanel(new GridLayout(4, 1, 10, 10));
    jPanel_footer.setBorder(new EmptyBorder(20, 20, 20, 20));

    JLabel jLabel_tuKhoa = new JLabel("Từ khoá: ");
    jLabel_tuKhoa.setFont(font);
    jPanel_footer.add(jLabel_tuKhoa);

    jTextArea_tuKhoa = new JTextField();
    jTextArea_tuKhoa.setFont(font);
    jPanel_footer.add(jTextArea_tuKhoa);

    jButton_thongKe = new JButton("Thống kê");
    jButton_thongKe.setFont(new Font("Arial", Font.BOLD, 20));
    jButton_thongKe.setForeground(Color.WHITE);
    jButton_thongKe.setBackground(Color.BLUE);
    jButton_thongKe.setBorderPainted(false);
    jButton_thongKe.setOpaque(true);
    jButton_thongKe.addActionListener(ac);
    jPanel_footer.add(jButton_thongKe);

    jLabel_thongKe = new JLabel();
    jLabel_thongKe.setFont(font);
    jPanel_footer.add(jLabel_thongKe);

    this.setLayout(new BorderLayout());
    this.add(jLabel_vanBan, BorderLayout.NORTH);
    this.add(jPanel_center, BorderLayout.CENTER);
    this.add(jPanel_footer, BorderLayout.SOUTH);
  }

  public void thongKe() {
    this.timKiemModel.setVanBan(this.jTextArea_vanBan.getText());
    this.timKiemModel.setTuKhoa(this.jTextArea_tuKhoa.getText());

    this.timKiemModel.timKiem();
    this.jLabel_thongKe.setText(this.timKiemModel.getKetQua());
  }
}
