package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CounterView;

public class CounterListener implements ActionListener {
  private CounterView ctv;

  public CounterListener(CounterView ctv) {
    this.ctv = ctv;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(ctv.getJButton_up())) {
      ctv.increment();
    }

    else if (e.getSource().equals(ctv.getJButton_down())) {
      ctv.decrement();
    }

    else if (e.getSource().equals(ctv.getJButton_reset())) {
      ctv.reset();
    }
  }
}
