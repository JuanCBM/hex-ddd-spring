package es.urjc.code.ejem1.infrastructure.repository.mongo;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoProductRepository extends MongoRepository<ProductDocument, UUID> {

}
