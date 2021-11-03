/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_final.Reto3;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public class RepositorioCabain  implements Serializable{
    
    @Autowired
    private InterfaceCabain crud;

    public List<Cabain> getAll(){
        return (List<Cabain>) crud.findAll();
    }

    public Optional<Cabain> getCabain(int id){
        return crud.findById(id);
    }

    public Cabain save(Cabain cabin){
        return crud.save(cabin);
    }
    public void delete(Cabain cabin){
        crud.delete(cabin);
    }

    
}
