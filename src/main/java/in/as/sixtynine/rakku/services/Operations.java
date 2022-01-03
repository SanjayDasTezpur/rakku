package in.as.sixtynine.rakku.services;

import in.as.sixtynine.rakku.entities.Entry;
import in.as.sixtynine.rakku.enums.ETypes;
import in.as.sixtynine.rakku.repositories.EntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author Sanjay Das (s0d062y), Created on 01/01/22
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class Operations {
    private static final Random random = new Random();
    private static final long DEFAULT_DURATION = TimeUnit.HOURS.toMillis(1);

    private final EntryRepository entryRepository;

    public void randomEntry(ETypes eType) {
        try {
            final Entry lastEntry = entryRepository.getLastEntry(eType.name());
            if (Objects.nonNull(lastEntry) && lastEntry.getExpirytime() > System.currentTimeMillis()) {
                log.info("Last entry not expired yet....");
                return;
            }
            log.info("Generating new entry...");
            val newData = new Entry();
            newData.setStarttime(System.currentTimeMillis());
            newData.setExpirytime(newData.getStarttime() + DEFAULT_DURATION);
            newData.setType(eType.name());
            newData.setValue(random.nextInt(99));
            entryRepository.save(newData);
        } catch (Exception e) {
            log.error("Error while saving entry[type={}] = {}", eType, e.getMessage());
        }
    }
}
