package online.tuanzi.shiro;

import cn.hutool.core.bean.BeanUtil;
import online.tuanzi.model.entity.User;
import online.tuanzi.service.UserService;
import online.tuanzi.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Shiro配置信息
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        // 判断是否是JWT Token
        return token instanceof JwtToken;
    }

    /**
     * 授权认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 身份验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        User user = userService.getById(Long.valueOf(userId));
        if (user==null){
            throw new UnknownAccountException("account is not nonexistent");
        }
        // TODO: User实体加状态码
//        else if (user.getStatus()==-1){
//            throw new LockedAccountException("account is locked");
//
//        }

        AccountProfile accountProfile = new AccountProfile();
        BeanUtil.copyProperties(user,accountProfile);
        accountProfile.setAvatar(user.getAvatarPath());
        accountProfile.setId(user.getUserId());
        return new  SimpleAuthenticationInfo(accountProfile,jwtToken.getCredentials(),getName());
    }
}
