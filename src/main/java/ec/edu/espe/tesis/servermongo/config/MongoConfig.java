package ec.edu.espe.tesis.servermongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "crud_user";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://admin:admin@cluster0.ujo2skv.mongodb.net/?retryWrites=true&w=majority");
    }
/*    mongodb+srv://admin:<password>@cluster0.ujo2skv.mongodb.net/?retryWrites=true&w=majority*/
    @Override
    public boolean autoIndexCreation() {
        return true;
    }

    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory,
                                                       MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
        MappingMongoConverter converter
                = super.mappingMongoConverter(databaseFactory, customConversions, mappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }
}
