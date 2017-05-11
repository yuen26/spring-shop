package com.yuen.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yuen.domain.web.Product;
import com.yuen.repository.ProductRepository;
import com.yuen.util.Const;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findLatest(int page, int size) {
		return productRepository.findTop10ByOrderByIdDesc();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> search(String keyword) {
		return productRepository.findByNameContaining(keyword);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findByCategoryId(Integer categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Product findOne(Integer id) {
		return productRepository.findOne(id);
	}
	
	@Override
	public Product findOneWithCategory(Integer id) {
		return productRepository.findOneWithCategory(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public long countAll() {
		return productRepository.count();
	}

	@Override
	@Transactional
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		productRepository.delete(id);
	}

	@Override
	@Transactional
	public Product upload(Product product, MultipartFile imageFile) {
		// Upload file to storage
		try {
			byte[] bytes = imageFile.getBytes();
			String fileName = imageFile.getOriginalFilename();
			String fileLocation = new File(Const.UPLOAD_FOLDER).getAbsolutePath() + "\\" + fileName;
			FileOutputStream fos = new FileOutputStream(fileLocation);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		// Update image name in DB
		product.setImage(imageFile.getOriginalFilename());
		return productRepository.save(product);
	}

}
