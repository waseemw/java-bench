import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class Http {

	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	static OkHttpClient client = new OkHttpClient();

	static void get(String url) {
		Request request = new Request.Builder()
			.url(url)
			.get()
			.build();
		try (Response response = client.newCall(request).execute()) {
			Objects.requireNonNull(response.body()).string();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}