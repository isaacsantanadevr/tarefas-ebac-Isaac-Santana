package main.dao.generics;

import main.anotacao.TipoChave;
import main.domain.Persistente;
import main.exceptions.TipoChaveNaoEncontradaException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

public class GenericDao <T extends Persistente> implements IGenericDAO<T>{

    private SingletonMap singletonMap;

    public Class<T> getTipoClasse() {
        return null;
    }

    public void atualizarDados(T entity, T entityCadastrado) {

    }

    public GenericDao(){
        this.singletonMap = SingletonMap.getInstance();
    }

    public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (Long) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave Principal " + entity.getClass() + "nao encontrada", e);
                }
            }
        }
        if (returnValue == null){
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("ERRO " + msg);
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        return null;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public T consultar(Long valor) {
        return null;
    }

    @Override
    public Collection<T> buscarTodos() {
        return null;
    }
}
