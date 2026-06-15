package it.uniroma3.football.service;



import it.uniroma3.football.model.Referee;
import it.uniroma3.football.repository.RefereeRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;




@Service
public class RefereeService {



    private final RefereeRepository refereeRepository;





    public RefereeService(RefereeRepository refereeRepository){

        this.refereeRepository = refereeRepository;

    }






    @Transactional(readOnly = true)
    public List<Referee> findAll(){

        return refereeRepository.findAll();

    }






    @Transactional(readOnly = true)
    public Optional<Referee> findById(Long id){

        return refereeRepository.findById(id);

    }


    


    @Transactional
    public Referee save(Referee referee){

        return refereeRepository.save(referee);

    }





    @Transactional
    public void delete(Long id){

        refereeRepository.deleteById(id);

    }



}
