package co.entrar.exam.ConverterModule.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import co.entrar.exam.ConverterModule.model.*;
public interface QRCodeRepository extends MongoRepository<QRCode, String> {

	
}
