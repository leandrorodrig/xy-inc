package br.eti.webstuff.fiveware.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.eti.webstuff.fiveware.model.Products;

@Repository
@Transactional
public class ProductsDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Products products) { //Cria um novo produto

		manager.persist(products);
	}

	public void alterar(Products products) {
		manager.merge(products);
	}

	public void excluir(Class<Products> entityClass, Object id) { //deletar produto pelo ID = ok
		Products products = manager.find(entityClass, id);
		manager.remove(products);
	}

	public Products buscaProductsPeloId(String id) { //Buscar produto pelo ID = ok

		Products products = manager.find(Products.class, Integer.parseInt(id));

		return products;
	}

	public Products buscarProductsPeloId(Class<Products> entityClass, Object id) {

		Products products = manager.find(entityClass, id);

		return products;
	}
	
	
	public Products alterarProductsPeloId(Class<Products> entityClass, Object id) {

		Products products = manager.find(entityClass, id);
		
		alterar(products);

		return products;
	}


	public List<Products> buscarTodasProducts() { 

		Query query = manager.createNamedQuery("Products.consultAlls");
		List<Products> resultList = (List<Products>) query.getResultList();

		return resultList;
	}

}
