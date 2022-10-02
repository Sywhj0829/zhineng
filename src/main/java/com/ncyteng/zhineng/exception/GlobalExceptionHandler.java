package com.ncyteng.zhineng.exception;


import com.ncyteng.zhineng.tools.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    //    打印日志
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 按顺序检查 这个是自己定义的错误
     * 拦截业务异常，返回业务异常信息
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultJson handleBusinessError(BusinessErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return  ResultJson.success(code, message);
    }

    /**
     * 系统异常 预期以外异常
     * @param ex
     * @return
     */
//    Exception 接收所有报错
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleTypeMismatchException(Exception ex, Model model) {
        logger.error("空指针异常，{}", ex.getMessage());
        model.addAttribute("error",ex.getMessage());
        return "error/500";
    }

}
