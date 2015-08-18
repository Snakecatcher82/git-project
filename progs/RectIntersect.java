import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class RectIntersect {
	static ArrayList<Rectangle> rectList = new ArrayList<Rectangle>();

	public static void main(String[] args) {
		getRect();
		System.out.println(rectList);
		//��������� ������, �� ���������� Ax
		Collections.sort(rectList);
				
		double sumSquare=0;
		double addSquare=0;
		double intSquare;
		double btwSquare=rectList.get(0).square();
		double finalSquare;
								
		for(int i=1; i<rectList.size();i++){
			//������� ����������� ���� ���������������
			intSquare=rectList.get(i).compareSquare(rectList.get(i-1));
			//��������� ������� ���������������, ��� ����� �����������
			sumSquare=rectList.get(i).square()+rectList.get(i-1).square();
			//������� �������������� ������������ ��� ��������������
			btwSquare=rectList.get(i).outsquare(rectList.get(i-1));
			System.out.println("btw: "+btwSquare);
			System.out.println("sum: "+sumSquare);
			System.out.println("int: "+intSquare);
			//������� "����������", �� �������������� ������������ ��� ��������������
			addSquare=addSquare+btwSquare-sumSquare+intSquare;
			
			//if ((btwSquare-sumSquare+intSquare)==0) addSquare=addSquare+btwSquare-sumSquare+intSquare;
			//else addSquare=addSquare+btwSquare-sumSquare+intSquare;
		}
		//������� ������������ ������ ����� ������� ����� �������� ��������������,
		//������� ��������� ��� ��������� � ��������� ��������������, � ��������� ��������
		//���������� �� ������������ ��� ������, �� ������������ ��������������
			finalSquare=btwSquare-addSquare;
		
		System.out.println("������� ������ �����:"+finalSquare);
	}
	
	//��������� � ������ ������� ���� Rectangle, � ������� ��� �� �����
	static void getRect(){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str;
	System.out.println("������� ���������� ���������������.");
	System.out.println("� �������� ����������� ����������� ';'.");
	System.out.println("������� 'stop' ��� ����������, � ������� ������� ������.");
	try {	
		do{
			
			str=br.readLine();
			if(!str.equals("stop")) addRect(str);
			
		}while (!str.equals("stop"));
		} catch (IOException e) {
				e.printStackTrace();
			}
	}
	//��������� �������� ������ �� ������ �����, � �������� ����������� ��������� ';' 
	static void addRect(String lineInsert){
		String[] insert=lineInsert.split(";"); 
		Rectangle newRect= new Rectangle(Double.parseDouble(insert[0]), 
										 Double.parseDouble(insert[1]), 
										 Double.parseDouble(insert[2]), 
										 Double.parseDouble(insert[3]));
		rectList.add(newRect);
	}
}
