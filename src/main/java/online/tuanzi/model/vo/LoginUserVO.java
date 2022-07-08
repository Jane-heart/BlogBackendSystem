package online.tuanzi.model.vo;

import lombok.Data;

@Data
public class LoginUserVO {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 头像路径
     */
    private String avatarPath;

    /**
     * 姓名
     */
    private String name;
}
