package com.ebac.test;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrincipalTeste{

    @Test
    public void TestaMulheres(){
        List<Pessoas> pessoa = new Pessoas().ListaDePessoas();

        List<Pessoas> mulheres = pessoa.stream()
                                        .filter(mulher -> mulher.getGen().equals("Mulher"))
                                        .collect(Collectors.toList());

        for(Pessoas mulher : mulheres){
            assertEquals("Mulher", mulher.getGen());
        }
    }

}
