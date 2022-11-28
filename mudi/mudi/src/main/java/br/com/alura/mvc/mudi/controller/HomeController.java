package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public String home(Model model){

        List<Pedido> listaPedidos = repository.findAll();
        model.addAttribute("pedidos", listaPedidos);

        return "home";
    }

    //crio um get que recebe apos o /home o valor de status (/home/{status} se aguardando -> /home/aguardando)
    //tenho que passar no objeto porStatus o @PathVariable com o atributo status, que dix que esse valor sera coletado
    @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model){
        //Aqui foi criado o findByStatus, uma nova classe no repository, que recebe um status. No caso aqui esta sendo passado o valor dele em string em caixa alta
        List<Pedido> listaPedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", listaPedidos);
        //inserido um novo atributo, para mudar o active do menu
        model.addAttribute("status",status);
        return "home";
    }
    //para evitar o erro, caso o usuario escreva uma rota diferente do enum StatusPedido, ele volta pra /home
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
