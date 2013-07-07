package br.mil.ssfpc.suport;

import br.mil.ssfpc.model.dao.HibernateDAO;
import br.mil.ssfpc.model.dao.InterfaceDAO;
import br.mil.ssfpc.model.entities.Sexo;
import br.mil.ssfpc.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbSexo")
@RequestScoped
public class BbSexo  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Sexo> getSexos(){
        InterfaceDAO<Sexo> sexoDAO = new HibernateDAO<Sexo>(Sexo.class, FacesContextUtil.getRequestSession());
        return sexoDAO.getEntities();
    }
    
}
