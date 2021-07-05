package sudojo.broker1;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HTTPSBrokerInterface {
	public void handleRequest(HttpServletRequest req,HttpServletResponse res) throws IOException;

}
