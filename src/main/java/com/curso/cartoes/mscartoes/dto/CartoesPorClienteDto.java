package com.curso.cartoes.mscartoes.dto;

import com.curso.cartoes.mscartoes.domain.BandeiraCartao;
import com.curso.cartoes.mscartoes.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartoesPorClienteDto {

    private String nome;
    private String bandeira;
    private BigDecimal limite;

    public static CartoesPorClienteDto fromModel(ClienteCartao model){
        return new CartoesPorClienteDto(model.getCartao().getNome(),model.getCartao().getBandeira().toString(),model.getLimite());
    }
}
