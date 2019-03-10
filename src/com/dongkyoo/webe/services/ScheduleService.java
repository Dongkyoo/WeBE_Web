package com.dongkyoo.webe.services;

import com.dongkyoo.webe.datas.vos.Schedule;
import com.dongkyoo.webe.mappers.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleMapper mapper;

    public Schedule createSchedule(Schedule schedule) {
        mapper.insertSchedule(schedule);
        return mapper.selectSchedule(schedule.getId());
    }

    public Schedule selectSchedule(int id) {
        return mapper.selectSchedule(id);
    }

    public Schedule modifySchedule(int id, Schedule schedule) {
        mapper.modifySchedule(id, schedule);
        return mapper.selectSchedule(id);
    }

    public Schedule deleteSchedule(int id) {
        Schedule schedule = mapper.selectSchedule(id);
        mapper.deleteSchedule(id);
        return schedule;
    }
}
