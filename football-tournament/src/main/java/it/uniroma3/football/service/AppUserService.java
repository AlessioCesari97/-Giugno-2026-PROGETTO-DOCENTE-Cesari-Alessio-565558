package it.uniroma3.football.service;



import it.uniroma3.football.model.AppUser;
import it.uniroma3.football.repository.AppUserRepository;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AppUserService {




    private final AppUserRepository appUserRepository;





    public AppUserService(AppUserRepository appUserRepository){

        this.appUserRepository = appUserRepository;

    }






    @Transactional(readOnly = true)
    public AppUser findByUsername(String username){


        return appUserRepository
                .findByUsername(username)
                .orElseThrow();


    }






    @Transactional
    public AppUser save(AppUser user){

        return appUserRepository.save(user);

    }



}
