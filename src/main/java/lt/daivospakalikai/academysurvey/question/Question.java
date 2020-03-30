package lt.daivospakalikai.academysurvey.question;

import java.util.List;
import java.util.Objects;

public class Question {

  private Integer id;
  private String question;
  private String key;
  private String controlType;
  private String type;
  private String label;
  private String value;
  private Boolean required;
  private Boolean showExtraField;
  private String extraField;
  private Integer order;
  private List<Options> options;

  public Question() {
  }

  public Question(Integer id, String question, String key, String controlType, String type, String label,
      String value, Boolean required, Boolean showExtraField, String extraField, Integer order,
      List<Options> options) {
    this.id = id;
    this.question = question;
    this.key = key;
    this.controlType = controlType;
    this.type = type;
    this.label = label;
    this.value = value;
    this.required = required;
    this.showExtraField = showExtraField;
    this.extraField = extraField;
    this.order = order;
    this.options = options;
  }

  public Question(Integer id, String question, Option option) {
    this.id = id;
    this.question = question;
    this.key = option.getKey();
    this.controlType = option.getControlType();
    this.type = option.getType();
    this.label = option.getLabel();
    this.value = option.getValue();
    this.required = option.getRequired();
    this.showExtraField = option.getShowExtraField();
    this.extraField = option.getExtraField();
    this.order = option.getOrder();
    this.options = option.getOptions();
  }

  public String getQuestion() {
    return question;
  }

  public Option createOption() {
    return new Option(this.key, this.controlType, this.type, this.label, this.value, this.required,
        this.showExtraField, this.extraField, this.order, this.options);
  }

  public Integer getId() {
    return id;
  }

  public String getKey() {
    return key;
  }

  public String getControlType() {
    return controlType;
  }

  public String getType() {
    return type;
  }

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }

  public Boolean getRequired() {
    return required;
  }

  public Boolean getShowExtraField() {
    return showExtraField;
  }

  public String getExtraField() {
    return extraField;
  }

  public Integer getOrder() {
    return order;
  }

  public List<Options> getOptions() {
    return options;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question1 = (Question) o;
    return Objects.equals(id, question1.id) &&
        Objects.equals(question, question1.question) &&
        Objects.equals(key, question1.key) &&
        Objects.equals(controlType, question1.controlType) &&
        Objects.equals(type, question1.type) &&
        Objects.equals(label, question1.label) &&
        Objects.equals(value, question1.value) &&
        Objects.equals(required, question1.required) &&
        Objects.equals(showExtraField, question1.showExtraField) &&
        Objects.equals(extraField, question1.extraField) &&
        Objects.equals(order, question1.order) &&
        Objects.equals(options, question1.options);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, question, key, controlType, type, label, value, required, showExtraField, extraField, order, options);
  }

  @Override
  public String toString() {
    return "Question{" +
        "id=" + id +
        ", question='" + question + '\'' +
        ", key='" + key + '\'' +
        ", controlType='" + controlType + '\'' +
        ", type='" + type + '\'' +
        ", label='" + label + '\'' +
        ", value='" + value + '\'' +
        ", required=" + required +
        ", showExtraField=" + showExtraField +
        ", extraField='" + extraField + '\'' +
        ", order=" + order +
        ", options=" + options +
        '}';
  }
}
