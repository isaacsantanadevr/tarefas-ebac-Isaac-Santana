package br.com.ebac.meme.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ebac.meme.client.MemeCliente;
import br.com.ebac.meme.entity.CategoriaMeme;
import br.com.ebac.meme.entity.Meme;
import br.com.ebac.meme.entity.Usuario;
import br.com.ebac.meme.service.MemelandiaServico;

@RestController
@RequestMapping(path = "/memelandia")
public class MemelandiaController {

    private static final Logger logger = LoggerFactory.getLogger(MemelandiaController.class);

    private final MemelandiaServico memelandiaServico;

    @Autowired
    private MemeCliente memeCliente;

    public MemelandiaController(MemelandiaServico memelandiaServico) {
        this.memelandiaServico = memelandiaServico;
    }

    @GetMapping
    public Iterable<Meme> encontrarTodosMemes() {
        logger.info("Encontrando todos memes: ");
        Iterable<Meme> memes = memelandiaServico.acharTodosMemes();
        long count = StreamSupport.stream(memes.spliterator(), false).count();
        logger.info("{} memes encontrados", count);
        return memes;
    }

    @PostMapping
    public Meme criarMeme(@RequestBody Meme meme) {
        logger.info("Criando novo meme: {}", meme);
        Long usuarioId = meme.getUsuarioId();
        Long categoriaMemeId = meme.getCategoriaMemeId();
        Usuario usuario = memeCliente.EncontrarUsuarioPorId(usuarioId);
        CategoriaMeme categoriaMeme = memeCliente.EncontrarCategoriaPorID(categoriaMemeId);
        if (usuario == null || categoriaMeme == null) {
            logger.warn("Usuario ou categoria nao foi encontrado para o meme: {}", meme);
            return null;
        }
        meme.setUsuarioId(usuario.getId());
        meme.setCategoriaMemeId(categoriaMeme.getId());
        Meme novoMeme = memelandiaServico.criarMeme(meme);
        logger.info("Meme criado: {}", novoMeme);
        return novoMeme;
    }

    @GetMapping("/categorias-meme")
    public Iterable<CategoriaMeme> encontrarTodasCategorias() {
        logger.info("Encontrando categorias");
        Iterable<CategoriaMeme> categorias = memeCliente.encontrarCategorias();
        long count = StreamSupport.stream(categorias.spliterator(), false).count();
        logger.info("Encontradas {} categorias", count);
        return categorias;
    }

    @GetMapping("/usuarios")
    public Iterable<Usuario> encontrarTodosUsuarios() {
        logger.info("Encontrando usuarios");
        Iterable<Usuario> usuarios = memeCliente.encontrarTodosUsuarios();
        long count = StreamSupport.stream(usuarios.spliterator(), false).count();
        logger.info("{} usuarios foram encontrados", count);
        return usuarios;
    }

    @GetMapping("/meme-do-dia")
    public Meme encontrarMemeDoDia() {
        logger.info("Meme do dia");
        List<Meme> todosOsMemes = StreamSupport.stream(memelandiaServico.acharTodosMemes().spliterator(), false)
                .collect(Collectors.toList());
        if (todosOsMemes.isEmpty()) {
            logger.warn("Nenhum meme encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum meme foi encontrado no nosso banco de dados");
        }
        Collections.shuffle(todosOsMemes);
        Meme memeDoDia = todosOsMemes.get(0);
        logger.info("Meme encontrado: {}", memeDoDia);
        return memeDoDia;
    }
}
