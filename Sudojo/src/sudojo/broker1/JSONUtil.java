package sudojo.broker1;

import com.google.gson.Gson;

public class JSONUtil implements JSONDeserializable, JSONSerializable{
	
	private Gson g;
	
	public JSONUtil() {
		super();
		this.g = new Gson();
	}

	@Override
	public String jsonSerialize(RequestInterface richiesta) {
		return g.toJson(richiesta);
	}

	@Override
	public ResponseInterface jsonDeserialize(String json) {
		return g.fromJson(json, Response.class);
	}

}
