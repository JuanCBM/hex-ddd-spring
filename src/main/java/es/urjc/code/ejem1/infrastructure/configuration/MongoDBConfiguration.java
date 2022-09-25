package es.urjc.code.ejem1.infrastructure.configuration;

import es.urjc.code.ejem1.infrastructure.repository.mongo.SpringDataMongoProductRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoProductRepository.class)
public class MongoDBConfiguration {
}