package sample.bean;

/**
 * Created by Julia on 01.02.2016.
 */
public class ResultAdapter extends Result {

    private Task task;
    private int resultSpentTime;

    public ResultAdapter(Task task) {
        this.task = task;
    }

    public String getResultDescription() {
        return task.getDescription();
    }

    public void setResultDescription(String resultDescription) {
        task.setDescription(resultDescription);
    }

    public int getResultScheduledTime() {
        return task.getScheduledTime();
    }

    public void setResultScheduledTime(int resultScheduledTime) {
        task.setScheduledTime(resultScheduledTime);
    }

    public int getResultSpentTime() {
        return this.resultSpentTime;
    }

    public void setResultSpentTime(int resultSpentTime) {
        this.resultSpentTime = resultSpentTime;
    }

    public String getResultStatus() {
        return task.getStatus();
    }

    public void setResultStatus(String resultStatus) {
        task.setStatus(resultStatus);
    }

    @Override
    public String toString() {
        return task.getDescription() + " - " + task.getStatus() + " ( " + task.getScheduledTime() + "/" + resultSpentTime + " min.)";
    }

}
