package br.eti.webstuff.fiveware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.eti.webstuff.fiveware.dao.ProductsDAO;
import br.eti.webstuff.fiveware.model.Products;

@Service
@Transactional
public class ProductsService {

	@Autowired
	private ProductsDAO dao;

	public void save(Products products) {

		System.out.println(products.getName()); // TODO: substituir por Log4j
		dao.gravar(products);
	}

	public void update(Products products) {

		dao.alterar(products);
	}

	public void delete(Class<Products> entityClass, Object id) {

		dao.excluir(entityClass, id);
	}

	public Products searchProductsById(Class<Products> entityClass, Object id) {

		Products products = dao.buscarProductsPeloId(entityClass, id);

		return products;
	}

	public Products searchProductsById(String id) {

		Products products = dao.buscaProductsPeloId(id);

		return products;
	}

	public List<Products> searchListProducts() {

		List<Products> listProducts = dao.buscarTodasProducts();

		return listProducts;
	}

}
