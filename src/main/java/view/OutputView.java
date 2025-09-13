package view;

import common.ErrorMessages;
import domain.car.Car;
import domain.car.Cars;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

  public void askCarNames() {
    System.out.println(ErrorMessages.ASK_CAR_NAMES);
  }

  public void askRoundCount() {
    System.out.println(ErrorMessages.ASK_ROUND_COUNT);
  }

  public void printResult() {
    System.out.println();
    System.out.println(ErrorMessages.PRINT_RESULT);
  }

  public void printRound(Cars cars) {
    for (Car car : cars.asList()) {
      System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }
    System.out.println();
  }

  public void printWinners(List<Car> winners) {
    String names = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
    System.out.println(ErrorMessages.WINNER_ANNOUNCEMENT + names);
  }
}