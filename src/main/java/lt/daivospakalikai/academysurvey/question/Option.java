package lt.daivospakalikai.academysurvey.question;

import java.util.List;
import java.util.Objects;

class Option {

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

  public Option() {
  }

  public Option(String key, String controlType, String type, String label, String value, Boolean required,
      Boolean showExtraField, String extraField, Integer order,
      List<Options> options) {
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
    Option option = (Option) o;
    return Objects.equals(key, option.key) &&
        Objects.equals(controlType, option.controlType) &&
        Objects.equals(type, option.type) &&
        Objects.equals(label, option.label) &&
        Objects.equals(value, option.value) &&
        Objects.equals(required, option.required) &&
        Objects.equals(showExtraField, option.showExtraField) &&
        Objects.equals(extraField, option.extraField) &&
        Objects.equals(order, option.order) &&
        Objects.equals(options, option.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, controlType, type, label, value, required, showExtraField, extraField, order, options);
  }

  @Override
  public String toString() {
    return "Option{" +
        "key='" + key + '\'' +
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
