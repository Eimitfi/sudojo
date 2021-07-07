package sudojo.client.model.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


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
		//[DAN]: aggiunto ResponseInterface e RequestInterface
		JSONUtil util = new JSONUtil();
		String req = util.jsonSerialize(richiesta);
		System.out.println("richiesta");
		HttpURLConnection con = (HttpURLConnection) this.brokerURL.openConnection();
		con.setRequestMethod("POST");
		//con.setRequestProperty("Content-Type", "application/json; utf-8");
		//con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		
	
		con.connect();
		
		
		String reqq = "richiesta=" + req;
		System.out.println("\n httpsclient richiesta: "+reqq);
		try(OutputStream os = con.getOutputStream()) {
			DataOutputStream dos = new DataOutputStream(os);
		    byte[] input = reqq.getBytes("utf-8");
		    //os.write(input, 0, input.length);		
		    dos.writeBytes(reqq);
		    dos.flush();
		    dos.close();
		    
		}
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(con.getInputStream(), "utf-8"));
//		String response = br.readLine();
//		br.close();
//		con.disconnect();
//		return new Response(Comando.AGGIORNA_BUDOPASS_COMPETIZIONE, "ciao", "ciao", Stato.OK);
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
