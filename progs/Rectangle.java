public class Rectangle implements Comparable<Rectangle> {
 //Координаты пары противоположных вершин (левой нижней A и правой верхней B) 
	Double Ax;
	Double Ay;
	Double Bx;
	Double By;
//Координаты прямоугольника пересечения, двух прямоугольников
	Double interAx;
	Double interAy;
	Double interBx;
	Double interBy;

//Конструктор класса
public Rectangle(Double axi, Double ayi, Double bxi, Double byi) {
	// TODO Auto-generated constructor stub
	Ax=axi;
	Ay=ayi;
	Bx=bxi;
	By=byi;
}
//Замена объекта, объектом представляющим собою прямоугольник описывающий два проверяемых прямоугольника
public void replaceObject(Rectangle rc){
	if (Ax>rc.Ax) Ax=rc.Ax;
	if (Ay>rc.Ay) Ay=rc.Ay;
	if (Bx<rc.Bx) Bx=rc.Bx;
	if (By<rc.By) By=rc.By;
	
}
// Переопределенный метод, для вывода объекта на экран
public String toString(){
	return "\n"+Ax+"; "+Ay+"; "+Bx+"; "+By;
}
//Площадь прямоугольника
public Double square(){
	return((Bx-Ax)*(By-Ay));
}
//Площадь прямоугольника описывающего, два прямоугольника
public Double outsquare(Rectangle rc){
	replaceObject(rc);
	return square();
}
//Пересечение проекций прямоугольников на ось X
Double compareRectX(Rectangle rc){
	if(Bx<rc.Ax || Ax>rc.Bx) return 0.0;
	if(Ax<rc.Ax){
		if (Bx<rc.Bx){
			interAx=rc.Ax;
			interBx=Bx;
			return Bx-rc.Ax;
		}
		else
		{
			interAx=rc.Ax;
			interBx=rc.Bx;
			return rc.Bx-rc.Ax;
		}
	}
	else
	{
		if(Bx>rc.Bx){
			interAx=Ax;
			interBx=rc.Bx;
			return rc.Bx-Ax;
		}
		else {
			interAx=Ax;
			interBx=Bx;
			return Bx-Ax;
		}
	}
}
//Пересечение проекций прямоугольников на ось Y
Double compareRectY(Rectangle rc){
	if(By<rc.Ay || Ay>rc.By) return 0.0;
	if(Ay<rc.Ay){
		if (By<rc.By){
			//2
			interAy=rc.Ay;
			interBy=By;
			return By-rc.Ay;
		}
		else
		{
			//3
			interAy=rc.Ay;
			interBy=rc.By;
			return rc.By-rc.Ay;
		}
	}
	else
	{
		if(By>rc.By){
			interAy=Ay;
			interBy=rc.By;
			return rc.By-Ay;
		}
		else {
			interAy=Ay;
			interBy=By;
			return By-Ay;
		}
	}
}
//Площадь пересечения прямоугольников
Double compareSquare(Rectangle rc){
	return compareRectX(rc)*compareRectY(rc);
}
//Сравнение двух объектов, типа Rectangle для сортировки в списке
public int compareTo(Rectangle rc) {
	return Ax.compareTo(rc.Ax);	
}
}
