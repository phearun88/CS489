/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import phearun.thds_backend.dto.IssueDetailDTO;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.model.Issue;
import phearun.thds_backend.repository.IssueRepository;
import phearun.thds_backend.service.IssueService;

import java.sql.SQLOutput;
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
    public Issue getById(Long id) {
        System.out.println("=========="+id);
        return issueRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Issue not found for id=%d", id)));
    }

    @Override
    public Issue update(Long id, Issue Issue) {
        Issue target = getById(id);

        BeanUtils.copyProperties(Issue, target, "iss_id");

        return issueRepository.save(target);
    }

    @Override
    public List<Issue> getIssues() {
        System.out.println("StartTesting");

        System.out.println("========" + issueRepository.findAll());
        System.out.println("EndTesting");
        //return issueRepository.findAll();
        return  issueRepository.findAllIssueBySummit();
    }

    @Override
    public List<Issue> findAllIssueByUserId(Long userId) {

        return issueRepository.findAllIssueByUserId(userId);

    }

    @Override
    public List<Issue> findAllIssueByUserIdWithDraft(Long userId) {
        return issueRepository.findAllIssueByUserIdWithDraft(userId);
    }

//    @Override
//    public List<IssueDetailDTO> findAllIssue() {
//
//        System.out.println("Start");
//        var data = issueRepository.findAllIssue();
//        System.out.println("========" + data);
//        System.out.println("End");
//        return issueRepository.findAllIssue();
//    }

    @Override
    public void delete(Long id) {
        issueRepository.deleteById(id);
    }
}
