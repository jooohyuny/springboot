package com.kim.aug03tl.calc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.kim.aug03tl.snack.Snack;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class Calculator {
	public void calculate(CalcResult cr, HttpServletRequest req) {
		cr.setHab(cr.getXx() + cr.getYy());
		cr.setCha(cr.getXx() - cr.getYy());
		cr.setGob(cr.getXx() * cr.getYy());
		cr.setMoks(cr.getXx() / cr.getYy());
		req.setAttribute("crrr", cr);
		
		req.setAttribute("a", "ㅋㅋㅋ");
		
		ArrayList<Snack> snacks = new ArrayList<>();
		snacks.add(new Snack("빼빼로", 2000));
		snacks.add(new Snack("초코파이", 6000));
		req.setAttribute("b", snacks);
		
		HashMap<String, Snack> snacks2 = new HashMap<>();
		snacks2.put("ㄱ", new Snack("새콤달콤", 500));
		snacks2.put("ㄴ", new Snack("달콤새콤", 600));
		req.setAttribute("c", snacks2);
		
		req.getSession().setAttribute("d", 34342);
		req.setAttribute("e", new Random().nextInt(6));
		
		req.setAttribute("f", 12345121);
		req.setAttribute("g", 12.345121);
		req.setAttribute("h", new Date());
		req.setAttribute("i", "https://www.naver.com");
	}
}
