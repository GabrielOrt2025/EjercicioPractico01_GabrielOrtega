/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.farmacia.service.impl;

import com.farmacia.dao.FarmaciaDao;
import com.farmacia.domain.Farmacia;
import com.farmacia.service.FarmaciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FarmaciaServiceImpl implements FarmaciaService{
    
    @Autowired
    private FarmaciaDao farmaciaDao;


    @Override
    @Transactional(readOnly = true)
    public Farmacia getFarmacia(Farmacia farmacia) {
        return farmaciaDao.findById(farmacia.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Farmacia farmacia) {
        farmaciaDao.save(farmacia);
    }

    @Override
    @Transactional
    public void delete(Farmacia farmacia) {
        farmaciaDao.delete(farmacia);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Farmacia> findAll() {
        return farmaciaDao.findAll();
    }

}
