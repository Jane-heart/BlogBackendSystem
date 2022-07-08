package online.tuanzi.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.tuanzi.model.entity.Blog;
import online.tuanzi.service.BlogService;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin
public class BlogController {

    @Resource
    private BlogService blogService;

    /**
     * 文章列表
     * @param currentPage
     * @return
     */
    @GetMapping
    public IPage<Blog> list(@RequestParam(defaultValue = "1") Integer currentPage){

        Page page = new Page(currentPage,5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("publish_time"));
        return pageData;
    }

    /**
     * 文章详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Blog detail(@PathVariable(name = "id")Long id){

        Blog blog = blogService.getById(id);
        Assert.notNull(blog,"本文章已被删除");
        return blog;
    }


    /**
     * 文章编辑
     * @param blog
     * @return
     */
//    @RequiresAuthentication //认证后方可访问该接口
    @PostMapping("/edit")
    public void edit(@Validated @RequestBody Blog blog){

        Blog temp = null;
//        Long currentUserId = ShiroUtils.getProfile().getId().longValue(); //获取当前用户id
        Long currentUserId = Long.valueOf(blog.getAuthorId()); //获取当前用户id
        if(blog.getBlogId()!=null){
            temp = blogService.getById(blog.getBlogId());
            // 只能编辑自己的文章
            Assert.isTrue(temp.getAuthorId().longValue()==currentUserId,"无编辑权限");
        }else {
            //初始化新文章
            temp = new Blog();
            temp.setAuthorId(currentUserId.intValue());
            temp.setPublishTime(new Date());
            temp.setBlogStatusCode(0);
        }
        //复制文章数据
        BeanUtil.copyProperties(blog,temp,"blogId","authorId","publishTime","blogStatusCode");

        blogService.saveOrUpdate(temp);
        return;
    }


    /**
     * 文章删除
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id")String  id){
        boolean result = blogService.removeById(id);// 据库中为Long id
        Assert.isTrue(result,"本文章已被删除");
        return;
    }

    /**
     * 模糊查询
     * @param title
     * @return
     */
    //Error:Failed to convert value of type 'java.lang.String' to required type 'java.lang.Long';
    @GetMapping("/findByTitle")
    public List<Blog> findByTitle(@RequestParam(defaultValue = "") String title){
        List<Blog> blogs = blogService.list(new QueryWrapper<Blog>()
                .like("title", title)
                .orderByDesc("publish_time"));
        Assert.notNull(blogs,"未查询到指定文章");
        return blogs;
    }
}
