import pilaTaula;



public class UsaPila {

public static void main(String[] args) {
	
	
}
PilaTaula p;
p = new PilaTaula(100);





try {
p.apilar(new Integer(10));
p.apilar(new Integer(33));
p.pintaCima();
} catch (Exception e) 
{ e.printStackTrace(); }