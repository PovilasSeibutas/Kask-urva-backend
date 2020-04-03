package lt.daivospakalikai.academysurvey.admincomment;

public class AdminCommentResponse {

    private Integer id;
    private Integer submissionId;
    private Integer adminId;
    private String comment;
    private Long timeStamp;
    private String name;
    private String surname;

    public AdminCommentResponse() {
    }

    public AdminCommentResponse(Integer id, Integer submissionId, Integer adminId, String comment, Long timeStamp, String name, String surname) {
        this.id = id;
        this.submissionId = submissionId;
        this.adminId = adminId;
        this.comment = comment;
        this.timeStamp = timeStamp;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}


