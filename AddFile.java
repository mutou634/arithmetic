import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddFile{
	public static void main(String[] args) throws IOException{
		File fileSource1=new File("D:\\java\\java�ļ���\\source1.txt");
		File fileSource2=new File("D:\\java\\java�ļ���\\source2.txt");
		File fileTarget=new File("D:\\java\\java�ļ���\\target.txt");
		
		FileOutputStream targe1=new FileOutputStream(fileTarget);
		FileInputStream sourc1=new FileInputStream(fileSource1);
		FileInputStream sourc2=new FileInputStream(fileSource2);
		int a,b;
		while((a=sourc1.read())!=-1)
		{
			targe1.write(a);
		}
		while((b=sourc2.read())!=-1) {
			targe1.write(b);
		}
		System.out.println("�������");
		targe1.close();
		sourc1.close();
		sourc2.close();
	}
}