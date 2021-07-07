

module Sudojo {
	requires java.sql;
	requires gson;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	opens sudojo.client.model.net;
	opens sudojo.client.model.gestioneAffiliato;
	opens sudojo.client.model.budopass;
	opens sudojo.client.model.documento;
	opens sudojo.client.model.gestioneCalendario;
}