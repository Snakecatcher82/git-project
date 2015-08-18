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
		//Сортируем список, по координате Ax
		Collections.sort(rectList);
				
		double sumSquare=0;
		double addSquare=0;
		double intSquare;
		double btwSquare=rectList.get(0).square();
		double finalSquare;
								
		for(int i=1; i<rectList.size();i++){
			//Площадь пересечения двух прямоугольников
			intSquare=rectList.get(i).compareSquare(rectList.get(i-1));
			//Суммарная площадь прямоугольников, без учета пересечения
			sumSquare=rectList.get(i).square()+rectList.get(i-1).square();
			//Площадь прямоугольника описывающего два прямоугольника
			btwSquare=rectList.get(i).outsquare(rectList.get(i-1));
			System.out.println("btw: "+btwSquare);
			System.out.println("sum: "+sumSquare);
			System.out.println("int: "+intSquare);
			//Площадь "дополнения", до прямоугольника описывающего два прямоугольника
			addSquare=addSquare+btwSquare-sumSquare+intSquare;
			
			//if ((btwSquare-sumSquare+intSquare)==0) addSquare=addSquare+btwSquare-sumSquare+intSquare;
			//else addSquare=addSquare+btwSquare-sumSquare+intSquare;
		}
		//Площадь получившейся фигуры равна разнице между площадью прямоугольника,
		//который описывает все введенные в программу прямоугольники, и суммарной площадью
		//дополнения от интересующей нас фигуры, до описывающего прямоугольника
			finalSquare=btwSquare-addSquare;
		
		System.out.println("Площадь фигуры равна:"+finalSquare);
	}
	
	//Загружаем в список объекты типа Rectangle, и выводим его на экран
	static void getRect(){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str;
	System.out.println("Введите координаты прямоугольников.");
	System.out.println("В качестве разделителя используйте ';'.");
	System.out.println("Введите 'stop' для завершения, и расчета площади фигуры.");
	try {	
		do{
			
			str=br.readLine();
			if(!str.equals("stop")) addRect(str);
			
		}while (!str.equals("stop"));
		} catch (IOException e) {
				e.printStackTrace();
			}
	}
	//Разбиваем вводимую строку на четыре части, в качестве разделителя используя ';' 
	static void addRect(String lineInsert){
		String[] insert=lineInsert.split(";"); 
		Rectangle newRect= new Rectangle(Double.parseDouble(insert[0]), 
										 Double.parseDouble(insert[1]), 
										 Double.parseDouble(insert[2]), 
										 Double.parseDouble(insert[3]));
		rectList.add(newRect);
	}
}
