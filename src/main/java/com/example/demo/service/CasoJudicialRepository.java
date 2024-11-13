package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.util.*;

@Component
public class CasoJudicialRepository {
        private List<CasoJudicial> casosJudiciais=new ArrayList<CasoJudicial>();

        public List<CasoJudicial> findAll()
        {
            return casosJudiciais;
        }

        public void add(CasoJudicial casoJudicial)
        {
            if(getById(casoJudicial.getId())!=null)
                return;
            casosJudiciais.add(casoJudicial);
        }

        public CasoJudicial getById(Long Id)
        {
            for (CasoJudicial x: casosJudiciais)
            {
                if(x.getId() == Id)
                {
                    return x;
                }
            }
            return null;
        }

        public void delete(Long Id)
        {
            CasoJudicial caso = getById(Id);
            casosJudiciais.remove(caso);
        }


}
