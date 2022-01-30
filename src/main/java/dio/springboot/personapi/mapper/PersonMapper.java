package dio.springboot.personapi.mapper;

import dio.springboot.personapi.dto.request.PersonDTO;
import dio.springboot.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    /*Resolvendo o problema da diferença entre os tipos de dados
    entre as variaveis birthDate na classe Person e na PersonDTO, com mapstruct*/
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
