package online.tuanzi.controller;

import online.tuanzi.model.dto.*;
import online.tuanzi.model.entity.User;
import online.tuanzi.model.vo.*;
import online.tuanzi.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("users/")
public class UserController {

    @Resource
    private UserService userService;

    @RequiresAuthentication //登录权限验证:即登录之后才可以访问该接口
    @GetMapping("/index")
    public User index(){
        User user = userService.getById(1L);
        return user;
    }

    @GetMapping("/error")
    public void error(){
        // TODO:抛出操作失败异常
//        return Result.error("操作失败");
        return;
    }


    @PostMapping("/save")
    public void save(@Validated @RequestBody User user){
        boolean success = userService.save(user);
        if (!success){
            // TODO:抛出保存失败异常
        }
        return;
    }
}
