package dio.springboot.personapi.repository;

import dio.springboot.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/*Para utilizar a funcionalidade do Spring JpaRepository é necessario informar via Generics,
a classe que queremos implementar e o tipo da chave primaria*/
public interface PersonRepository extends JpaRepository<Person, Long> {


}
