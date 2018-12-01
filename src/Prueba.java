import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Metodos{
	public void Intercalacion() {
		File archivo1 = new File("./src/Archivo1.txt");
		File archivo2 = new File("./src/Archivo2.txt");
		
		FileReader frA1 = null;
		BufferedReader brA1;
		FileReader frA2 = null;
		BufferedReader brA2;
		
		FileWriter archivo3=null;
		PrintWriter pr=null;
		
		try {
			archivo3 = new FileWriter("./src/ArchivoSalida.txt", false);
			pr = new PrintWriter(archivo3);
			
			try {
				frA1 = new FileReader(archivo1);
				brA1 = new BufferedReader(frA1);
				String lineaArchivo1;
				try {
					frA2 = new FileReader(archivo2);
					brA2 = new BufferedReader(frA2);
					String lineaArchivo2;
					boolean repetir=true;
					
					lineaArchivo1 = brA1.readLine();
					lineaArchivo2 = brA2.readLine();
				
				do {
					if (Integer.parseInt(lineaArchivo1)<Integer.parseInt(lineaArchivo2)) {
						pr.println(lineaArchivo1);
						if ((lineaArchivo1=brA1.readLine())==null) {
							pr.println(lineaArchivo2);
							while ((lineaArchivo2=brA2.readLine())!=null) {
								pr.println(lineaArchivo2);
							}
							repetir=false;
						}
					}
					else if (Integer.parseInt(lineaArchivo1)>Integer.parseInt(lineaArchivo2)) {
						pr.println(lineaArchivo2);
						if ((lineaArchivo2=brA2.readLine())==null) {
							pr.println(lineaArchivo1);
							while ((lineaArchivo1=brA1.readLine())!=null) {
								pr.println(lineaArchivo1);
							}
							repetir=false;
						}
					}
					else {
						pr.println(lineaArchivo1);
						pr.println(lineaArchivo2);
						if ((lineaArchivo1=brA1.readLine())==null) {
							pr.println(lineaArchivo2);
							while ((lineaArchivo2=brA2.readLine())!=null) {
								pr.println(lineaArchivo2);
							}
							repetir=false;
						}
						if ((lineaArchivo2=brA2.readLine())==null) {
							pr.println(lineaArchivo1);
							while ((lineaArchivo1=brA1.readLine())!=null) {
								pr.println(lineaArchivo1);
							}
							repetir=false;
							}
						}
					}while(repetir);
				}catch (FileNotFoundException e) {
					System.out.println("Error al abrir el archivo");
					//e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						frA2.close();
					}catch(IOException e) {
						System.out.println("Error al cerrar el archivo");
					}
				}
			}catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					frA1.close();
				}catch (IOException e) {
					System.out.println("Error al cerrar el archivo");
				}
			}
			System.out.println("Archivos combinados y ordenados correctamente");
		}catch (IOException e) {
			System.out.println("Error al abrir o crear el archivo");
		}finally {
			try {
				archivo3.close();
			}catch(IOException e){
				System.out.println("Error al cerrar el archivo");
			}
			}	
	}//fin intercalacion
	
	public void mergeSort(Integer[] array, int lo, int n) {
		int low=lo, high=n;
		if (low>=high) {
			return;
		}
		
		int siddle = (low+high)/2;
		mergeSort(array, low, siddle);
		mergeSort(array, siddle+1, high);
		int end_low=siddle;
		int start_high=siddle+1;
		
		while ((lo <= end_low) && (start_high <= high)) {
			if (array[low]<array[start_high]) {
				low++;
			}else {
				int Temp =array[start_high];
				for (int k = start_high-1; k >= low; k--) {
					array[k+1]=array[k];
				}
				array[low]=Temp;
				Temp++;
				end_low++;
				start_high++;
			}
		}
		
	}
	
}
public class Prueba {

}
