package domain.car;

import static common.ErrorMessages.*;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
  private final List<Car> values;

  private Cars(List<Car> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Cars of(String raw) {
    if (raw == null || raw.isEmpty()) {
      throw new IllegalArgumentException(NAME_REQUIRED);
    }

    String[] parts = raw.split(",");

    for (String p : parts) {
      if (p.isEmpty()) {
        throw new IllegalArgumentException(NAME_EMPTY);
      }
    }

    Set<String> seen = new HashSet<>();
    for (String p : parts) {
      if (!seen.add(p)) {
        throw new IllegalArgumentException(NAME_DUPLICATION + ": " + p);
      }
    }

    List<Car> list = Arrays.stream(parts)
        .map(Car::of)
        .collect(Collectors.toList());

    return new Cars(list);
  }

  public void moveAll(domain.move.MovePolicy policy) {
    values.forEach(c -> c.moveCar(policy));
  }

  public List<Car> asList() { return values; }

  public List<Car> findWinners() {
    List<Car> winners = new ArrayList<>();
    int max = 0;
    for (Car car : values) {
      int d = car.getDistance();
      if (d > max) { winners.clear(); winners.add(car); max = d; }
      else if (d == max) { winners.add(car); }
    }
    return winners;
  }
}