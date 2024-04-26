package phearun.thds_backend.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import phearun.thds_backend.model.User;
import phearun.thds_backend.repository.AuthRepository;
import phearun.thds_backend.service.impl.UserDetailImpl;

@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private final AuthRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException(username+" : Not found!");
        }else {
            return new UserDetailImpl(user);
        }
    }
}
