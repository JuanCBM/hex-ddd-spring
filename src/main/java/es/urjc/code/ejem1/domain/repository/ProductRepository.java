package es.urjc.code.ejem1.domain.repository;

import es.urjc.code.ejem1.domain.FullProductDTO;
import java.util.Collection;

public interface ProductRepository {
	Collection<FullProductDTO> finAll();

	FullProductDTO findById(Long id);

	FullProductDTO save(FullProductDTO product);

	void deleteById(Long id);
}
