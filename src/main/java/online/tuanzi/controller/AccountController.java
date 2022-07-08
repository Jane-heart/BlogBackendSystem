package online.tuanzi.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import online.tuanzi.convertor.UserConvertor;
import online.tuanzi.model.dto.LoginUserRequest;
import online.tuanzi.model.entity.User;
import online.tuanzi.model.vo.LoginUserVO;
import online.tuanzi.model.vo.Result;
import online.tuanzi.service.UserService;
import online.tuanzi.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录接口
 */
@RestController
public class AccountController {
    @Resource
    private UserService userService;

    @Resource
    private JwtUtils jwtUtils;;

    /**
     * 登录：*
     * 参数：账号，密码
     * 返回：状态，token
     * @return
     */
    @PostMapping("/login")
    public LoginUserVO loginUser(@Validated @RequestBody LoginUserRequest loginUserRequest, HttpServletResponse response){
        //判断用户是否存在
        User user = userService.getOne(new QueryWrapper<User>().eq("account", loginUserRequest.getAccount()));
        Assert.notNull(user, "账号不存在");

        //判断密码是否正确
        // TODO:存储密码需要使用md5加密后
//        if (user == null || !user.getPassword().equals(SecureUtil.md5(loginUserRequest.getPassword()))) {
        if (user == null || !user.getPassword().equals(loginUserRequest.getPassword())) {
            // TODO: 抛出密码错误异常
//            System.out.println("密码错误");
//            return Result.failure("密码错误");
            return null;
        }

        //根据用户id生成jwt
        String jwt = jwtUtils.generateToken(user.getUserId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");
        LoginUserVO loginUserVO = UserConvertor.INSTANCE.toLoginUserVO(user);

        return loginUserVO;
    }

    /**
     * 注销
     * @return
     */
    @RequiresAuthentication //登录后才能访问该接口
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.success("注销成功");
    }
}
