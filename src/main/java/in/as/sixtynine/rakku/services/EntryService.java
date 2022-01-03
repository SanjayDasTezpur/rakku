package in.as.sixtynine.rakku.services;

import in.as.sixtynine.rakku.dtos.EntryDto;
import in.as.sixtynine.rakku.entities.Entry;
import in.as.sixtynine.rakku.mappers.EntryMapper;
import in.as.sixtynine.rakku.repositories.EntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Sanjay Das (s0d062y), Created on 02/01/22
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class EntryService {

    private final EntryRepository entryRepository;
    private final EntryMapper mapper;

    public EntryDto getLast(String type) {
        final Entry lastEntry = entryRepository.getLastEntry(type);
        return mapper.toDto(lastEntry);
    }
}
