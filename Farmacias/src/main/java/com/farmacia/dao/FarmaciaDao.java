/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.farmacia.dao;

import com.farmacia.domain.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmaciaDao extends JpaRepository<Farmacia, Long>{
    

}
