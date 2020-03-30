package lt.daivospakalikai.academysurvey.question;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OptionToJsonConverter implements AttributeConverter<Option, String> {

  ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Option option) {
    String json = "";
    try {
      json = objectMapper.writeValueAsString(option);
    } catch (JsonProcessingException jpe) {
      // Handle exception
    }
    return json;
  }

  @Override
  public Option convertToEntityAttribute(String optionAsJson) {
    Option option = null;
    try {
      option = objectMapper.readValue(optionAsJson, Option.class);
    } catch (JsonParseException e) {
      // HandleException
    } catch (JsonMappingException e) {
      // HandleException
    } catch (IOException e) {
      // HandleException
    }
    return option;
  }
}
