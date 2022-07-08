package online.tuanzi.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * 封装用户可公开的信息
 */
@Data
public class AccountProfile implements Serializable {

    private Integer id;

    private String account;

    private String avatar;

}
