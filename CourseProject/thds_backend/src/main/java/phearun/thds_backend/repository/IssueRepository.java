package phearun.thds_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import phearun.thds_backend.dto.IssueDetailDTO;
import phearun.thds_backend.model.Issue;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>{

//,


    @Query(value = "SELECT * FROM Issue i WHERE i.user_id = ?1 AND i.iss_draft = 'yes'", nativeQuery = true)
    List<Issue> findAllIssueByUserIdWithDraft(Long userId);

    @Query(value = "SELECT * FROM Issue i WHERE i.user_id = ?1", nativeQuery = true)
    List<Issue> findAllIssueByUserId(Long userId);


    @Query(value = "SELECT * FROM Issue i WHERE i.iss_draft = 'no'", nativeQuery = true)
    List<Issue> findAllIssueBySummit();


//    @Query(value = "select iss.iss_id, iss.iss_name from issue as iss inner join subcategory as sub on iss.sub_cate_id = sub.id",
//            nativeQuery = true)
//    List<Issue> findAllIssue();

//    @Query(value = "SELECT iss.iss_name, sub.subcate_name FROM issue iss INNER JOIN subcategory sub on iss.sub_cate_id = sub.id", nativeQuery = true)
//    List<IssueDetailDTO> findAllIssue();

//    public interface UserRepository extends CrudRepository<UserEntity, Long> {
//        @Query(value = "select new com.example.package.StatsDTO(count(type_id) userCount, typeId, modifiedAt from "
//                + "UserCampaignObjective where campId = ?1 group by objectiveTypeId,modifiedAt")
//
//        List<StatsDTO> getStatsDTO(Long camp_id);
//    }





}
