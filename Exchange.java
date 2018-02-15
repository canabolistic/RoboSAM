package api.roboSAM;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class H1 {

	private static final String USER_AGENT = "Mozilla/5.0";

	private static final String GET_URL = "https://yobit.net/api/3/info";

	public static void main(String[] args) throws IOException {

		sendGET();
	}

	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String strTicker = response.toString();
			String[] splitTicker = strTicker.split(":|\\,");

			String strHigh = splitTicker[3];
			
	
			// print result
			//System.out.println(response.toString());
			System.out.println(""+strHigh.toString().substring(2));

		} else {
			System.out.println("GET request not worked");
			
		}
	}

}