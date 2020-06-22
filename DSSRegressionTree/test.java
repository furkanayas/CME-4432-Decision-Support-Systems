import java.io.FileNotFoundException;

import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;
import java.util.ArrayList;
import java.util.List;

import weka.core.Instance;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.*;

//j48 c4.5 ıd3 decisiontree  
import weka.classifiers.trees.j48.*;


public class test {
	
	//public void Gini()	{}
	
	public static void DetailofAttribute(int ColonNumber, weka.core.Instances insts)
	{
		int[][] targetsituations = new int[insts.attribute(ColonNumber).numValues()][insts.attribute(insts.numAttributes()-1).numValues()];
		
		
		for (int i = ColonNumber; i < ColonNumber+1; i++) // outlook temprature humidity windy (play - target)
		{
			int m = insts.attribute(ColonNumber).numValues();
			 //when call  (insts.attribute(i).name();
			//-2-
			for (int j = 0; j < m; j++) // subclass when 
			{
				for (int k = 0; k < insts.numInstances(); k++) //when call  (insts.attribute(i).value();
				{
					
					if(insts.attribute(i).value(j).equals(insts.instance(k).toString(i)))
					{
					
						for (int l = 0; l < insts.attribute(insts.numAttributes()-1).numValues(); l++)
						{
							String str =insts.attribute(insts.numAttributes()-1).value(l);
							if(insts.instance(k).toString(insts.numAttributes()-1).equals(str))
							{
								targetsituations[j][l]++;
							}
						}
						
					}

				}
			}
			
		}

		int[] totaltargetsituationsvalues = new int[insts.attribute(insts.numAttributes()-1).numValues()];
		
		
		for (int i = 0; i < targetsituations.length; i++)  //2    3
		{
			System.out.println(insts.attribute(ColonNumber).value(i)); 
			for (int l = 0; l < targetsituations[1].length; l++) //3   2
			{
				System.out.print(insts.attribute(insts.numAttributes()-1).value(l) + ": ");
				System.out.print(targetsituations[i][l]+" ");
				totaltargetsituationsvalues[l] = totaltargetsituationsvalues[l] + targetsituations[i][l]; 
				
			}
						
			System.out.println();
		}
		
		for (int i = 0; i < totaltargetsituationsvalues.length; i++) {
			System.out.print("total "+insts.attribute(insts.numAttributes()-1).value(i) + ": ");
			System.out.print(totaltargetsituationsvalues[i]+"\n");
			
		}
		
		//3 grup oluşmalı, s or  o sr  r so
		//bunlar sırayla alınıp kalan grubun toplamından yes ve no ları çıkarılmalı, bunun için tüm yes no lar elde edilmeli
		
		//sub class sayısı kadar durum olabilir 
		
		//sırayla value yu alır onun toplam yes no durumlarını toplam durumlardan çıkarız
		// 2 farklı grup oluşur, 1 yalnız grup 1 de çoklu grup, buradan da hesaplama yapılır
		
		int[] Ginileftvalues = new int[insts.attribute(insts.numAttributes()-1).numValues()];
		
		int[] Ginirightvalues = new int[insts.attribute(insts.numAttributes()-1).numValues()];
		for (int i = 0; i < insts.attribute(ColonNumber).numValues(); i++) {
			
			//System.out.println(insts.attribute(ColonNumber).value(i)); 
			for (int l = 0; l < targetsituations[1].length; l++) //3   2
			{
				
				//System.out.print(insts.attribute(insts.numAttributes()-1).value(l) + ": ");
				//System.out.print(targetsituations[i][l]+" ");
				//totaltargetsituationsvalues[l] = totaltargetsituationsvalues[l] + targetsituations[i][l]; 
				
			}
		}
		
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
	
        
		 weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("data/iris.arff"));
//		 weka.core.Instances insts = new weka.core.Instances(new java.io.FileReader("data/vote.arff"));

		
		
		weka.filters.unsupervised.attribute.Discretize myDiscretize = new
				weka.filters.unsupervised.attribute.Discretize();
				try {
					myDiscretize.setInputFormat(insts);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myDiscretize.setFindNumBins(true);
				try {
					insts = weka.filters.Filter.useFilter(insts, myDiscretize);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				/* open for use
			for (int i = 0; i < insts.numAttributes()-1; i++) {
				DetailofAttribute(i,insts);
				System.out.println("\n\n");
			}
				
				 */
				Instance ins = insts.lastInstance();
				String a = "sad";
				ins.attribute(0).setStringValue(a);
			System.out.println(ins.attribute(0).addStringValue(a));
				
			// o  addStringValue
	}

}


//"/Desktop/weka-3-8-3/data/iris.txt"


/** text formatında txt veya arff olarak okumak için 
 * 
 * 
File file = new File("iris.arff");
BufferedReader reader = null;
reader = new BufferedReader(new FileReader(file));
String satir = reader.readLine();

    while (satir!=null) {
    	System.out.println(satir);
        satir = reader.readLine();
    }

*/



//bu noktaya kadar discrete olmadan nominal veriler sayıalr vs alındı şimdi targer hariç hesap yaptırma
/*
 
 öncelikle target sonuncu attribuate, bu sadece yes no ilişkisi için kullanılacak
 diğer attribuate lar ayrı ayrı alınacak
 alt kategori sayısına göre örneğin 4 ise önce 1 sonra 2 sonra 3 ve sonra 4. nün yes no durumları bulunucak
 önce hepsinin yes ve no su bulunacak ve tüm yes no bulunacak, sonra tüm den tek att e ait olan çıkınca kalan durumlar için 
  olan yes no bulunmuş olacak
 
 
  */

//3 3 2 2 2	

//int[][] targetsituations = new int[attribuatenumber][insts.attribute(attribuatenumber-1).numValues()];

//System.out.println(insts.attribute(attribuatenumber-1).numValues() + " "+ attribuatenumber );
//2 for yes no or any situation, 5 for attribuates.
/**
* 
Attribuates : 

	Attribuate 1 name : outlook & it's nominal

	Sub categories : sunny overcast rainy 

	Attribuate 2 name : temperature & it's nominal

	Sub categories : hot mild cool 

	Attribuate 3 name : humidity & it's nominal

	Sub categories : high normal 

	Attribuate 4 name : windy & it's nominal

	Sub categories : TRUE FALS

	Attribuate 5 name : play & it's nominal

	Sub categories : yes no
*/

// -1- 5 döngü var, içinde değişken olarak döngü var
// -2- numAttributes subclassnumber[] arrayinden devamı çekilebilir.
// -3-  1.attin 1.subclass ında kaç yes var ? tüm instance larla kıyasla
// bunun için att listesi ve sub listesi lazım





//ATILAN TUPLE Hakkında detaylı bilgi veren bir kod, i değeri çevirilmesi yeterli
//-1-