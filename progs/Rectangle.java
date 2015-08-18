public class Rectangle implements Comparable<Rectangle> {
 //���������� ���� ��������������� ������ (����� ������ A � ������ ������� B) 
	Double Ax;
	Double Ay;
	Double Bx;
	Double By;
//���������� �������������� �����������, ���� ���������������
	Double interAx;
	Double interAy;
	Double interBx;
	Double interBy;

//����������� ������
public Rectangle(Double axi, Double ayi, Double bxi, Double byi) {
	// TODO Auto-generated constructor stub
	Ax=axi;
	Ay=ayi;
	Bx=bxi;
	By=byi;
}
//������ �������, �������� �������������� ����� ������������� ����������� ��� ����������� ��������������
public void replaceObject(Rectangle rc){
	if (Ax>rc.Ax) Ax=rc.Ax;
	if (Ay>rc.Ay) Ay=rc.Ay;
	if (Bx<rc.Bx) Bx=rc.Bx;
	if (By<rc.By) By=rc.By;
	
}
// ���������������� �����, ��� ������ ������� �� �����
public String toString(){
	return "\n"+Ax+"; "+Ay+"; "+Bx+"; "+By;
}
//������� ��������������
public Double square(){
	return((Bx-Ax)*(By-Ay));
}
//������� �������������� ������������, ��� ��������������
public Double outsquare(Rectangle rc){
	replaceObject(rc);
	return square();
}
//����������� �������� ��������������� �� ��� X
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
//����������� �������� ��������������� �� ��� Y
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
//������� ����������� ���������������
Double compareSquare(Rectangle rc){
	return compareRectX(rc)*compareRectY(rc);
}
//��������� ���� ��������, ���� Rectangle ��� ���������� � ������
public int compareTo(Rectangle rc) {
	return Ax.compareTo(rc.Ax);	
}
}
