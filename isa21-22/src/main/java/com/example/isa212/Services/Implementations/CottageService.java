package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Repositories.CottageRepository;
import com.example.isa212.Services.IServices.ICottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageService implements ICottageService {

    @Autowired
    private CottageRepository cottageRepository;

    @Override
    public List<Cottage> findAll() {
        return cottageRepository.findAll();
    }

    @Override
    public Cottage findOneByid_cottage(int id) {
        return null;
    }

    @Override
    public List<Cottage> sortByNameAsc(List<Cottage> cottages) {
        List<Cottage> cotagesNameAsc = cottageRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return cotagesNameAsc;


    }

    @Override
    public List<Cottage> sortByNameDesc(List<Cottage> cottages) {
        List<Cottage> cotagesNameDesc = cottageRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        return cotagesNameDesc;
    }

    @Override
    public List<Cottage> sortByAddressAsc(List<Cottage> cottages) {
        List<Cottage> cotagesAddressAsc = cottageRepository.findAll(Sort.by(Sort.Direction.ASC, "address"));
        return cotagesAddressAsc;
    }

    @Override
    public List<Cottage> sortByAddressDesc(List<Cottage> cottages) {
        List<Cottage> cotagesAddressDesc = cottageRepository.findAll(Sort.by(Sort.Direction.DESC, "address"));
        return cotagesAddressDesc;
    }

    @Override
    public List<Cottage> sortByGradeAsc(List<Cottage> cottages) {
        List<Cottage> cotagesGradeAsc = cottageRepository.findAll(Sort.by(Sort.Direction.ASC, "grade"));
        return cotagesGradeAsc;
    }

    @Override
    public List<Cottage> sortByGradeDesc(List<Cottage> cottages) {
        List<Cottage> cotagesGradeDesc = cottageRepository.findAll(Sort.by(Sort.Direction.DESC, "grade"));
        return cotagesGradeDesc;
    }

    @Override
    public List<Cottage> findAll(Sort sort) {
        return null;
    }
}
