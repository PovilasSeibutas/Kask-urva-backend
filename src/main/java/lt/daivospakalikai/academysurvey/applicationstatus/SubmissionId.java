package lt.daivospakalikai.academysurvey.applicationstatus;

public class SubmissionId {
    private Integer submissionId;

    public SubmissionId() {
    }

    public SubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    @Override
    public String toString() {
        return "SubmissionId{" +
                "submissionId=" + submissionId +
                '}';
    }
}
