package arquitectura.software.demo.dto;

import java.math.BigDecimal;

public class RequestDto {
    private String from;
    private String to;
    private BigDecimal amount;

    //Constructor RequestDto
    public RequestDto(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    //Getters and Setters
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    //toString
    @Override
    public String toString() {
        return "RequestDto [amount=" + amount + ", from=" + from + ", to=" + to + "]";
    }
}
