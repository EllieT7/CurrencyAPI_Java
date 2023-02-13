package arquitectura.software.demo.bl;

import java.math.BigDecimal;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import arquitectura.software.demo.dto.ErrorServiceDto;
import arquitectura.software.demo.dto.RequestDto;
import arquitectura.software.demo.dto.ResponseDto;
import arquitectura.software.demo.exception.ServiceException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class CurrencyBl {
    Logger LOGGER = Logger.getLogger(CurrencyBl.class.getName());
    //Declaramos la api key
    @Value("${api.key}")
    private String apiKey;

    /**
     * Método que convierte una moneda a otra
     * @param requestDto
     * @return
     */
    public ResponseDto convert(RequestDto requestDto) {
        if(requestDto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            LOGGER.log(Level.WARNING,"No se puede convertir una cantidad menor a 0");
            throw new ServiceException("No se puede convertir una cantidad menor a 0", "bad_amount");
        }
        LOGGER.info("Convirtiendo " + requestDto.getAmount() + " " + requestDto.getFrom() + " a " + requestDto.getTo());
        Response response = invokeApi("https://api.apilayer.com/exchangerates_data/convert?to="+requestDto.getTo()+"&from="+requestDto.getFrom()+"&amount="+requestDto.getAmount());
              
        if(response.isSuccessful()) {
            //Obtenemos la respuesta exitosa
            ResponseDto responseDto = parseResponse(response);
            LOGGER.info("Respuesta de la API: " + responseDto);
            return responseDto;
        }else{
            //Obtenemos el error
            ErrorServiceDto errorServiceDto = parseError(response);
            LOGGER.log(Level.WARNING,"Error de la API: " + errorServiceDto.getError());
            throw new ServiceException(errorServiceDto.getError().getMessage(), errorServiceDto.getError().getCode());
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
        .addHeader("apikey", apiKey)
        .method("GET", null)
        .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "Error al invocar la API");
            throw new ServiceException("Error al invocar la API","timeout");
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
            throw new ServiceException("Error interno, parseo","internal_error");
        }

    }

    /**
     * Método que parsea el error de la API a un errorServiceDto
     * @param response
     * @return ErrorServiceDto
     */
    private ErrorServiceDto parseError(Response response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ErrorServiceDto errorServiceDto = mapper.readValue(response.body().string(), ErrorServiceDto.class);
            return errorServiceDto;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Error al parsear el error de la API");
            throw new ServiceException("Error interno, parseo","internal_error");
        }
    }


}