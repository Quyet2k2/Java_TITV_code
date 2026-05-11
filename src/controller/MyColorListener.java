package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MyColorView;

public class MyColorListener implements ActionListener {
  private MyColorView myColorView;

  public MyColorListener(MyColorView myColorView) {
    this.myColorView = myColorView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Red Text":
        myColorView.changeTextColor(Color.RED);
        break;

      case "Yellow Text":
        myColorView.changeTextColor(Color.YELLOW);
        break;

      case "Green Text":
        myColorView.changeTextColor(Color.GREEN);
        break;

      case "Red Background":
        myColorView.changeBackground(Color.RED);
        break;

      case "Yellow Background":
        myColorView.changeBackground(Color.YELLOW);
        break;

      case "Green Background":
        myColorView.changeBackground(Color.GREEN);
        break;

      default:
        break;
    }
  }
}
