package app.springbootdemo.database.dbmodel;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Date deserialize(JsonParser paramJsonParser,
                            DeserializationContext paramDeserializationContext)
            throws IOException, JsonProcessingException {
        String str = paramJsonParser.getText().trim();
        try {
            return  dateFormat.parse(str);
        } catch (Exception e) {
            // Handle exception here
        }
        return paramDeserializationContext.parseDate(str);
    }
}