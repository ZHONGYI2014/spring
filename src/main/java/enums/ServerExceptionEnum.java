package enums;

public enum ServerExceptionEnum {

    SYSTEM_ERROR("系统异常"),
    PARAMS_CANNOT_BE_NULL("{0}不能为空");

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ServerExceptionEnum(String msg) {
        this.msg = msg;
    }
}
