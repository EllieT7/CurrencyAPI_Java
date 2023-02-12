package arquitectura.software.demo.bl;

import java.math.BigDecimal;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import arquitectura.software.demo.dto.RequestDto;
import arquitectura.software.demo.dto.ResponseDto;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class CurrencyBl {
    Logger LOGGER = Logger.getLogger(CurrencyBl.class.getName());
    /**
     * Método que convierte una moneda a otra
     * @param requestDto
     * @return
     */
    public ResponseDto convert(RequestDto requestDto) {
        if(requestDto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            LOGGER.log(Level.WARNING,"No se puede convertir una cantidad menor o igual a 0");
            return null;
            //TODO: Retornar una excepción
        }
        LOGGER.info("Convirtiendo " + requestDto.getAmount() + " " + requestDto.getFrom() + " a " + requestDto.getTo());
        Response response = invokeApi("https://api.apilayer.com/exchangerates_data/convert?to="+requestDto.getTo()+"&from="+requestDto.getFrom()+"&amount="+requestDto.getAmount());
        
        if(response == null) {
            LOGGER.info("Error al invocar la API");
            return null;
        }else{
            ResponseDto responseDto = parseResponse(response);
            LOGGER.info("Respuesta de la API: " + responseDto);
            return responseDto;
        }
        
    }
    /**
     * Método que invoca la API de conversión de monedas
     * okhtttp3
     * @param endpoint
     * @return Response
     */
    private Response invokeApi(String endpoint) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
        .url(endpoint)
        .addHeader("apikey", "DKtvGE5j3a4vFH9qUICssZzdVdKJIla9")
        .method("GET", null)
        .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Error al invocar la API");
            return null;
        }    
    }

    /**
     * Método que parsea la respuesta de la API a un responseDto
     * @param response
     * @return ResponseDto
     */

    private ResponseDto parseResponse(Response response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResponseDto responseDto = mapper.readValue(response.body().string(), ResponseDto.class);
            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Error al parsear la respuesta de la API");
            return null;
        }

    }


}