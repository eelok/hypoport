package hypoport;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HypoportRepository {

    public List<Price> getPriceList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/hypoport.json");
        Hypoport hypoport = objectMapper.readValue(file, Hypoport.class);
        return hypoport.getPrices();
    }
}
