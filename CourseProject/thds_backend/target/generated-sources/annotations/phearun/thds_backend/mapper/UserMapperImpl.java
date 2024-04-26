package phearun.thds_backend.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import phearun.thds_backend.dto.UserDTO;
import phearun.thds_backend.model.Role;
import phearun.thds_backend.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-24T12:24:55-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setEmail( dto.getEmail() );
        user.setStatus( dto.getStatus() );
        user.setLastName( dto.getLastName() );
        user.setFirstName( dto.getFirstName() );
        user.setDepartment( dto.getDepartment() );
        user.setPosition( dto.getPosition() );
        user.setDob( dto.getDob() );
        user.setGender( dto.getGender() );
        user.setType( dto.getType() );
        List<Role> list = dto.getRoles();
        if ( list != null ) {
            user.setRoles( new ArrayList<Role>( list ) );
        }

        return user;
    }

    @Override
    public UserDTO toDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( entity.getId() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setStatus( entity.getStatus() );
        userDTO.setLastName( entity.getLastName() );
        userDTO.setFirstName( entity.getFirstName() );
        userDTO.setDepartment( entity.getDepartment() );
        userDTO.setPosition( entity.getPosition() );
        userDTO.setDob( entity.getDob() );
        userDTO.setGender( entity.getGender() );
        userDTO.setType( entity.getType() );
        List<Role> list = entity.getRoles();
        if ( list != null ) {
            userDTO.setRoles( new ArrayList<Role>( list ) );
        }

        return userDTO;
    }
}
