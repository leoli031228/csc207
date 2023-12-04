package use_case.progessTracker;

public class ProgressTrackerInputData {
    final private String title;
    final private String current_status;

    public ProgressTrackerInputData(String title, String current_status) {
        this.title = title;
        this.current_status = current_status;
    }
}
