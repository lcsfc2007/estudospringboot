package com.example.demo.service;

import java.util.List;
import com.example.demo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService {

    @Autowired
    private CasoJudicialRepository repository;

    public CasoJudicialService(CasoJudicialRepository repository)
    {
        this.repository = repository;
        this.repository.add(new CasoJudicial(1L, "processo 1", "SP"));
        this.repository.add(new CasoJudicial(2L, "processo 2", "MG"));
        this.repository.add(new CasoJudicial(3L, "processo 3", "RS"));
        this.repository.add(new CasoJudicial(4L, "processo 4", "SP"));
    
    }

    public List<CasoJudicial> getTodosOsCasos()
    {
        return repository.findAll();
    }

    public void adicionarCaso(CasoJudicial casoJudicial)
    {
        repository.add(casoJudicial);
    }

    public CasoJudicial getCasoJudicial(Long Id)
    {
        return repository.getById(Id);
    }

    public void deletarCasoJudicial(Long Id)
    {
        repository.delete(Id);
    }

}
