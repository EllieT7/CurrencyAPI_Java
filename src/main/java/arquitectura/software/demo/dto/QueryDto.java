package arquitectura.software.demo.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
// @JsonIgnoreProperties(ignoreUnknown = true)
public class QueryDto {
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("amount")
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
