package sample.bean;

/**
 * Created by Julia on 01.02.2016.
 */
public class Result {

    private String resultDescription;
    private int resultScheduledTime;
    private int resultSpentTime; // minutes
    private String resultStatus;

    public Result(String description, int scheduledTime, int spentTime, String status) {
        this.resultDescription = description;
        this.resultScheduledTime = scheduledTime;
        this.resultSpentTime = spentTime;
        this.resultStatus = status;
    }

    public Result() {
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public int getResultScheduledTime() {
        return resultScheduledTime;
    }

    public void setResultScheduledTime(int resultScheduledTime) {
        this.resultScheduledTime = resultScheduledTime;
    }

    public int getResultSpentTime() {
        return resultSpentTime;
    }

    public void setResultSpentTime(int resultSpentTime) {
        this.resultSpentTime = resultSpentTime;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    @Override
    public String toString() {
        return resultDescription + " - " + resultStatus + " ( " + resultScheduledTime + "/" + resultSpentTime + " min.)";
    }
}
