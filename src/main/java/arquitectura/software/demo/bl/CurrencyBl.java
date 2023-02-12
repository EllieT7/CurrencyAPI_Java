package arquitectura.software.demo.bl;

import org.springframework.stereotype.Service;

import arquitectura.software.demo.dto.RequestDto;
import arquitectura.software.demo.dto.ResponseDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class CurrencyBl {
    public ResponseDto convert(RequestDto requestDto) {
        System.out.println("Convert: " + requestDto);
        Response response = invokeApi("https://api.apilayer.com/exchangerates_data/convert?to=usd&from=bob&amount=1000");
        return null;
    }

    private Response invokeApi(String endpoint) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
        .url(endpoint)
        .addHeader("apikey", "DKtvGE5j3a4vFH9qUICssZzdVdKJIla9")
        .method("GET", null)
        .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al invocar la API");
            return null;
        }
        
    }
}