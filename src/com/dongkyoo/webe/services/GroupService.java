package com.dongkyoo.webe.services;

import com.dongkyoo.webe.datas.vos.Group;
import com.dongkyoo.webe.mappers.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupMapper mapper;

    public Group createGroup(Group group) {
        mapper.insertGroup(group);
        return mapper.selectGroup(group.getId());
    }

    public Group selectGroup(int id) {
        return mapper.selectGroup(id);
    }

    public Group deleteGroup(int id) {
        Group g = mapper.selectGroup(id);
        mapper.deleteGroup(id);
        return g;
    }

    public Group updateGroup(int id, Group group) {
        mapper.updateGroup(id, group);
        return mapper.selectGroup(id);
    }
}
