package phearun.thds_backend.mapper;

import javax.annotation.processing.Generated;
import phearun.thds_backend.dto.IssueDTO;
import phearun.thds_backend.model.Issue;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-19T16:27:03-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
public class IssueMapperImpl implements IssueMapper {

    @Override
    public Issue toEntity(IssueDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Issue issue = new Issue();

        issue.setIssId( dto.getIssId() );
        issue.setIssName( dto.getIssName() );
        issue.setCateId( dto.getCateId() );
        issue.setSubCateId( dto.getSubCateId() );
        issue.setIssDesc( dto.getIssDesc() );
        issue.setIssStatus( dto.getIssStatus() );
        issue.setIssTp( dto.getIssTp() );
        issue.setIssDraft( dto.getIssDraft() );
        issue.setIssDone( dto.getIssDone() );
        issue.setIssAssigneeTo( dto.getIssAssigneeTo() );
        issue.setUserId( dto.getUserId() );
        issue.setCreatedDate( dto.getCreatedDate() );
        issue.setUpdatedDate( dto.getUpdatedDate() );

        return issue;
    }

    @Override
    public IssueDTO toDTO(Issue issue) {
        if ( issue == null ) {
            return null;
        }

        IssueDTO issueDTO = new IssueDTO();

        issueDTO.setIssId( issue.getIssId() );
        issueDTO.setIssName( issue.getIssName() );
        issueDTO.setCateId( issue.getCateId() );
        issueDTO.setSubCateId( issue.getSubCateId() );
        issueDTO.setIssDesc( issue.getIssDesc() );
        issueDTO.setIssStatus( issue.getIssStatus() );
        issueDTO.setIssTp( issue.getIssTp() );
        issueDTO.setIssDraft( issue.getIssDraft() );
        issueDTO.setIssDone( issue.getIssDone() );
        issueDTO.setIssAssigneeTo( issue.getIssAssigneeTo() );
        issueDTO.setUserId( issue.getUserId() );
        issueDTO.setCreatedDate( issue.getCreatedDate() );
        issueDTO.setUpdatedDate( issue.getUpdatedDate() );

        return issueDTO;
    }
}
