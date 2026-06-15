package it.uniroma3.football.security;



import it.uniroma3.football.model.AppUser;
import it.uniroma3.football.repository.AppUserRepository;


import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;





@Service
public class CustomUserDetailsService
        implements UserDetailsService {




    private final AppUserRepository userRepository;




    public CustomUserDetailsService(
            AppUserRepository userRepository){


        this.userRepository = userRepository;

    }








    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {



        AppUser user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow(
                                () ->
                                        new UsernameNotFoundException(
                                                "Utente non trovato")
                        );





        return User.builder()

                .username(
                        user.getUsername()
                )

                .password(
                        user.getPassword()
                )


                .roles(
                        user.getRole().name()
                )


                .build();



    }


}