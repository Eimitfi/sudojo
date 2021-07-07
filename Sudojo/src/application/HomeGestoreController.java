package application;

import java.io.IOException; 

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeGestoreController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void show_log(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("ViewLog.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void show_ricevuta(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("SceltaIscrittoGeneraRicevuteGestore.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void show_documenti(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraVisualizzaDocumenti.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void send_avviso(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraNotificaAvvisi.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void gestione_calendario(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraGestioneCalendario.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void gestione_affiliato(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraGestioneAffiliato.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void do_logout(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("ViewLogin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
