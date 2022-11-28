package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido status);

    //Metodo JPA Puro, com class e nao interface
    //Crio um persistenceContext no EntityManager, para fazer as requisicoes (Ex, JPA puro)
//    @PersistenceContext
//    private EntityManager entityManager;
    //Esse metodo e de JPA Puro, para fazer o mesmo com spring data Jpa, basta usar um findAll() que ele ira entender
//    public List<Pedido> recuperaTodosOsPedidos(){
//        //Query para fazer uma consulta (Ex, JPA puro)
//        Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
//        return query.getResultList();
//    }

}
