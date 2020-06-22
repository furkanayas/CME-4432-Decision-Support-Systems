import java.util.Scanner;

import javax.swing.JFileChooser;

public class OpenFile {
 
 //Declare Variable
 JFileChooser fileChooser = new JFileChooser();
 StringBuilder sb = new StringBuilder();
 
 public void PickMe() throws Exception{
  
  if(fileChooser.showOpenDialog(null) == JFileChooser.DIRECTORIES_ONLY){
   
   //get the file
   java.io.File file = fileChooser.getSelectedFile();
   
   //create a scanner for the file
   Scanner input = new Scanner(file);

   input.close();
  }
  else{
   sb.append("No file was selected");
  }
 }

}



//System.out.println(file); // buradaki file hali hazırda konum, bize de bu lazım, içeriği değil
//read text from file
//  while(input.hasNext()){
// sb.append(input.nextLine());
// sb.append("\n");;
// }
