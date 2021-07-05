package sudojo.broker1;

import com.google.gson.Gson;

public class JSONUtil implements JSONDeserializable, JSONSerializable{
	
	private Gson g;
	
	public JSONUtil() {
		super();
		this.g = new Gson();
	}

	

	@Override
	public RequestInterface jsonDeserialize(String json) {
		return g.fromJson(json, Request.class);
	}



	@Override
	public String jsonSerialize(ResponseInterface res) {
		return g.toJson(res);		
	}



}
