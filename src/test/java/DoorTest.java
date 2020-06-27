import car.model.CarDoor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DoorTest {
    private static CarDoor door;

    @BeforeClass
    public static void before() {
        door = new CarDoor();
    }

    @Test
    public void openDoorTest() {
        door.setDoorState(CarDoor.DoorState.CLOSED);
        door.openDoor();
        Assert.assertEquals(CarDoor.DoorState.OPEN, door.getDoorState());
    }

    @Test
    public void closeDoorTest() {
        door.setDoorState(CarDoor.DoorState.OPEN);
        door.closeDoor();
        Assert.assertEquals(CarDoor.DoorState.CLOSED, door.getDoorState());
    }

    @Test
    public void changeDoorStateOpenTest() {
        door.setDoorState(CarDoor.DoorState.CLOSED);
        door.changeDoorState();
        Assert.assertEquals(CarDoor.DoorState.OPEN, door.getDoorState());
    }

    @Test
    public void changeDoorStateClosedTest() {
        door.setDoorState(CarDoor.DoorState.OPEN);
        door.changeDoorState();
        Assert.assertEquals(CarDoor.DoorState.CLOSED, door.getDoorState());
    }

    @Test
    public void openWindowTest() {
        door.setWindowState(CarDoor.WindowState.CLOSED);
        door.openWindow();
        Assert.assertEquals(CarDoor.WindowState.OPEN, door.getWindowState());
    }

    @Test
    public void closeWindowTest() {
        door.setWindowState(CarDoor.WindowState.OPEN);
        door.closeWindow();
        Assert.assertEquals(CarDoor.WindowState.CLOSED, door.getWindowState());
    }

    @Test
    public void changeWindowStateOpenTest() {
        door.setWindowState(CarDoor.WindowState.CLOSED);
        door.changeWindowState();
        Assert.assertEquals(CarDoor.WindowState.OPEN, door.getWindowState());
    }

    @Test
    public void changeWindowStateClosedTest() {
        door.setWindowState(CarDoor.WindowState.OPEN);
        door.changeWindowState();
        Assert.assertEquals(CarDoor.WindowState.CLOSED, door.getWindowState());
    }
}
