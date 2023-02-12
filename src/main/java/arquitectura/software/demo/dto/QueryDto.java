package arquitectura.software.demo.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryDto {
    
    private String from;
    private String to;
    private BigDecimal amount;

    
    //Constructor vacio
    public QueryDto() {
    }

    //Constructor con parametros
    public QueryDto(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }   

    //toString
    @Override
    public String toString() {
        return "QueryDto [amount=" + amount + ", from=" + from + ", to=" + to + "]";
    }
}
