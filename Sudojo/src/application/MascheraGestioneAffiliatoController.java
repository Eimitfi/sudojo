package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MascheraGestioneAffiliatoController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void aggiungi_affiliato(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("AggiuntaAffiliato.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void modifica_affiliato(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("ModificaAffiliato.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void cancella_affiliato(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("CancellazioneAffiliato.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void do_back(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("HomeGestore.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}