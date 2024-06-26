package br.com.fiap.lanchonete.core.application.services;

import br.com.fiap.lanchonete.core.application.exceptions.RegraNegocioException;
import br.com.fiap.lanchonete.core.application.ports.ClienteServicePort;
import br.com.fiap.lanchonete.core.application.ports.PedidoServicePort;
import br.com.fiap.lanchonete.core.application.ports.ProdutoServicePort;
import br.com.fiap.lanchonete.core.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.core.domain.dtos.PedidoResponseDto;
import br.com.fiap.lanchonete.core.domain.dtos.ProdutoDto;
import br.com.fiap.lanchonete.core.domain.repositories.ClienteRepositoryPort;
import br.com.fiap.lanchonete.core.domain.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.core.domain.repositories.ProdutoRepositoryPort;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoServiceImpl implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepository;
    private final ProdutoServicePort produtoService;
    private final ClienteServicePort clienteService;

    public PedidoServiceImpl(PedidoRepositoryPort pedidoRepository, ClienteRepositoryPort clienteRepository, ProdutoRepositoryPort produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = new ClienteServiceImpl(clienteRepository);
        this.produtoService = new ProdutoServiceImpl(produtoRepository);
    }

    @Override
    public PedidoResponseDto save(PedidoDto pedidoDto) {
        BigDecimal valorPedido = BigDecimal.ZERO;
        AtomicInteger comboNum = new AtomicInteger(1);

        boolean clienteInformado = pedidoDto.getCpfCliente() != null && !pedidoDto.getCpfCliente().isEmpty();
        var clienteEntity = clienteInformado ? clienteService.findByCpfCliente(pedidoDto.getCpfCliente()) : null;

        if (clienteInformado && clienteEntity == null){
            throw new RegraNegocioException("Cliente não localizado");
        }
        
        for (var p : Optional.ofNullable(pedidoDto.getProdutos()).orElse(Collections.emptyList())){
            Optional<ProdutoDto> lancheOptional = p.possuiLanche() ? produtoService.findByIdProduto(p.getLanche().getId()) : Optional.empty();
            Optional<ProdutoDto> sobremesaOptional = p.possuiSobremesa() ? produtoService.findByIdProduto(p.getSobremesa().getId()) : Optional.empty();
            Optional<ProdutoDto> bebidaOptional = p.possuiBebida() ? produtoService.findByIdProduto(p.getBebida().getId()) : Optional.empty();
            Optional<ProdutoDto> acompanhamentoOptional = p.possuiAcompanhamento() ? produtoService.findByIdProduto(p.getAcompanhamento().getId()) : Optional.empty();
            
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
                valorPedido = valorPedido.add(p.getLanche().getPreco());
            }

            if (p.possuiSobremesa()){
                p.getSobremesa().setPreco(sobremesaOptional.get().getPreco());
                valorPedido = valorPedido.add(p.getSobremesa().getPreco());
            }

            if (p.possuiBebida()){
                p.getBebida().setPreco(bebidaOptional.get().getPreco());
                valorPedido = valorPedido.add(p.getBebida().getPreco());
            }

            if (p.possuiAcompanhamento()){
                p.getAcompanhamento().setPreco(acompanhamentoOptional.get().getPreco());
                valorPedido = valorPedido.add(p.getAcompanhamento().getPreco());
            }

            p.setComboNum(comboNum.getAndIncrement());

        }

        pedidoDto.setValor(valorPedido);

        return pedidoRepository.save(pedidoDto);
    }
    @Override
    public List<PedidoDto> findAll() {
        return pedidoRepository.findAll();
    }
    @Override
    public List<PedidoResponseDto> findAllComProdutos() {
        return pedidoRepository.findAllComProdutos();
    }
}
