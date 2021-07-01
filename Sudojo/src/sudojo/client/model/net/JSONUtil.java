package sudojo.client.model.net;

import com.google.gson.Gson;

public class JSONUtil implements JSONDeserializable, JSONSerializable{
	
	private Gson g;
	
	public JSONUtil() {
		super();
		this.g = new Gson();
	}

	@Override
	public String jsonSerialize(Request richiesta) {
		return g.toJson(richiesta);
	}

	@Override
	public Response jsonDeserialize(String json) {
		return g.fromJson(json, Response.class);
	}

}
