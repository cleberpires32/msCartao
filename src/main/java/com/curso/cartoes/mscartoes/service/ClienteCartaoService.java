package com.curso.cartoes.mscartoes.service;

import com.curso.cartoes.mscartoes.domain.ClienteCartao;
import com.curso.cartoes.mscartoes.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartao> listaCartoesByCpf(String cpf){
        return clienteCartaoRepository.findAllByCpf(cpf);
    }
}
