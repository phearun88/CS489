package phearun.thds_backend.service;


import phearun.thds_backend.model.Issue;

import java.util.List;

public interface IssueService {
    Issue save(Issue entity);

    Issue getById(Integer id);

    Issue update(Integer id, Issue Issue) ;

    List<Issue> getIssues();

    void delete(Integer id);
}
