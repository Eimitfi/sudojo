package sudojo.client.model.net;

import java.io.IOException;

public interface HTTPSClientInterface {
	public ResponseInterface richiedi(RequestInterface richiesta) throws IOException;
}
