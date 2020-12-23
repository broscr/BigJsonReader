import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DatabaseHelper {

    private Firestore db;

    public DatabaseHelper() {

        try {
            String path = "D:\\PrivateProject\\DbJsonEx\\src\\main\\resources\\service-acc.json";
            FileInputStream serviceAccount = new FileInputStream(path);

            GoogleCredentials googleCredentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(googleCredentials)
                    .build();

            FirebaseApp.initializeApp(options);

            db = FirestoreClient.getFirestore();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getDataSize() {

        ApiFuture<QuerySnapshot> writeResultApiFuture = db.collection("contacts").get();
        try {
            System.out.println(writeResultApiFuture.get().getDocuments().size());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void setData(List<ContactList> contactList) {

        WriteBatch batch = db.batch();

        for (ContactList cs : contactList) {
            Contact contact = new Contact();
            contact.setAuthor_id(cs.getAuthor_id());
            contact.setPhone_number(cs.getPhone_number());
            contact.setPhone_name(cs.getDisplay_name());
            DocumentReference dcRef = db.collection("contacts").document();

            batch.set(dcRef, contact);
        }

        ApiFuture<List<WriteResult>> future = batch.commit();
        try {
            System.out.println("Sizes: "+future.get().size());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
