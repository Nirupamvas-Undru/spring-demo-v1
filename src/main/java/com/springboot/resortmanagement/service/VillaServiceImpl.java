package com.springboot.resortmanagement.service;

import com.springboot.resortmanagement.entity.Villa;
import com.springboot.resortmanagement.repository.VillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class VillaServiceImpl implements VillaService{

    @Autowired
    private VillaRepository villaRepository;

    @Override
    @Transactional
    public List<Villa> findAll() {
        return villaRepository.findAll();
    }

    @Override
    @Transactional
    public Villa findById(int theId) {
        Optional<Villa> result = villaRepository.findById(theId);

        Villa theVilla = null;
        if(result.isPresent()){
            theVilla = result.get();
        }else{
            throw new RuntimeException("The Villa with given ID " + theId + "is not present in the database");
        }
        return theVilla;
    }

    @Override
    @Transactional
    public void save(Villa theVilla) {
        villaRepository.save(theVilla);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        villaRepository.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Villa> findVillas(int theId) {
        return villaRepository.findVillas(theId);
    }
}
