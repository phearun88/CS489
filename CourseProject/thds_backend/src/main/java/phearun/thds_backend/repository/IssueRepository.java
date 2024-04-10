package phearun.thds_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phearun.thds_backend.model.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
}
