package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")
    //Outro modo de mandar um action para uma view, sem ser com request do servlet, e usando a classe model do spring, basta colocar na criacao do  metodo o Model model
    // e depois usar ele para tratar um addAttribute por exemplo
    public String home(Model model){
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Readmi Note 8");
        pedido.setUrlImagem("https://http2.mlstatic.com/D_NQ_NP_620994-MLA40022201594_122019-O.webp");
        pedido.setUrlProduto("https://www.mercadolivre.com.br/xiaomi-redmi-note-8-pro-dual-sim-128-gb-forest-green-8-gb-ram/p/MLB15239262?pdp_filters=category:MLB1055#searchVariation=MLB15239262&position=1&search_layout=stack&type=product&tracking_id=26373347-3873-40a9-bafc-6585b6f915ad");
        pedido.setDescricao("aleatorio");

        //crio uma Array do tipo list, que recebe objetos do tipo Pedido, eu passo para dentro array como list, se eu colocar vaiors "pedido" dentro do
        //asList ele ira rederizar todos no home.html, pq la eu passei um th:each de um atributo que chamei de pedidos, em model.addAttribute
        List<Pedido> listaPedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", listaPedidos);

        return "home";
    }

}
