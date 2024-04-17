/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phearun.thds_backend.dto.IssueDTO;
import phearun.thds_backend.dto.IssueDetailDTO;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.mapper.IssueMapper;
import phearun.thds_backend.model.Issue;
import phearun.thds_backend.service.IssueService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/issue")
@AllArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @PostMapping
    public ResponseEntity<Issue> create(@RequestBody IssueDTO issueDTO){
        Issue issue = IssueMapper.INSTANCE.toEntity(issueDTO);

        System.out.println(issue.getCateId()+ "===============issue"+ issue);

       // issue.setCateId(issue.getCateId());

        issue.setUserId(25L);
        issue.setIssAssigneeTo(2L);

        issue.setIssStatus("New");
        issue.setCreatedDate("121212");
        issue.setUpdatedDate("121213");

        issue.setIssDone("0");
        issue = issueService.save(issue);
        return ResponseEntity.ok(issue);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) throws ApiException {
        return ResponseEntity.ok(issueService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Issue> update(@PathVariable("id") Long id, @RequestBody IssueDTO issueDTO) throws ApiException {

        Issue issue =  IssueMapper.INSTANCE.toEntity(issueDTO);
//        issue.setUserId(25L);
//        issue.setIssAssigneeTo(2L);
        issue.setIssId(id);
        System.out.println(id+ "======="+ issue);

        return ResponseEntity.ok(issueService.update(id, issue));
    }

    @GetMapping
    public ResponseEntity<?> list(){
        List<IssueDTO> listIssues = issueService.getIssues()
                .stream()
                .map(c -> IssueMapper.INSTANCE.toDTO(c))
                .toList();

        System.out.println("kjjddddddd"+ listIssues);
        return ResponseEntity.ok(listIssues);
    }


//    @GetMapping("/getall")
//    public ResponseEntity<List<?>> listCategoryDetail() {
//        var data = issueService.findAllIssue();
////        List<IssueDetailDTO> issueDetailDTOs = issueService.findAllIssue()
////                .stream()
////                .map(c -> IssueMapper.INSTANCE.toIssDetailDTO(c))
////                .collect(Collectors.toList());
//        return ResponseEntity.ok(data);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        issueService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
