package com.first.lastproject.command.stock;

import java.util.List;

import org.springframework.ui.Model;

import com.first.lastproject.dao.FoodDao;
import com.first.lastproject.dao.FoodDaoImpl;
import com.first.lastproject.dao.IngredientDao;
import com.first.lastproject.dao.IngredientDaoImpl;
import com.first.lastproject.dto.FoodDto;
import com.first.lastproject.dto.IngredientDto;

public class StockListCommand implements StockCommand {

	@Override
	public String execute(Model model) {

		IngredientDao dao = IngredientDaoImpl.getInstance();
		FoodDao foodDao = FoodDaoImpl.getInstance();

		List<IngredientDto> ingredientList = dao.listIngredient();
		List<FoodDto> goodsList = foodDao.getStockDessert();

		model.addAttribute("ingredientList", ingredientList);
		model.addAttribute("goodsList", goodsList);

		return "host/stock/ingredient";
	}

}
