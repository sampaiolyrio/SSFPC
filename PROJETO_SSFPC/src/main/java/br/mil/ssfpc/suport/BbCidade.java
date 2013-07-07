package br.mil.ssfpc.suport;

import br.mil.ssfpc.model.dao.HibernateDAO;
import br.mil.ssfpc.model.dao.InterfaceDAO;
import br.mil.ssfpc.model.entities.Cidade;
import br.mil.ssfpc.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbCidade")
@RequestScoped
public class BbCidade  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Cidade> cidades;

    public List<Cidade> getCidades() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO.getEntities();
    }
}
