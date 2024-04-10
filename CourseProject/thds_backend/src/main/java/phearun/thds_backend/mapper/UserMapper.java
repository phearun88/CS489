package phearun.thds_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import phearun.thds_backend.dto.UserDTO;
import phearun.thds_backend.model.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toEntity(UserDTO dto);
    UserDTO toDTO(User user);

}
