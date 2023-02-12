package arquitectura.software.demo.api;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import arquitectura.software.demo.bl.CurrencyBl;
import arquitectura.software.demo.dto.RequestDto;
import arquitectura.software.demo.dto.ResponseDto;

@RestController
@RequestMapping("/api/currency")
public class CurrencyApi {
    private CurrencyBl currencyBl;
    private static final Logger LOGGER = Logger.getLogger(CurrencyApi.class.getName());
    
    //Constructor CurrencyApi
    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    /**
     * Endpoint GET para obtener la conversión de una moneda a otra
     */
    @GetMapping("/convert")
    public ResponseDto convert(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) {
        RequestDto requestDto = new RequestDto(from, to, amount);
        //Log procesando solicitud
        LOGGER.log(Level.INFO, "Procesando solicitud de conversion de moneda: " + requestDto.getAmount()+ " " + requestDto.getFrom() + " a " + requestDto.getTo());
        ResponseDto result = currencyBl.convert(requestDto);
        return result;
    }
}