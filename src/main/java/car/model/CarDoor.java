package car.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "car_doors")
public class CarDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DoorState doorState;
    @Enumerated(EnumType.STRING)
    private WindowState windowState;

    public CarDoor() {
        this.doorState = DoorState.CLOSED;
        this.windowState = WindowState.CLOSED;
    }

    public void openDoor() {
        doorState = DoorState.OPENED;
    }

    public void closeDoor() {
        doorState = DoorState.CLOSED;
    }

    public void changeDoorState() {
        doorState = (doorState == DoorState.CLOSED) ? DoorState.OPENED : DoorState.CLOSED;
    }

    public void openWindow() {
        windowState = WindowState.OPENED;
    }

    public void closeWindow() {
        windowState = WindowState.CLOSED;
    }

    public void changeWindowState() {
        windowState = (windowState == WindowState.CLOSED) ? WindowState.OPENED : WindowState.CLOSED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoorState getDoorState() {
        return doorState;
    }

    public void setDoorState(DoorState doorState) {
        this.doorState = doorState;
    }

    public WindowState getWindowState() {
        return windowState;
    }

    public void setWindowState(WindowState windowState) {
        this.windowState = windowState;
    }

    public enum DoorState {
        CLOSED, OPENED
    }

    public enum WindowState {
        CLOSED, OPENED
    }

    @Override
    public String toString() {
        return "CarDoor{"
                + "doorState = " + doorState
                + ", windowState = " + windowState
                + '}';
    }
}
