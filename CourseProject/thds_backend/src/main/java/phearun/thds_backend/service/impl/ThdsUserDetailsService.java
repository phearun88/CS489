/**
 * Author : PhearunPhin
 * Date : 4/16/2024
 */

package phearun.thds_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import phearun.thds_backend.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ThdsUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

//    public ThdsUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findUserByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Username not found for " + username));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User [%s] is not found".formatted(username)));
    }



}
