package online.tuanzi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.model.entity.User;
import online.tuanzi.service.UserService;
import online.tuanzi.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author tuanzi
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2022-06-13 09:24:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}




