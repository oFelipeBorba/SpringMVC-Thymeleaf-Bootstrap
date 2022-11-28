package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicaoNovoPedido){
        return "pedido/formulario";
    }
    //Ao criar um post e passar um objeto 'requisicao' para ele, estamos colocando os valores
    //obtidos na requisicao dentro desse objeto. (O nome dos atributos dessa classe que e usada
    // para criar esse objeto, devem ser os mesmos dos nomes do formulario que faz o post)
    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result){
        //Foram colocados na classe ReqNovoPedido o @NotBlank, isso e uma validacao, sendo assim foi
        //adicionado o @Valid no obj criado nesse metodo novo, e foi criado um obj result do tipo BindingResult
        //ele que faz a verificacao de validacao, caso encontre um erro eu coloquei um return para pedido/formulario
        if(result.hasErrors()){
            return "pedido/formulario";
        }
        Pedido pedido = requisicaoNovoPedido.toPedido();
        pedidoRepository.save(pedido);
        return "pedido/formulario";
    }

}
