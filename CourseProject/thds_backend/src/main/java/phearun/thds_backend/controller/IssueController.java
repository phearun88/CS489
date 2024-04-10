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
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.mapper.IssueMapper;
import phearun.thds_backend.model.Issue;
import phearun.thds_backend.service.IssueService;

import java.util.List;

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
        issue.setIssStatus("NEW");
        issue.setCreatedDate("121212");
        issue.setUpdatedDate("121213");
        issue = issueService.save(issue);
        return ResponseEntity.ok(issue);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
        return ResponseEntity.ok(issueService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Issue> update(@PathVariable("id") int id, @RequestBody IssueDTO IssueDTO) throws ApiException {
        Issue brand =  IssueMapper.INSTANCE.toEntity(IssueDTO);
        return ResponseEntity.ok(issueService.update(id, brand));
    }

    @GetMapping
    public ResponseEntity<?> list(){
        List<IssueDTO> listCategories = issueService.getIssues()
                .stream()
                .map(c -> IssueMapper.INSTANCE.toDTO(c))
                .toList();
        return ResponseEntity.ok(listCategories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        issueService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
