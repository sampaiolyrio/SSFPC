package br.mil.ssfpc.suport;

import br.mil.ssfpc.model.entities.Pessoa;
import br.mil.ssfpc.util.FacesContextUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean(name = "bbUsuarioLogado")
@SessionScoped
public class BbUsuarioLogado implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();//quando se faz login o spring security cria um contexto para o usuário e guarda a as suas informações. 

    public BbUsuarioLogado() {
    }

    //PODEMOS DEIXAR NOSSO BACKING BEAN MAIS ENXUTO USANDO APENAS O TRECHO DE CÓDIGO ABAIXO
    public Pessoa procuraPessoa() {
        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                login = (((User) authentication.getPrincipal()).getUsername());
            }
        }
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery("from Pessoa user where user.login like ?");
        query.setString(0, login);
        return (Pessoa) query.uniqueResult();
    }
    
    /*NO PROJETO ORIGINAL FIZEMOS DA SEGUINTE FORMA
     private Pessoa usuario;
     
    public BbUsuarioLogado() {
        usuario = new Pessoa();
        SecurityContext context = SecurityContextHolder.getContext();
        if(context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if(authentication instanceof Authentication){
                usuario.setLogin(((User) authentication.getPrincipal()).getUsername()); //estou setando o objeto pessoa com o usuário logado
            }
        }
    }

    public Pessoa procuraPessoa(){
        String login = getUsuarioLogin();  
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery("from Pessoa user where user.login like ?");
        query.setString(0, login);
        return (Pessoa) query.uniqueResult();
    }

    private String getUsuarioLogin() {
        return usuario.getLogin();
    }
     */
    
}
