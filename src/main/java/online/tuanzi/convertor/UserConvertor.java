package online.tuanzi.convertor;

import online.tuanzi.model.entity.User;
import online.tuanzi.model.vo.LoginUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConvertor {
    UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);

    LoginUserVO toLoginUserVO(User user);
}
