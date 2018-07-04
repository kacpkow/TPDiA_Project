package Data;

import java.time.LocalDateTime;

/**
 * Created by kacper on 2018-07-04.
 */
public class NozzleMeasure {
    private LocalDateTime datetime;
    private Integer gunId;
    private Integer tankId;
    private Double literCounter;
    private Double totalCounter;
    private Integer status;

    public NozzleMeasure() {
    }

    public NozzleMeasure(LocalDateTime datetime, Integer gunId, Integer tankId, Double literCounter, Double totalCounter, Integer status) {
        this.datetime = datetime;
        this.gunId = gunId;
        this.tankId = tankId;
        this.literCounter = literCounter;
        this.totalCounter = totalCounter;
        this.status = status;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Integer getGunId() {
        return gunId;
    }

    public void setGunId(Integer gunId) {
        this.gunId = gunId;
    }

    public Integer getTankId() {
        return tankId;
    }

    public void setTankId(Integer tankId) {
        this.tankId = tankId;
    }

    public Double getLiterCounter() {
        return literCounter;
    }

    public void setLiterCounter(Double literCounter) {
        this.literCounter = literCounter;
    }

    public Double getTotalCounter() {
        return totalCounter;
    }

    public void setTotalCounter(Double totalCounter) {
        this.totalCounter = totalCounter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
