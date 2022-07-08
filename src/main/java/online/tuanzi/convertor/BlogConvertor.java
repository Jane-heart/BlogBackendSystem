package online.tuanzi.convertor;

import online.tuanzi.model.entity.Blog;
import online.tuanzi.model.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BlogConvertor {
    BlogConvertor INSTANCE = Mappers.getMapper(BlogConvertor.class);
}
