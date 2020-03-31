package lt.daivospakalikai.academysurvey.filterandsort;

import java.util.List;

public class SubmissionFilter {

  private List<String> filterList;
  private List<String> sortList;

  public SubmissionFilter(List<String> filterList, List<String> sortList) {
    this.filterList = filterList;
    this.sortList = sortList;
  }

  public List<String> getFilterList() {
    return filterList;
  }

  public List<String> getSortList() {
    return sortList;
  }
}
