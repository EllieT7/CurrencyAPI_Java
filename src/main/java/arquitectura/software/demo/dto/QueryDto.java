package arquitectura.software.demo.dto;

import java.math.BigDecimal;

public class QueryDto {
    
    private String from;
    private String to;
    private BigDecimal amount;

    //Constructor QueryDto
    public QueryDto(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
    
    //Constructor vacio
    public QueryDto() {
    }

    //toString
    @Override
    public String toString() {
        return "QueryDto [amount=" + amount + ", from=" + from + ", to=" + to + "]";
    }
}
