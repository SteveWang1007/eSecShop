package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import order.ShoppingCart;
import productData.ProductManager;
import support.ProductNotFoundException;

public class AddToCart extends JFrame 
{
	private String id;
	private String number = "";
	
	public AddToCart() 
	{
		int repeat = 0;
		String answer;
		try 
		{
			Select();

			answer = JOptionPane.showInputDialog("Are you sure you want to add Product#"
						+ id
						+ " to your cart?\n"
						+ "enter 1: YES \n"
						+ "enter other number: NO");
			repeat = Integer.parseInt(answer);
			if (repeat == 1)
				Delete();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Warning: Product not found!");
		}
	}// end of UpdateProduct()

	public void Select() 
	{
		try 
		{

			number = JOptionPane
					.showInputDialog("Please input the product ID of the item you would like to add");

			id = number;
			try{
				ProductManager.productLocator(id);
			}
			catch (ProductNotFoundException pnf){
				System.err.print(pnf.getMessage());
			}

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Delete() throws Exception 
	{

				ShoppingCart sc = new ShoppingCart();
				sc.addCart(id);
				
				JOptionPane.showMessageDialog(null,
						"Added Product#" + id+ " successfully! ");

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new AddToCart();
	}// end main
}