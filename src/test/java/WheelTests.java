import car.model.CarWheel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WheelTests {
    private static CarWheel carWheel;

    @BeforeClass
    public static void before() {
        carWheel = new CarWheel();
    }

    @Test
    public void startTireStateTest() {
        carWheel = new CarWheel();
        Assert.assertEquals("New wheel must have 1 tireState", 1, carWheel.getTireState(), 0);
    }

    @Test
    public void eraseTireTest() {
        int percent = 50;
        carWheel.eraseTireByPercent(percent);
        Assert.assertEquals("Expected: " + (1 - (float) percent / 100),
                1 - (float) percent / 100, carWheel.getTireState(), 0f);
    }

    @Test
    public void changeTireTest() {
        carWheel.setTireState(0f);
        carWheel.changeTire();
        Assert.assertEquals("Expected tireState = " + 1, 1, carWheel.getTireState(), 0);
    }
}
