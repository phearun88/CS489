package phearun.thds_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import phearun.thds_backend.dto.IssueDTO;
import phearun.thds_backend.model.Issue;


@Mapper
public interface IssueMapper {

    IssueMapper INSTANCE = Mappers.getMapper(IssueMapper.class);
    Issue toEntity(IssueDTO dto);
    IssueDTO toDTO(Issue issue);

}
