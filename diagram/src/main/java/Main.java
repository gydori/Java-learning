import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        //----------------------------------------------------------------------
/*        Gson gson = new Gson();

        try (Reader reader = new FileReader("person.json")) {

            // Convert JSON File to Java Object
            Person p = gson.fromJson(reader, Person.class);

            // print staff
            System.out.println(p);

            FileWriter file = new FileWriter("personOut.json");
            file.write(p.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //----------------------------------------------------------------------------
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("person.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            Person p = objectMapper.readValue(jsonData, Person.class);
            System.out.println(p);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("personOut2.json"), p);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
