package com.kwon.fp.main;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.kwon.fp.sell.Sell;
import com.kwon.fp.sell.SellRepo;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ProductDAO {
	@Value("${categories}")
	private String categories;

	@Value("${file.dir}")
	private String fileDir;
	
	@Autowired
	private SellRepo sr;

	public void getCategory(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> categoryList = Arrays.asList(categories.split(";"))
				.stream()
	            .map(category -> {
	                try {
	                    // Decode UTF-8 encoded category
	                    return new String(category.getBytes("ISO-8859-1"), "UTF-8");
	                } catch (UnsupportedEncodingException e) {
	                    return category;
	                }
	            })
	            .collect(Collectors.toList());
		for (String cgy : categoryList) {
			System.out.println(cgy);
		}
		req.setAttribute("cl", categoryList);

	}

	public Resource getPhoto(String name) {
		try {
			return new UrlResource("file:" + fileDir + "/" + name);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void search(HttpServletRequest req) {
		req.getSession().setAttribute("search", req.getParameter("search"));

	}

	public void get(HttpServletRequest req) {
		String search = req.getParameter("search");
		List<Sell> products = new ArrayList<>();
		try {
			if (search == null) {
				products = sr.findAllByOrderByUpdateDateDesc();

			} else {
				products = sr.findByNameContainingOrderByUpdateDateDesc(search);
			}
			req.setAttribute("products", products);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getByCategory(HttpServletRequest req, String category) {

		getCategory(req);

		List<Sell> products = new ArrayList<>();
		try {
			products = sr.findByCategoryOrderByUpdateDateDesc(category);
			req.setAttribute("products", products);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
