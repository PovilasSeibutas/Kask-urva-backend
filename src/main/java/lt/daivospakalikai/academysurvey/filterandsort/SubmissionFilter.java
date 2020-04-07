package lt.daivospakalikai.academysurvey.filterandsort;

import java.util.List;

public class SubmissionFilter {

  private List<String> filterList;
  private List<String> sortList;
  private AnswerForm answerForm;

  public SubmissionFilter(List<String> filterList, List<String> sortList,
      AnswerForm answerForm) {
    this.filterList = filterList;
    this.sortList = sortList;
    this.answerForm = answerForm;
  }

  public List<String> getFilterList() {
    return filterList;
  }

  public List<String> getSortList() {
    return sortList;
  }

  public AnswerForm getAnswerForm() {
    return answerForm;
  }
}
