package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LastButtonView;

public class LastButtonListener implements ActionListener {
  private LastButtonView lastButtonView;

  public LastButtonListener(LastButtonView lastButtonView) {
    this.lastButtonView = lastButtonView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    lastButtonView.changeTo(Integer.parseInt(e.getActionCommand()));
  }
}
