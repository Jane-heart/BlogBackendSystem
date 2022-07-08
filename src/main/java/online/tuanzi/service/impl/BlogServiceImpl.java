package online.tuanzi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.convertor.BlogConvertor;
import online.tuanzi.convertor.UserConvertor;
import online.tuanzi.mapper.UserMapper;
import online.tuanzi.model.dto.*;
import online.tuanzi.model.entity.Blog;
import online.tuanzi.model.entity.User;
import online.tuanzi.model.vo.*;
import online.tuanzi.service.BlogService;
import online.tuanzi.mapper.BlogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author tuanzi
* @description 针对表【t_blog】的数据库操作Service实现
* @createDate 2022-06-13 09:23:32
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService{
}




