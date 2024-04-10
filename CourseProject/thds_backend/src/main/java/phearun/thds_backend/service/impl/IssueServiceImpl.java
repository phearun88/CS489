/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.model.Issue;
import phearun.thds_backend.repository.IssueRepository;
import phearun.thds_backend.service.IssueService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;


    @Override
    public Issue save(Issue entity) {
        return issueRepository.save(entity);
    }

    @Override
    public Issue getById(Integer id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Issue not found for id=%d", id)));
    }

    @Override
    public Issue update(Integer id, Issue Issue) {
        Issue target = getById(id);

        BeanUtils.copyProperties(Issue, target, "iss_id");

        return issueRepository.save(target);
    }

    @Override
    public List<Issue> getIssues() {
        return issueRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        issueRepository.deleteById(id);
    }
}
