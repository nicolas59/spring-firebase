package fr.epsi.mspr.gosecurity;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import fr.epsi.mspr.gosecurity.dao.FirebaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class GoSecurityApplication implements CommandLineRunner {

	@Autowired
	private FirebaseDao dao;

	public static void main(String[] args) {
		SpringApplication.run(GoSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Execution en cours -----");

		List<QueryDocumentSnapshot> documents = dao.findAll();
	    for (QueryDocumentSnapshot document : documents) {

            System.out.println("User: " + document.getId());
            System.out.println("Firstname: " + document.getString("firstname"));
            System.out.println("Lastname: " + document.getString("lastname"));
        }
	}
}
