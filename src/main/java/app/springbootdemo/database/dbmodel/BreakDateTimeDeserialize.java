package app.springbootdemo.database.dbmodel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BreakDateTimeDeserialize extends JsonDeserializer<String> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");

    @Override
    public String deserialize(JsonParser paramJsonParser,
                              DeserializationContext paramDeserializationContext)
            throws IOException, JsonProcessingException {
        String str = paramJsonParser.getText().trim();
        String currentTime = null;
        try {
            currentTime = dateFormat.format(dateFormat.parse(str));
        } catch (Exception e) {
            // Handle exception here
        }
        return currentTime;
    }
}