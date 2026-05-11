package model;

import java.awt.Color;

public class MyColorModel {
  private Color foreground;
  private Color background;
  private boolean opaque;

  public MyColorModel() {
    this.foreground = Color.BLACK;
    this.background = Color.WHITE;
    this.opaque = true;
  }

  public Color getForeground() {
    return this.foreground;
  }

  public void setForeground(Color foreground) {
    this.foreground = foreground;
  }

  public Color getBackground() {
    return this.background;
  }

  public void setBackground(Color background) {
    this.background = background;
  }

  public boolean isOpaque() {
    return this.opaque;
  }

  public boolean getOpaque() {
    return this.opaque;
  }

  public void setOpaque(boolean opaque) {
    this.opaque = opaque;
  }

  public MyColorModel foreground(Color foreground) {
    setForeground(foreground);
    return this;
  }

  public MyColorModel background(Color background) {
    setBackground(background);
    return this;
  }

  public MyColorModel opaque(boolean opaque) {
    setOpaque(opaque);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
        " foreground='" + getForeground() + "'" +
        ", background='" + getBackground() + "'" +
        ", opaque='" + isOpaque() + "'" +
        "}";
  }
}
