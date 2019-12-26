package serial.in.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Student implements Serializable {

	int id;
	String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public static void main(String[] args) {
		Student s1=new Student(20, "jonh");
		String file="Abc.ser";
		
		try {
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(s1);
			System.out.println("object Serialized sucessfully....");
			FileInputStream fin=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fin);
			Student s2=(Student)ois.readObject();
			System.out.println("my id = "+s2.id+""+"\nmy name = "+s2.name);
			System.out.println("object deSerialized sucessfully....");

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
