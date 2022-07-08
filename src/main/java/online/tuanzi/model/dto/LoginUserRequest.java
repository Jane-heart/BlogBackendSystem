package online.tuanzi.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户登录信息
 */
@Data
public class LoginUserRequest implements Serializable {
    /**
     * 账号
     */
    @NotBlank(message = "昵称不能为空")
    private String account;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
