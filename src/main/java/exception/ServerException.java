package exception;

import constant.HttpStatusCodes;
import enums.ServerExceptionEnum;

import java.text.MessageFormat;

public class ServerException extends BaseException {

    private static final long serialVersionUID = 1L;

    private final static int HTTP_CODE = HttpStatusCodes.STATUS_500;

    public ServerException(ServerExceptionEnum en) {
        super(HTTP_CODE, en.toString(), en.getMsg());
    }

    public ServerException(ServerExceptionEnum en, Object ... arguments) {
        super(HTTP_CODE, en.toString(),MessageFormat.format(en.getMsg(), arguments));
    }

}
