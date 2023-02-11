package arquitectura.software.demo.api;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import arquitectura.software.demo.bl.CurrencyBl;
import arquitectura.software.demo.dto.ResponseDto;

@RestController
@RequestMapping("/api/currency")
public class CurrencyApi {
    private CurrencyBl currencyBl;
    
    //Constructor CurrencyApi
    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    /**
     * Endpoint GET para obtener la conversión de una moneda a otra
     */
    @GetMapping("/convert")
    public String convert(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) {
        return "Hola:" + from + "   " + to + "   " + amount;
    }
}