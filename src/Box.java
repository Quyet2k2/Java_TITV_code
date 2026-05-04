public class Box {
  private int value;

  public Box() {
  }

  public Box(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Box value(int value) {
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
