package in.as.sixtynine.rakku.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.as.sixtynine.rakku.dtos.EntryDto;
import in.as.sixtynine.rakku.entities.Entry;
import org.springframework.stereotype.Service;

/**
 * @Author Sanjay Das (s0d062y), Created on 02/01/22
 */


@Service
public class EntryMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public EntryDto toDto(Entry entry) {
        return objectMapper.convertValue(entry, EntryDto.class);
    }

}
