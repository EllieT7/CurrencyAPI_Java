package arquitectura.software.demo.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    private Boolean success;
    private QueryDto query;
    private String date;
    private BigDecimal result;
    
    //Constructor vacio
    public ResponseDto() {
    }

    //Getters and Setters
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public BigDecimal getResult() {
        return result;
    }
    public void setResult(BigDecimal result) {
        this.result = result;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public QueryDto getQuery() {
        return query;
    }

    public void setQuery(QueryDto query) {
        this.query = query;
    }
    
    //toString
    @Override
    public String toString() {
        return "ResponseDto [date=" + date + ", query=" + query + ", result=" + result + ", success=" + success + "]";
    }

}
