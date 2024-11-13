package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CasoJudicialService;
import com.example.demo.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {
   
    @Autowired
    private final CasoJudicialService casoJudicialService;

    
    public CasoJudicialController(CasoJudicialService service)
    {
        casoJudicialService = service;
    }

    @GetMapping
    public ResponseEntity<List<CasoJudicial>> pegarTodosCasos() {
       List<CasoJudicial> casos = casoJudicialService.getTodosOsCasos();
       return ResponseEntity.ok(casos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoJudicial> pegarCaso(@PathVariable Long id) {
       CasoJudicial casoJudicial = casoJudicialService.getCasoJudicial(id);
       return ResponseEntity.ok(casoJudicial);
    }
    
    @PostMapping
    public ResponseEntity<CasoJudicial> criarCaso(@RequestBody CasoJudicial novoCaso)
    {
        casoJudicialService.adicionarCaso(novoCaso);
        CasoJudicial adicionado = casoJudicialService.getCasoJudicial(novoCaso.getId());
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(adicionado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCaso(@PathVariable Long id)
    {
        casoJudicialService.deletarCasoJudicial(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Deletado com sucesso");
        
    }


}
