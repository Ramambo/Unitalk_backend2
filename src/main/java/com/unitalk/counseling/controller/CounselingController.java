package com.unitalk.counseling.controller;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.util.paging.Pagenation;
import com.unitalk.common.util.paging.PagingButtonInfo;
import com.unitalk.common.util.paging.PagingResponse;
import com.unitalk.counseling.dto.request.CounselingCreateRequest;
import com.unitalk.counseling.dto.response.CounselingResponse;
import com.unitalk.counseling.dto.response.CounselingScheduleResponse;
import com.unitalk.counseling.model.entity.CounselorSchedule;
import com.unitalk.counseling.service.ProfessorCounselingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/counseling")
public class CounselingController {

    private final ProfessorCounselingService professorCounselingService;

    /* 목록 조회, 페이징 */
    @GetMapping("/list")
    public ResponseEntity<PagingResponse> getPagingList(@RequestParam(defaultValue = "1") final Integer page) {

        final Page<CounselingResponse> list = professorCounselingService.getPagingList(page);
        final PagingButtonInfo pagingButtonInfo = Pagenation.getPagingButtonInfo(list);
        final PagingResponse pagingResponse = PagingResponse.of(list.getContent(), pagingButtonInfo);

        return ResponseEntity.ok(pagingResponse);
    }

    /*  목록 조회. 페이징, 검색어 학생id */
    @GetMapping("/list/search/student")
    public ResponseEntity<PagingResponse> getByUsername(
            @RequestParam(defaultValue = "1") final Integer page, @RequestParam final Long studentId) {
        final Page<CounselingResponse> list = professorCounselingService.getByStudentId(page, studentId);
        final PagingButtonInfo pagingButtonInfo = Pagenation.getPagingButtonInfo(list);
        final PagingResponse pagingResponse = PagingResponse.of(list.getContent(), pagingButtonInfo);

        return ResponseEntity.ok(pagingResponse);
    }

    /*  목록 조회. 페이징, 검색어 교수id로 교수가 상담 가능한 스케쥴을 찾기 */
    @GetMapping("/list/search/professor")
    public ResponseEntity<PagingResponse> getByEmpId(
            @RequestParam(defaultValue = "1") final Integer page, @RequestParam Long empId) {

        final Page<CounselingScheduleResponse> list = professorCounselingService.getByEmployeeId(page, empId);
        final PagingButtonInfo pagingButtonInfo = Pagenation.getPagingButtonInfo(list);
        final PagingResponse pagingResponse = PagingResponse.of(list.getContent(), pagingButtonInfo);

        return ResponseEntity.ok(pagingResponse);
    }

    /* 상세 조회 : reqNo 단건 조회*/
    @GetMapping("/{reqNo}")
    public ResponseEntity<CounselingResponse> getCounseling(@PathVariable final Long reqNo) {
        log.info("상세조회 >>>>>>>reqNo : {} ", reqNo);
        final CounselingResponse response = professorCounselingService.getCounseling(reqNo);
        return ResponseEntity.ok(response);
    }

    /* 등록 */
    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody final CounselingCreateRequest request) {

        log.info("/save >>>>>>>>>>>> {} ",request.toString());
        final Long reqNo = professorCounselingService.save(request);
        return ResponseEntity.created(URI.create("/counseling-management/" + reqNo)).build();
    }

    /* 수정 미작업*/

    /*  삭제
     *  -> 삭제(상담 취소)해도 상태(status)가 상담 취소로 변경되고 기록은 남아야함.
     * */
    @DeleteMapping("/{reqNo}")
    public ResponseEntity<Void> delete(@PathVariable final Long reqNo) {
        log.info("상담 삭제 >>>>>>>reqNo : {} ", reqNo);
        professorCounselingService.delete(reqNo);
        return ResponseEntity.noContent().build();
    }
}
