package car.exceptions;

public class CarCanNotDoActionException extends RuntimeException {
    public CarCanNotDoActionException(String message) {
        super(message);
    }
}
