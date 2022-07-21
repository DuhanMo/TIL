package sample;

public class Study {

    private StudyStatus status;

    private int limit;

    public Study() {
        this.status = StudyStatus.DRAFT;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalStateException("limit은 0보다 커야한다.");
        }
        this.limit = limit;
        this.status = StudyStatus.DRAFT;
    }

    public StudyStatus getStatue() {
        return this.status;
    }

    public int getLimit() {
        return limit;
    }
}
