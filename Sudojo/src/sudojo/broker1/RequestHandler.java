package sudojo.broker1;

import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("deprecation")
public class RequestHandler extends HttpServlet implements SingleThreadModel,HTTPSBrokerInterface{

	static JSONUtil j = new JSONUtil();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		res.setContentType("application/json");
		handleRequest(req,res);
	}

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse res) {
		String richiesta = req.getParameter("richiesta");
		RequestInterface r = j.jsonDeserialize(richiesta);
	}
	


}