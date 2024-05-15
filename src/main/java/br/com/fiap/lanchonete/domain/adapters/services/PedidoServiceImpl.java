package br.com.fiap.lanchonete.domain.adapters.services;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.dtos.ProdutoCheckoutDto;
import br.com.fiap.lanchonete.domain.dtos.ProdutoDto;
import br.com.fiap.lanchonete.domain.ports.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.domain.ports.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infrastructure.exceptions.RegraNegocioException;

@Service
public class PedidoServiceImpl implements PedidoServicePort {

    @Autowired
    private PedidoRepositoryPort pedidoRepositoryPort;

    @Autowired
    private ProdutoServicePort produtoService;

    @Override
    public PedidoDto save(PedidoDto pedidoDto) {
        BigDecimal valorPedido = BigDecimal.ZERO;
        AtomicInteger comboNum = new AtomicInteger(1);
        Optional.ofNullable(pedidoDto.getProdutos()).orElse(Collections.emptyList()).forEach(p->{
            Optional<ProdutoDto> lancheOptional = produtoService.findByIdProduto(p.getLanche().getId());
            Optional<ProdutoDto> sobremesaOptional = produtoService.findByIdProduto(p.getSobremesa().getId());
            Optional<ProdutoDto> bebidaOptional = produtoService.findByIdProduto(p.getBebida().getId());
            Optional<ProdutoDto> acompanhamentoOptional = produtoService.findByIdProduto(p.getAcompanhamento().getId());
            
            boolean lancheValido = !p.possuiLanche() || (lancheOptional.isPresent() && lancheOptional.get().isLanche());

            boolean sobremesaValido = !p.possuiSobremesa() || (sobremesaOptional.isPresent() && sobremesaOptional.get().isSobremesa());

            boolean bebidaValido = !p.possuiBebida() || (bebidaOptional.isPresent() && bebidaOptional.get().isBebida());

            boolean acompanhamentoValido = !p.possuiAcompanhamento() || (acompanhamentoOptional.isPresent() && acompanhamentoOptional.get().isAcompanhamento());

            if (!(p.possuiLanche() || p.possuiSobremesa() || p.possuiBebida() || p.possuiAcompanhamento())){
                throw new RegraNegocioException("É obrigatório ao menos um item no combo");
            }

            if (!(lancheValido && sobremesaValido && bebidaValido && acompanhamentoValido)){
                throw new RegraNegocioException("Produtos inválidos ou inativos");
            }

            if (p.possuiLanche()){
                p.getLanche().setPreco(lancheOptional.get().getPreco());
                valorPedido.add(p.getLanche().getPreco());
            }

            if (p.possuiSobremesa()){
                p.getSobremesa().setPreco(sobremesaOptional.get().getPreco());
                valorPedido.add(p.getSobremesa().getPreco());
            }

            if (p.possuiBebida()){
                p.getBebida().setPreco(bebidaOptional.get().getPreco());
                valorPedido.add(p.getBebida().getPreco());
            }

            if (p.possuiAcompanhamento()){
                p.getAcompanhamento().setPreco(acompanhamentoOptional.get().getPreco());
                valorPedido.add(p.getAcompanhamento().getPreco());
            }

            p.setComboNum(comboNum.getAndIncrement());

        });

        pedidoDto.setValor(valorPedido);

        return pedidoRepositoryPort.save(pedidoDto);
    }
    @Override
    public List<PedidoDto> findAll() {
        return pedidoRepositoryPort.findAll();
    }
}
