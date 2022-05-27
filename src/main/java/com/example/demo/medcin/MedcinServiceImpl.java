package com.example.demo.medcin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedcinServiceImpl implements MedcinService{

    @Autowired
    private MedcinRepository medcinRepository;
    
    @Override
    public List<medcin> getAllMedcins() {

        return medcinRepository.findAll();
        
    }

    @Override
    public void saveMedcin(medcin medcin) {
        this.medcinRepository.save(medcin);
        
    }

    @Override
    public medcin getMedcinById(long id) {
        Optional<medcin> optionalMedcin = medcinRepository.findById(id);
        medcin medcin = null;
        if(optionalMedcin.isPresent()) {
            medcin = optionalMedcin.get();
        }
        else{
            throw new RuntimeException("Medcin not found for id: " + id);
        }
        return medcin;
    }

    @Override
    public void deleteMedcinById(long id) {
        this.medcinRepository.deleteById(id);
        
    }
    
}
