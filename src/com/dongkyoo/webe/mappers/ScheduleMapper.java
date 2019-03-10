package com.dongkyoo.webe.mappers;

import com.dongkyoo.webe.datas.vos.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ScheduleMapper {

    int insertSchedule(Schedule schedule);

    Schedule selectSchedule(int id);

    int modifySchedule(
            @Param("id") int id,
            @Param("schedule") Schedule schedule);

    int deleteSchedule(int id);
}
