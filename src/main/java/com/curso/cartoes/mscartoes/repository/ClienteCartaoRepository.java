package com.curso.cartoes.mscartoes.repository;

import com.curso.cartoes.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {
    List<ClienteCartao> findAllByCpf(String cpf);
}
