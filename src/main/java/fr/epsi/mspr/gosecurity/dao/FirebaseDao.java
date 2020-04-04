package fr.epsi.mspr.gosecurity.dao;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import fr.epsi.mspr.gosecurity.GoSecurityApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class FirebaseDao {

    private  Firestore db;

    public FirebaseDao(){
        InputStream serviceAccount = GoSecurityApplication.class.getResourceAsStream("/serviceAccountKey.json");

        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://b3-reseau.firebaseio.com")
                    .build();

            FirebaseApp f = FirebaseApp.initializeApp(options);
        }catch(IOException e){

        }

        this.db = FirestoreClient.getFirestore();

    }


    public List<QueryDocumentSnapshot> findAll() throws Exception{
        ApiFuture<QuerySnapshot> query = db.collection("agents").get();


        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        return documents;
    }

    public QueryDocumentSnapshot findAgentById(String id){
        return null;
    }


    public void addAgent(QueryDocumentSnapshot document){
        // appel de firestore pour ajouter un agent
    }



}
