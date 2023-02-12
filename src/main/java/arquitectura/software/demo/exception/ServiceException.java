package arquitectura.software.demo.exception;

public class ServiceException extends RuntimeException{
    private String code;

    public ServiceException(String message, String code) {
        super(message);
        this.code = code;

    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return super.getMessage();
    }

}
