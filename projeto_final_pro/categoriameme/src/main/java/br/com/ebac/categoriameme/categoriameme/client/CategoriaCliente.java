package br.com.ebac.categoriameme.categoriameme.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ebac.categoriameme.categoriameme.entity.User;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class CategoriaCliente {

    @Autowired
    private CategoryMemeClient categoryMemeClient;

    @FeignClient(name = "user")
    interface CategoryMemeClient {
        @RequestMapping(path = "/usuarios", method = RequestMethod.GET)
        @ResponseBody Iterable<User> findThemAll();

        @RequestMapping(path = "/usuarios/{id}", method = RequestMethod.GET)
        @ResponseBody
        User findId(@PathVariable("id") Long id);
    }

    public Iterable<User> FindAllThem() {
        return categoryMemeClient.findThemAll();
    }

    public User FindById(Long id) {
        return categoryMemeClient.findId(id);
    }
}
