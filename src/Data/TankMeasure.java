package Data;

import java.time.LocalDateTime;

/**
 * Created by kacper on 2018-07-04.
 */
public class TankMeasure {
    private LocalDateTime datetime;
    private Integer tankId;
    private Double fuelVolume;
    private Integer fuelTemperature;

    public TankMeasure() {
    }

    public TankMeasure(LocalDateTime datetime, Integer tankId, Double fuelVolume, Integer fuelTemperature) {
        this.datetime = datetime;
        this.tankId = tankId;
        this.fuelVolume = fuelVolume;
        this.fuelTemperature = fuelTemperature;
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

    public Integer getFuelTemperature() {
        return fuelTemperature;
    }

    public void setFuelTemperature(Integer fuelTemperature) {
        this.fuelTemperature = fuelTemperature;
    }
}
