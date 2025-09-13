package domain.car;

import static common.ErrorMessages.*;

public class Car {
  private int distance;
  private final String name;

  private Car(String name) {
    this.distance = 0;
    this.name = name;
  }

  public static Car of(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException(NAME_REQUIRED);
    }
    if (name.contains(" ")) {
      throw new IllegalArgumentException(NAME_EMPTY);
    }
    if (name.length() > 5) {
      throw new IllegalArgumentException(NAME_LENGTH);
    }
    return new Car(name);
  }

  public void moveCar(domain.move.MovePolicy policy) {
    if (policy.canMove()) distance++;
  }

  public String getName() { return name; }
  public int getDistance() { return distance; }
}