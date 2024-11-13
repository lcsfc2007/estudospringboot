package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class TaxaJudicial {
    public double adicionarTaxa(String estado)
    {
        if(estado.equals("DF"))
        {
            return 0;
        }
        return 10;
    }
}
