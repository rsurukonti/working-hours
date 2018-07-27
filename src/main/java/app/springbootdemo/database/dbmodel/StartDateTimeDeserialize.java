package app.springbootdemo.database.dbmodel;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StartDateTimeDeserialize extends JsonDeserializer<String> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    //SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public String deserialize(JsonParser paramJsonParser,
                              DeserializationContext paramDeserializationContext)
            throws IOException, JsonProcessingException {
        String str = paramJsonParser.getText().trim();
        String dateTime = null;
        try {
            dateTime = dateFormat.format( dateFormat.parse(str));
        } catch (Exception e) {
            // Handle exception here
        }
        return dateTime;
    }
}