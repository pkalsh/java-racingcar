package racingcar.repository;

import racingcar.domain.Car;
import racingcar.repository.exception.NotDuplicateNameException;
import racingcar.util.Discriminator;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars;

    public CarManager() {
        cars = new ArrayList<>();
    }

    private void checkDuplicateName(Car car) {
        if (cars.contains(car)) {
            throw new NotDuplicateNameException("중복되는 이름의 차를 입력하실 수 없습니다.");
        }
    }

    public int size() {
        return cars.size();
    }

    public void addAllCars(List<Car> carNames) {
        for (Car car : carNames) {
            checkDuplicateName(car);
            cars.add(car);
        }
    }

    public void moveAllCars(List<Integer> randomNumberList) {
        for (int i = 0; i < randomNumberList.size(); i++) {
            Integer randomNumber = randomNumberList.get(i);
            if (Discriminator.isMove(randomNumber)) {
                cars.get(i).move();
            }
        }
    }
}
