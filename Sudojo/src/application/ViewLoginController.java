package application;

import java.io.IOException; 

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

public class ViewLoginController {
	@FXML
	private TextField user_field;
	@FXML
	private PasswordField passwd_field;
	@FXML
	private Label err_msg;

	private Stage stage;
	private Scene scene;
	private Parent root;

	private String usernameA = "allievo";
	private String usernameM = "maestro";
	private String usernameD = "direttore";
	private String usernameG = "gestore";
	private String password = "pwd";

	public void do_login(ActionEvent event) throws IOException {
		String user_in = user_field.getText();
		String passwd_in = passwd_field.getText();

		if (passwd_in.compareTo(password) == 0) {
			if (user_in.compareTo(usernameA) == 0) {
				root = (Pane) FXMLLoader.load(getClass().getResource("HomeAllievo.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else if (user_in.compareTo(usernameD) == 0) {
				root = (Pane) FXMLLoader.load(getClass().getResource("HomeDirettore.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else if (user_in.compareTo(usernameG) == 0) {
				root = (Pane) FXMLLoader.load(getClass().getResource("HomeGestore.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else if (user_in.compareTo(usernameM) == 0) {
				root = (Pane) FXMLLoader.load(getClass().getResource("HomeMaestro.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else {
				err_msg.setOpacity(1);
			}
		} else {
			err_msg.setOpacity(1);
		}
	}
}