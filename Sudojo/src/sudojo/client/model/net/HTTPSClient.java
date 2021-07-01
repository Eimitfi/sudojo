package sudojo.client.model.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HTTPSClient implements HTTPSClientInterface {
	
	private URL brokerURL;
	
	public URL getBrokerURL() {
		return brokerURL;
	}

	public void setBrokerURL(String brokerURL) throws MalformedURLException {
		this.brokerURL = new URL(brokerURL);
	}


	public HTTPSClient(String brokerURL) throws MalformedURLException {
		super();
		this.brokerURL = new URL(brokerURL);
	}



	@Override
	public ResponseInterface richiedi(RequestInterface richiesta) throws IOException {
		JSONUtil util = new JSONUtil();
		String req = util.jsonSerialize(richiesta);
		
		HttpsURLConnection con = (HttpsURLConnection) this.brokerURL.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		
		req = "richiesta=" + req;
		
		try(OutputStream os = con.getOutputStream()) {
		    byte[] input = req.getBytes("utf-8");
		    os.write(input, 0, input.length);			
		}
		
		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(con.getInputStream(), "utf-8"))) {
				    StringBuilder response = new StringBuilder();
				    String responseLine = null;
				    while ((responseLine = br.readLine()) != null) {
				        response.append(responseLine.trim());
				    }
				    System.out.println(response.toString());//debug purpouse
				    return util.jsonDeserialize(response.toString());
				}
	}

}
