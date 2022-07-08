package online.tuanzi.model.vo;

import lombok.Data;
import online.tuanzi.enums.ResultCode;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode){
        this.setCode(resultCode.getCode());
        this.setMessage(resultCode.getMessage());
    }

    //返回成功
    public static <T> Result<T> success(){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    //返回成功
    public static <T> Result<T> success(T data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    //返回失败
    public static <T> Result<T> failure(ResultCode resultCode){
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }
    //返回失败
    public static <T> Result<T> failure(ResultCode resultCode,T data){
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    /**
     * 抽取结果集,提搞代码重用性
     * @param msg
     * @return error(code,msg,null)
     */
    public static  <T> Result<T> failure(String msg){
        return new Result(400,msg,null);
    }

    /**
     * 返回错误信息结果集
     * @param code
     * @param msg
     * @param data
     * @return result
     */
    public static Result failure(int code,String msg,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
}
