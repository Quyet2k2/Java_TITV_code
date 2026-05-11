package model;

public class CounterModel {
  private int value;

  public CounterModel() {
    this.value = 0;
  }

  public CounterModel(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public CounterModel value(int value) {
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
