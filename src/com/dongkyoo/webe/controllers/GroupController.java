package com.dongkyoo.webe.controllers;

import com.dongkyoo.webe.datas.vos.Group;
import com.dongkyoo.webe.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("groups")
public class GroupController {

    @Autowired
    private GroupService service;

    @PostMapping("")
    public Group createGroup(@RequestBody Group group) {
        return service.createGroup(group);
    }

    @GetMapping("{id}")
    public Group selectGroup(@PathVariable int id) {
        return service.selectGroup(id);
    }

    @DeleteMapping("{id}")
    public Group deleteGroup(@PathVariable int id) {
        return service.deleteGroup(id);
    }

    @PutMapping("{id}")
    public Group updateGroup(@PathVariable int id, @RequestBody Group group) {
        return service.updateGroup(id, group);
    }
}
