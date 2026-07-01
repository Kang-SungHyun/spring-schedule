package com.schedule.controller;

import com.schedule.dto.ScheduleRequestDto;
import com.schedule.dto.ScheduleResponseDto;
import com.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 1. 일정 등록 (POST http://localhost:8080/api/schedules)
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    // 2. 일정 단건 조회 (GET http://localhost:8080/api/schedules/1)
    @GetMapping("/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }

    // 3. 일정 전체 목록 조회 (GET http://localhost:8080/api/schedules)
    @GetMapping
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
    }

    // 4. 일정 수정 (PUT http://localhost:8080/api/schedules/1)
    @PutMapping("/{id}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }

    // 5. 일정 삭제 (DELETE http://localhost:8080/api/schedules/1)
    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        scheduleService.deleteSchedule(id, requestBody.get("password"));
        return "일정이 성공적으로 삭제되었습니다.";
    }
}