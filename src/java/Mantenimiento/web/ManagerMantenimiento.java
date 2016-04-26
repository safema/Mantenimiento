package Mantenimiento.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import Mantenimiento.ejb.Equipoejb;
import Mantenimiento.entity.Equipo;

/**
 *
 * @author mario
 */
@ManagedBean
@SessionScoped
public class ManagerMantenimiento implements Serializable {   
    private static final long serialVersionUID = 2142383151318489373L;
    @EJB
    private Equipoejb equipo;
    private Boolean findEquipoTableDisabled = false;
    private List<String> EquipoSearchResults;
    private List<Equipo> equipos;
    private String equipoName;
    private static final Logger logger = Logger.getLogger("mantenimiento.web.Managermantenimiento");    
        
    public void findAsociado() {
        try {
            this.findEquipoTableDisabled = true;
            this.EquipoSearchResults = (List<String>) equipo.buscarEquipoPorNombre(equipoName);
            logger.log(Level.INFO, "Found {0} vendor(s) using the search string {1}.", 
                    new Object[]{EquipoSearchResults.size(), equipoName});
        } catch (Exception e) {
            logger.warning("Problem calling RequestBean.locateEquipoByName from findEquipo");
        }
    }
    
    
    public List<Equipo> getEquipos() {
        try {
            this.equipos = equipo.getEquipos();
        } catch (Exception e) {
            logger.warning("Couldn't get equipos.");
        }
        return equipos;
    }

    
    
    
}