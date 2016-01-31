package sample.bean;

/**
 * Created by Julia on 01.02.2016.
 */
public class Task {

    private String description;
    private int scheduledTime;
    private String status;


    public Task(String description, int scheduledTime, String status) {
        this.description = description;
        this.scheduledTime = scheduledTime;
        this.status = status;
    }

    public Task() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(int scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return description + " - " + status + " ( " + scheduledTime + " min.)";
    }
}
