package in.as.sixtynine.rakku.services;

import in.as.sixtynine.rakku.enums.ETypes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Slf4j
@Service
@RequiredArgsConstructor
public class Scheduler {

    private final Operations ops;

    @Scheduled(fixedDelayString = "${Scheduler.randomEntry:3600000}")
    public void randomEntry() {
        log.info("randomEntry() - Starting scheduler ");
        Arrays.stream(ETypes.values()).forEach(ops::randomEntry);
    }

}
