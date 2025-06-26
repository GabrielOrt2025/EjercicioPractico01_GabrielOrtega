/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.farmacia.controller;

import com.farmacia.domain.Farmacia;
import com.farmacia.service.FarmaciaService;
// import tienda.com.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {
    
    @Autowired
    private FarmaciaService farmaciaService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
    var farmacias = farmaciaService.findAll();
    model.addAttribute("farmacias", farmacias);
    model.addAttribute("totalFarmacias", farmacias.size());
    model.addAttribute("farmacia", new Farmacia());  
    return "/farmacia/listado";
    }

    @GetMapping("/nuevo")
    public String farmaciaNuevo(Farmacia farmacia) {
        return "/farmacia/modifica";
    }

    // @Autowired
    // private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String farmaciaGuardar(Farmacia farmacia,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            farmaciaService.save(farmacia);

            // Comentado: lógica para subir la imagen a Firebase
            /*
            arbol.setImagenRuta(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "arbol", 
                            arbol.getId()));
            */
        }
        farmaciaService.save(farmacia);
        return "redirect:/farmacia/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String farmaciaEliminar(Farmacia farmacia) {
        farmaciaService.delete(farmacia);
        return "redirect:/farmacia/listado";
    }

    @GetMapping("/modificar/{id}")
    public String farmaciaModificar(Farmacia farmacia, Model model) {
        farmacia = farmaciaService.getFarmacia(farmacia);
        model.addAttribute("farmacia", farmacia);
        return "/farmacia/modifica";
    }   

}
