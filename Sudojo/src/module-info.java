

module Sudojo {
	requires java.sql;
	requires gson;
	opens sudojo.client.model.net;
	opens sudojo.client.model.gestioneAffiliato;
	opens sudojo.client.model.budopass;
	opens sudojo.client.model.documento;
	opens sudojo.client.model.gestioneCalendario;
}