package com.dongkyoo.webe.controllers;

import com.dongkyoo.webe.datas.vos.Schedule;
import com.dongkyoo.webe.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping("")
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return service.createSchedule(schedule);
    }

    @GetMapping("{id}")
    public Schedule selectSchedule(@PathVariable int id) {
        return service.selectSchedule(id);
    }

    @PutMapping("{id}")
    public Schedule modifySchedule(@PathVariable int id, @RequestBody Schedule schedule) {
        return service.modifySchedule(id, schedule);
    }

    @DeleteMapping("{id}")
    public Schedule deleteSchedule(@PathVariable int id) {
        return service.deleteSchedule(id);
    }
}
