package com.dongkyoo.webe.mappers;

import com.dongkyoo.webe.datas.vos.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GroupMapper {

    int insertGroup(Group group);

    Group selectGroup(int id);

    int deleteGroup(int id);

    int updateGroup(
            @Param("id") int id,
            @Param("group") Group group);
}
