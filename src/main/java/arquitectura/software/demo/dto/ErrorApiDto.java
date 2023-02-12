package arquitectura.software.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorApiDto {
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;

    //Constructor
    public ErrorApiDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    //Constructor vacio
    public ErrorApiDto() {
    }

    //Getters and Setters
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    //toString
    @Override   
    public String toString() {
        return "ErrorApiDto [code=" + code + ", message=" + message + "]";
    }

    

    
}
