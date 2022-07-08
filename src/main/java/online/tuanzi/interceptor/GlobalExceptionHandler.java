package online.tuanzi.interceptor;

import lombok.extern.slf4j.Slf4j;
import online.tuanzi.model.vo.Result;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j //日志
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST) //返回状态码
    @ExceptionHandler(value = RuntimeException.class) //指定捕获Exception的各个类型异常
    public Result handler(RuntimeException e){
        log.error("RuntimeException:------------------>{}",e);
        return Result.failure(e.getMessage());
    }

    /**
     * Shiro异常处理
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED) //Unauthorized
    @ExceptionHandler(value = ShiroException.class) //@ExceptionHandler表示针对性异常处理
    public Result handler(ShiroException e){
        log.error("ShiroException:------------------>{}",e);
        return Result.failure(401,"您尚未认证: 无权操作",null);
    }


    /**
     * 实体校验异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e){
        log.error("MethodArgumentNotValidException:------------------>{}",e);
        //简化异常错误信息
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return Result.failure(objectError.getDefaultMessage());
    }

    /**
     * 断言异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handler(IllegalArgumentException e){
        log.error("IllegalArgumentException:------------------>{}",e);
        return Result.failure(e.getMessage());
    }
//
//    @ExceptionHandler(BizException.class)
//    public Result bizExceptionHandler(HttpServletRequest req, BizException e) {
//        return new Result(e.getCode(), e.getMessage(), e.getData());
//    }
//
//    /*全局异常配置，所有未定义的异常都会拦截到此处*/
//    @ExceptionHandler(Exception.class)
//    public Result globalExceptionHandler(HttpServletRequest req, Exception e) {
//        return new Result(ResultCode.USER_NOT_EXIST, null);
//    }

}
