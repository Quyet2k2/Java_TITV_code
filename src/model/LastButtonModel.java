package model;

public class LastButtonModel {
  private int value;

  public LastButtonModel() {
    this.value = 0;
  }

  public LastButtonModel(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public LastButtonModel value(int value) {
    setValue(value);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
        " value='" + getValue() + "'" +
        "}";
  }
}
