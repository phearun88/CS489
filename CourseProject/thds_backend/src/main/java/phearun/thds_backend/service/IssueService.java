package phearun.thds_backend.service;


import phearun.thds_backend.dto.IssueDetailDTO;
import phearun.thds_backend.model.Issue;

import java.util.List;

public interface IssueService {
    Issue save(Issue entity);

    Issue getById(Long id);

    Issue update(Long id, Issue Issue) ;

    List<Issue> getIssues();

   // List<IssueDetailDTO>findAllIssue();

    void delete(Long id);
}
