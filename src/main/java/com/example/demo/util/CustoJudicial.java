package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class CustoJudicial {
    public double adicionarCusto(int ano)
    {
        return 10*(2024-ano);
    }
}
