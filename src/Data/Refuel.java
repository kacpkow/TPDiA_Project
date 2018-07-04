package Data;

import java.time.LocalDateTime;

/**
 * Created by kacper on 2018-07-04.
 */
public class Refuel {
    private LocalDateTime datetime;
    private Integer tankId;
    private Double fuelVolume;
    private Double fillingSpeed;

    public Refuel() {
    }

    public Refuel(LocalDateTime datetime, Integer tankId, Double fuelVolume, Double fillingSpeed) {
        this.datetime = datetime;
        this.tankId = tankId;
        this.fuelVolume = fuelVolume;
        this.fillingSpeed = fillingSpeed;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Integer getTankId() {
        return tankId;
    }

    public void setTankId(Integer tankId) {
        this.tankId = tankId;
    }

    public Double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(Double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public Double getFillingSpeed() {
        return fillingSpeed;
    }

    public void setFillingSpeed(Double fillingSpeed) {
        this.fillingSpeed = fillingSpeed;
    }
}
