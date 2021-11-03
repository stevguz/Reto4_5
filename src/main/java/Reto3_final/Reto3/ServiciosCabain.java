
package Reto3_final.Reto3;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ServiciosCabain  implements Serializable{
     @Autowired
    private RepositorioCabain metodosCrud;

    public List<Cabain> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Cabain> getCabain(int cabinId) {
        return metodosCrud.getCabain(cabinId);
    }

    public Cabain save(Cabain cabin){
        if(cabin.getId()==null){
            return metodosCrud.save(cabin);
        }else{
            Optional<Cabain> e=metodosCrud.getCabain(cabin.getId());
            if(e.isEmpty()){
                return metodosCrud.save(cabin);
            }else{
                return cabin;
            }
        }
    }

   public Cabain update(Cabain cabin){
        if(cabin.getId()!=null){
            Optional<Cabain> e=metodosCrud.getCabain(cabin.getId());
            if(!e.isEmpty()){
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    e.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }

    public boolean deleteCabain(int cabinId) {
        Boolean aBoolean = getCabain(cabinId).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
