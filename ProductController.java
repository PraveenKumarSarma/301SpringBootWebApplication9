package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController
{

	@RequestMapping("/")
	public String productForm()
	{
		return "product";
	}
	
	@RequestMapping("/req1")
	public String totalBillPay(@RequestParam int cid,@RequestParam String cName,@RequestParam long mNo,@RequestParam String pName,@RequestParam double price,@RequestParam int quantity,ModelMap model)
	{
		model.put("cid", cid);
		model.put("cName", cName);
		model.put("mNo", mNo);
		model.put("pName", pName);
		model.put("price", price);	
		model.put("quantity", quantity);
		double tAmount=0.0,discount=0.0,dAmount=0.0;
		tAmount=price*quantity;
		if(tAmount < 2500)
		{
			discount = 0.1;
		}
		else if(tAmount >= 2500 && tAmount < 5000)
		{
			discount =0.15;
		}
		else
		{
			discount =0.3;
		}
		
		dAmount =discount * tAmount;
		double gst=0.0;
		gst= 0.18 * tAmount;
		double iBill = 0.0;
		iBill= tAmount + gst - dAmount;
		model.put("tAmount", tAmount);
		model.put("dAmount", dAmount);
		model.put("gst",gst);
		model.put("iBill", iBill);
		return "result"; 
	}
}
