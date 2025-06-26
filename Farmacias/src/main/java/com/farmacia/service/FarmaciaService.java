/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.farmacia.service;

import com.farmacia.domain.Farmacia;
import java.util.List;

public interface FarmaciaService {
    
    public List<Farmacia> findAll();
    // Obtiene una lista de árboles, con opción a filtrar por si están activos

    // Obtiene un árbol específico a partir de su ID
    public Farmacia getFarmacia(Farmacia farmacia);
    

    // Guarda un nuevo árbol o actualiza uno existente
    public void save(Farmacia farmacia);

    // Elimina un árbol por ID
    public void delete(Farmacia farmacia);
}
