package interfaceXML;
import java.io.*;

public class FechaArquivoXML {
	
	public void createFile( , String filename)  throws IOException {
        java.io.FileWriter fw = new java.io.FileWriter(filename);
        fw.write(allocation.toString());
        fw.close();
    }

}
