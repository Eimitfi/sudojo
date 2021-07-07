package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeMaestroController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void show_budopass(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraBudopass.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void show_ricevuta(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraVisualizzaPagamento.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void show_calendar(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraVisualizzaCalendario.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void show_avvisi(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraLeggiAvvisi.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void send_documenti(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraInviaDocumenti.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void compila_scheda(ActionEvent event) throws IOException {
		root = (Pane) FXMLLoader.load(getClass().getResource("MascheraCompilaSchedaValutazione.fxml"));
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
