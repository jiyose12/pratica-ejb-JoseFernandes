package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MensagemDAO {
  @PersistenceContext(unitName="default")
  private EntityManager em;
//Jose Raimundo Fernandes
  public void inserir(Mensagem novaMensagem){
    em.persist(novaMensagem);
  }

  public List<Mensagem> listar() {
    return em.createQuery("FROM Mensagem").getResultList();
  }

  public List<Mensagem> pesquisarPorId(long idMensagem){
    return em.createQuery("SELECT c FROM Mensagem c WHERE c.id = :idMsg")
        .setParameter("idMsg", idMensagem)
        .getResultList();
  }

}
