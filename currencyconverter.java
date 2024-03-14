// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import org.json.JSONObject;

// public class currencyconverter {
//     private static final String API_KEY = "YOUR_API_KEY_HERE";

//     public static void main(String[] args) {
        
//         String baseCurrency = "USD"; 
//         String targetCurrency = "EUR"; 

        
//         double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        
//         double amount = 100; 

        
//         double convertedAmount = amount * exchangeRate;

        
//         System.out.printf("%.2f %s is equivalent to %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
//     }

//     public static double getExchangeRate(String baseCurrency, String targetCurrency) {
//         double exchangeRate = 0.0;
//         try {
//             URL url = new URL("https://api.currencyscoop.com/v1/latest?api_key=" + API_KEY + "&base=" + baseCurrency);
//             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//             connection.setRequestMethod("GET");

//             BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//             StringBuilder response = new StringBuilder();
//             String line;

//             while ((line = reader.readLine()) != null) {
//                 response.append(line);
//             }
//             reader.close();

//             JSONObject jsonObject = new JSONObject(response.toString());
//             JSONObject rates = jsonObject.getJSONObject("response").getJSONObject("rates");
//             exchangeRate = rates.getDouble(targetCurrency);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return exchangeRate;
//     }
// }