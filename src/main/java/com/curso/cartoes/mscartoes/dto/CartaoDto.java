package com.curso.cartoes.mscartoes.dto;

import com.curso.cartoes.mscartoes.domain.BandeiraCartao;
import com.curso.cartoes.mscartoes.domain.Cartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoDto {

    private Long id;
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal limiteBasico;
    private BigDecimal renda;

    public Cartao toModel(){
        return new Cartao(nome, bandeira,limiteBasico, renda);
    }

    public static CartaoDto fromModel(Cartao model){
        return new CartaoDto(model.getId(),model.getNome(),model.getBandeira(),model.getLimiteBasico(),model.getRenda());
    }

}
