public class Box2<T> {
  private T value;

  public Box2() {
  }

  public Box2(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Box2 value(T value) {
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
