package arquitectura.software.demo.dto;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    private Boolean success;
    private QueryDto query;
    private String date;
    private BigDecimal result;
    
    //Constructor vacio
    public ResponseDto() {
    }
    // //Constructor con parametros
    // public ResponseDto(Boolean success, QueryDto query, String date, BigDecimal result) {
    //     this.success = success;
    //     this.query = query;
    //     this.date = date;
    //     this.result = result;
    // }

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
    @JsonProperty("query")
    public void setQuery(LinkedHashMap query){
        //mapper
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("query: " + query.toString());
        System.out.println("query.class " + query.getClass());
        try {
            this.query = new QueryDto(query.get("from").toString(), query.get("to").toString(), new BigDecimal(query.get("amount").toString()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al parsear el objeto query");
        }
    }
    
    //toString
    @Override
    public String toString() {
        return "ResponseDto [date=" + date + ", query=" + query + ", result=" + result + ", success=" + success + "]";
    }

}
