package ms.com.marvel.developer.bd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface BitacoraAccesoApiRepositoryDao extends CrudRepository<BitacoraAccesoApiEntity, Long>  {
	
}
