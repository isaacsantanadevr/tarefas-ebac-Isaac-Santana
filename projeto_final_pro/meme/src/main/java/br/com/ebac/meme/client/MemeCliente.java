package br.com.ebac.meme.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ebac.meme.entity.CategoriaMeme;
import br.com.ebac.meme.entity.Usuario;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class MemeCliente {

  @Autowired
  private ICategoriaCliente iCategoriaCliente;

  @Autowired
  private IUsuarioCliente iUsuarioCliente;

  @FeignClient(name = "categoria")
  interface ICategoriaCliente{
    @RequestMapping(path = "/categorias-meme", method = RequestMethod.GET)
    @ResponseBody
    Iterable<CategoriaMeme> encontrarCategorias();

    @RequestMapping(path = "/categorias-meme/{id}", method = RequestMethod.GET)
    @ResponseBody
    CategoriaMeme encontrarCategoriaPorId(@PathVariable("id") Long id);
  }

  @FeignClient(name = "usuario")
  interface IUsuarioCliente {
      @RequestMapping(path = "/usuarios", method = RequestMethod.GET)
      @ResponseBody
      Iterable<Usuario> encontrarTodosUsuarios();

      @RequestMapping(path = "/usuarios/{id}", method = RequestMethod.GET)
      @ResponseBody
      Usuario encontrarPorId(@PathVariable("id") Long id);
  }

  public Iterable<CategoriaMeme> encontrarCategorias(){
    return iCategoriaCliente.encontrarCategorias();
  }

  public Iterable<Usuario> encontrarTodosUsuarios(){
    return iUsuarioCliente.encontrarTodosUsuarios();
  }

  public CategoriaMeme EncontrarCategoriaPorID(Long id) {
    return iCategoriaCliente.encontrarCategoriaPorId(id);
  }

  public Usuario EncontrarUsuarioPorId(Long id) {
    return iUsuarioCliente.encontrarPorId(id);
  }

}
