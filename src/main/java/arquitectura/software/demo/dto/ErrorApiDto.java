package arquitectura.software.demo.dto;

public class ErrorApiDto {
    private String code;
    private String message;

    //Constructor
    public ErrorApiDto(String code, String message) {
        this.code = code;
        this.message = message;
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
