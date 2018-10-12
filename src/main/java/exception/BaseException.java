package exception;

/**
 * 统一异常规范
 */
public class BaseException extends RuntimeException {

    private int httpCode = 500;

    private String errCode;

    public BaseException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public BaseException(int httpCode, String errCode, String errMsg) {
        super(errMsg);
        this.httpCode = httpCode;
        this.errCode = errCode;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
