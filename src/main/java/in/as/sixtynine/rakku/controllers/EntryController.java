package in.as.sixtynine.rakku.controllers;

import in.as.sixtynine.rakku.dtos.EntryDto;
import in.as.sixtynine.rakku.services.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sanjay Das (s0d062y), Created on 02/01/22
 */

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EntryController {

    private final EntryService entryService;

    @GetMapping("/entry")
    public EntryDto lastEntry(@RequestParam("type") String type) {
        return entryService.getLast(type);
    }
}
