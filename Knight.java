import javax.swing.JFrame;

public class Knight{
	public static void main (String[]args){
		
		JFrame Window = new JFrame("Knights Quest");
		
		Window.setSize(600,600);
			
		KnightPanel panel = new KnightPanel(6,5);
		
		
		Window.add(panel); 
		
		
		
		Window.setVisible(true); 
		
		panel.quest(0, 0);
		
		
		
	}
	
	
	
}