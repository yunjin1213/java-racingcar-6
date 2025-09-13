package domain.move;

import camp.nextstep.edu.missionutils.Randoms;

public class MovePolicy {
  private static final int DEFAULT_MOVE_NUMBER = 4;

  public boolean canMove() {
    int number = Randoms.pickNumberInRange(0, 9);
    return number >= DEFAULT_MOVE_NUMBER;
  }
}