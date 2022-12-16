package com.curso.cartoes.mscartoes.resource;

import com.curso.cartoes.mscartoes.domain.Cartao;
import com.curso.cartoes.mscartoes.domain.ClienteCartao;
import com.curso.cartoes.mscartoes.dto.CartaoDto;
import com.curso.cartoes.mscartoes.dto.CartoesPorClienteDto;
import com.curso.cartoes.mscartoes.service.CartaoService;
import com.curso.cartoes.mscartoes.service.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartaoResource {

    public final CartaoService cartaoService;
    public final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "Ok";
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody CartaoDto cartaoDto) {
           var cartao = cartaoDto.toModel();
            cartaoService.save(cartao);
            URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("bandeira={bandeira}").buildAndExpand(cartao.getBandeira()).toUri();
            return ResponseEntity.created(headerLocation).build();
        }

    @GetMapping(params = "renda")
    public ResponseEntity<List<CartaoDto>> getCartoesComRendaAteh(@RequestParam Long renda){
        List<Cartao> listCartao = cartaoService.getCartoes(renda);
        List<CartaoDto> resultList = listCartao.stream().map(CartaoDto::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteDto>> getCartoesPorCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> listaCartaoCliente = clienteCartaoService.listaCartoesByCpf(cpf);
        List<CartoesPorClienteDto> resultiList = listaCartaoCliente.stream().map(CartoesPorClienteDto::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(resultiList);
    }
}
