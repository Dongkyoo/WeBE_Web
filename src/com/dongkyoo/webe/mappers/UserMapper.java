package com.dongkyoo.webe.mappers;

import com.dongkyoo.webe.datas.dtos.PasswordSaltDto;
import com.dongkyoo.webe.datas.vos.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    void insertUser(User user);

    User selectUser(String id);

    Boolean isExist(String userId);

    PasswordSaltDto selectPasswordSalt(String userId);
}
