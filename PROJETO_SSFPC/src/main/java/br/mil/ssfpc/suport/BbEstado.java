package br.mil.ssfpc.suport;

import br.mil.ssfpc.model.dao.HibernateDAO;
import br.mil.ssfpc.model.dao.InterfaceDAO;
import br.mil.ssfpc.model.entities.Estado;
import br.mil.ssfpc.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbEstado")
@RequestScoped
public class BbEstado  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public List<Estado> getEstados() {
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO.getEntities();
    }	
}