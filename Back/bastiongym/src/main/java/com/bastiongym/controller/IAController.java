package com.bastiongym.controller;

import com.bastiongym.dto.IAInput;
import com.bastiongym.dto.IAOutput;
import com.bastiongym.service.IAService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ia")
public class IAController {

    private final IAService iaService;

    public IAController(IAService iaService) {
        this.iaService = iaService;
    }

    // Conversar com a IA
    @PostMapping("/perguntar")
    public IAOutput perguntar(@RequestBody IAInput input) {
        return iaService.perguntar(input);
    }
}