package arquitectura.software.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// @JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorServiceDto {
    @JsonProperty("error")
    private ErrorApiDto error;
    

    //Constructor vacio
    public ErrorServiceDto() {
    }

    //Constructor con parametros
    public ErrorServiceDto(ErrorApiDto error) {
        this.error = error;
    }
    
    //Getters and Setters
    public ErrorApiDto getError() {
        return error;
    }

    public void setError(ErrorApiDto error) {
        this.error = error;
    }

    //toString
    @Override
    public String toString() {
        return "ErrorServiceDto [error=" + error + "]";
    }
    
}


