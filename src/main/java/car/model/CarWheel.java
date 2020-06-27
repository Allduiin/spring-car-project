package car.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "car_wheels")
public class CarWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float tireState;

    public CarWheel() {
        this.tireState = 1f;
    }

    public void changeTire() {
        tireState = 1f;
    }

    public void eraseTireByPercent(int percent) {
        tireState -= (float) percent / 100;
    }

    public float getTireState() {
        return tireState;
    }

    public void setTireState(float tireState) {
        this.tireState = tireState;
    }

    @Override
    public String toString() {
        return "CarWheel{"
                + "tireState = " + tireState
                + '}';
    }
}
