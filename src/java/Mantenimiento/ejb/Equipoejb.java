package Mantenimiento.ejb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Mantenimiento.entity.Equipo;
import com.sun.org.glassfish.gmbal.ParameterNames;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mario
 */
@Path("Equipoejb")
public class Equipoejb {
    
    
    private Integer currentOrder;
    private Integer newOrderId;
    private String selectedNombre;
    private char newOrderStatus;
    private int newOrderDiscount;
    
    private List<String> EquiposSearchResults;
    private String EquipoName;
    private int selectedPartRevision;
    private Long selectedVendorPartNumber;
    private Boolean findequipobleDisabled = false;
    private Boolean partsTableDisabled = true;
    @PersistenceContext
    private EntityManager em;
    
     private static final Logger logger =
            Logger.getLogger("mantenimiento.ejb.equipoEjb");
 
    
     
    @GET
    @Produces("text")
    @Path("/buscarNombre")
    public List<String> buscarEquipoPorNombre(@PathParam("name") String name) {
        
        List<String> names = new ArrayList<>();
        try {
            List equipos = em.createNamedQuery(
                    "Equipo.findByNombreEquipo")
                    .setParameter("name", name)
                    .getResultList();
            for (Iterator iterator = equipos.iterator(); iterator.hasNext();) {
                Equipo equipo = (Equipo)iterator.next();
                names.add(equipo.getNombreEquipo());
            }
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return names;
    }
    
    @GET
    @Path("Equipos")
    public List<Equipo> getEquipos() {
        try {
            return (List<Equipo>) em.createNamedQuery("findAll").getResultList();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
}
