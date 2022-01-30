package dio.springboot.personapi.service;

import dio.springboot.personapi.dto.request.PersonDTO;
import dio.springboot.personapi.dto.response.MessageResponseDTO;
import dio.springboot.personapi.entity.Person;
import dio.springboot.personapi.repository.PersonRepository;
import dio.springboot.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static dio.springboot.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    
    @Mock
    private PersonRepository personRepository;
    
    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSaveMessage() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedPerson = createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedPerson.getId());
        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, sucessMessage);
    }


    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+ id)
                .build();
    }
}
