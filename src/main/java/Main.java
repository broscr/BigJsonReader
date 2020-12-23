import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        setData();
    }

    public static void setData() {
        try {
            String path = "D:\\PrivateProject\\DbJsonEx\\src\\main\\resources\\test.json";
            DatabaseHelper databaseHelper = new DatabaseHelper();

            InputStream inputStream = new FileInputStream(path);
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            List<ContactList> contactsList = new ArrayList<>();

            reader.beginObject();
            int resSize = 1; //5406578
            while (reader.hasNext()) {
                String name = reader.nextName();
                ContactList response = gson.fromJson(reader, ContactList.class);

                contactsList.add(response);
                if (contactsList.size() == 450) {
                    databaseHelper.setData(contactsList);
                    contactsList = new ArrayList<>();
                }
                System.out.println("ColSize: " + resSize);
                resSize++;
            }
            reader.endObject();
            reader.close();
            System.out.println("End Size: " + resSize);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
