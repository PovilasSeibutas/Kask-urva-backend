package lt.daivospakalikai.academysurvey.filterandsort;

import java.util.List;

public class SubmissionFilter {

  private List<String> sortList;
  private AnswerForm answerForm;

  public SubmissionFilter(List<String> sortList, AnswerForm answerForm) {
    this.sortList = sortList;
    this.answerForm = answerForm;
  }

  public List<String> getSortList() {
    return sortList;
  }

  public AnswerForm getAnswerForm() {
    return answerForm;
  }
}
