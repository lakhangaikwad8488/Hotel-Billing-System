package test.java.yaksha;
  

import main.java.yaksha.FoodProduct;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.yaksha.Order;
 import main.java.yaksha.TestUtils;
@RunWith(MockitoJUnitRunner.class)  
class UserInterfaceTest {

	@Test
	void testFindDiscount() throws IOException {
		Order order = Mockito.mock(Order.class);
		 
		//assertEquals(true,o.findDiscount("SBI") );
		when(order.findDiscount("SBI")).thenReturn(50.0); 
		double actualTotal=order.findDiscount("SBI");
		 TestUtils.yakshaAssert(TestUtils.currentTest(),(actualTotal==50.0?true:false),TestUtils.businessTestFile);

 	}
	@Test
	void testAddToCart() throws IOException {
		Order order = Mockito.mock(Order.class);
		FoodProduct foodProductObject=new FoodProduct() ;
		//assertEquals(true,o.addToCart(foodProductObject) );
		when(order.addToCart(foodProductObject)).thenReturn(0); 
		int actualTotal=order.addToCart(foodProductObject);
		 TestUtils.yakshaAssert(TestUtils.currentTest(),(actualTotal==0?true:false),TestUtils.businessTestFile);

	}
	@Test
	public void testCalculateTotalBill() throws IOException {
		Order order = Mockito.mock(Order.class);
		FoodProduct foodProduct = Mockito.mock(FoodProduct.class);
		//FoodProduct f=new FoodProduct();
		//Order o=new Order();
		foodProduct.setFoodId(1);
		foodProduct.setFoodName("Rice");
		foodProduct.setCostPerUnit(100);
		foodProduct.setQuantity(2);
		order.setDiscountPercentage(50.0);
		order.addToCart(foodProduct);
		when(order.calculateTotalBill()).thenReturn(100.0); 
		double actualTotal=order.calculateTotalBill();
		//assertEquals(100, o.calculateTotalBill());
		 TestUtils.yakshaAssert(TestUtils.currentTest(),(actualTotal==100.0?true:false),TestUtils.businessTestFile);

	}
	@Test
	public void testExceptionConditon() throws Exception{

	              TestUtils.yakshaAssert(TestUtils.currentTest(),false,TestUtils.boundaryTestFile);

	             

	}

	 

	@Test
	public void testBoundaryCondition() throws Exception {

	              TestUtils.yakshaAssert(TestUtils.currentTest(),false,TestUtils.exceptionTestFile);

	}


}
