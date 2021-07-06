package sudojo.client.viewmodel.budopass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import sudojo.client.model.budopass.Competizione;
import sudojo.client.model.budopass.Grado;
import sudojo.client.model.budopass.Posizione;
import sudojo.client.model.budopass.Seminario;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class AggiornaBudopassViewModel extends AbstractViewModel implements AggiornaBudopassViewModelInterface{

	private Collection<Observer<Subject>> observers;
	
	public AggiornaBudopassViewModel() {
		this.observers = new ArrayList<Observer<Subject>>();
	}

	@Override
	public boolean detach(Observer<Subject> obj) {
		return this.observers.remove(obj);
	}

	@Override
	public boolean attach(Observer<Subject> obj) {
		return this.observers.add(obj);
	}

	@Override
	public void notifyObserver() {
		for(Observer<Subject> o : this.observers)
			o.onChange(this);
		
	}

	@Override
	public void aggiornaBudopass(String user, Seminario s) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
//		Argomento luogo = new Argomento("luogo", s.getLuogo());
//		args.add(luogo);
//		Argomento tenutario = new Argomento("tenutario", s.getTenutario());
//		args.add(tenutario);
//		Argomento data = new Argomento("data", s.getData().toString());
//		args.add(data);
		Gson g = new Gson();
		Argomento seminario = new Argomento("seminario", g.toJson(s));
		args.add(seminario);
		this.request(new Request(Comando.AGGIORNA_BUDOPASS_SEMINARIO, args));
	}

	@Override
	public void aggiornaBudopass(String user, Grado g) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
		Gson gson = new Gson();
		Argomento grado = new Argomento("grado", gson.toJson(g));
		args.add(grado);


		this.request(new Request(Comando.AGGIORNA_BUDOPASS_GRADO, args));
		
	}

	@Override
	public void aggiornaBudopass(String user, Competizione c, Posizione p) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
//		Argomento categoria = new Argomento("categoria", c.getCategoria());
//		args.add(categoria);
//		Argomento disciplina = new Argomento("disciplina", c.getDisciplina());
//		args.add(disciplina);
//		Argomento nome = new Argomento("nome", c.getNome());
//		args.add(nome);
//		Argomento d = new Argomento("data", c.getData().toString());
//		args.add(d);
//		Argomento pp = new Argomento("posizione", p.toString());
//		args.add(pp);
		Gson g = new Gson();
		Argomento competizione = new Argomento("competizione", g.toJson(c));
		args.add(competizione);
		Argomento posizione = new Argomento("posizione", g.toJson(p));
		args.add(posizione);
		this.request(new Request(Comando.AGGIORNA_BUDOPASS_COMPETIZIONE, args));
		
	}
	


	

}
