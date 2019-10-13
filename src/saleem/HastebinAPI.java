package saleem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

public class HastebinAPI {

	private final Gson GSON = new Gson();

	public String upload(String text) throws IOException {
		URL url = new URL("https://hastebin.com/documents");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setRequestProperty("User-Agent", "HastebinAPI/1.0 (http://hastebin.com/)");
		con.setRequestProperty("Content-Type", "text/plain");

		try (OutputStream out = con.getOutputStream()) {
			out.write(text.getBytes());
		}

		Response r;
		try (InputStream in = con.getInputStream()) {
			r = GSON.fromJson(IOUtils.toString(in), Response.class);
		}
		String linkUrl = "https://hastebin.com/" + r.key;

		return linkUrl;
	}

	private class Response {
		private String key;
	}
}