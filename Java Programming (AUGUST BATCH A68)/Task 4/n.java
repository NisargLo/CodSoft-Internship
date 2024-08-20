import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Set the API URL with your API key
        String urlStr = "https://v6.exchangerate-api.com/v6/apikey/latest/USD";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert response to JSON
            JsonParser jp = new JsonParser();
            JsonObject jsonobj = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();

            // Access exchange rates
            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
            double usdToEurRate = conversionRates.get("EUR").getAsDouble();
            double usdToGbpRate = conversionRates.get("GBP").getAsDouble();

            System.out.println("USD to EUR rate: " + usdToEurRate);
            System.out.println("USD to GBP rate: " + usdToGbpRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
