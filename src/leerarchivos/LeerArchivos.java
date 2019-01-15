/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerarchivos;

import org.apache.poi.hwpf.extractor.WordExtractor; //Para leer un .doc
import org.apache.poi.xwpf.extractor.XWPFWordExtractor; //Para leer un XWPF Document
import org.apache.poi.xwpf.usermodel.XWPFDocument; //Para instanciar un .docx

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Alfonso
 */
public class LeerArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Se crea el objeto File con la ruta del archivo
		//En la ruta recuerden que se debe poner doble barra "\\"
		File archivoDocx = new File("C:\\Users\\Alfonso\\Downloads\\8-2018-832.docx");
		//File archivoDoc = new File("c:\\documento.doc");
		
		try {
		//Creamos el stream fijense bien los objetos usados
		//InputStream entradaArch1 = new FileInputStream(archivoDoc);
                InputStream entradaArch2;
		entradaArch2 = new FileInputStream(archivoDocx);
                String textoDeDocx = leerDocx(entradaArch2);
                String[] palabras = textoDeDocx.split("\\n");
                if (textoDeDocx.indexOf("#RFECHA#") == -1 || textoDeDocx.indexOf("#RNUMRAD#") == -1 || textoDeDocx.indexOf("#RUNAL#") == -1
                        || textoDeDocx.indexOf("#RPARA#") == -1 || textoDeDocx.indexOf("#SEDE#") == -1 || textoDeDocx.indexOf("#PASUNTO#") == -1
                        || textoDeDocx.indexOf("#PDE#") == -1 || textoDeDocx.indexOf("#CARGO#") == -1 || textoDeDocx.indexOf("#OFICINA_PRODUCTORA#") == -1
                        || textoDeDocx.indexOf("#COPIAINF#") == -1 || textoDeDocx.indexOf("#RELABORO#") == -1){
                    System.out.println("etiqueta no esta");
                }else{
                    System.out.println("etiquetas estan");
                }
                //System.out.println(textoDeDocx);
		
		} catch(Exception ex) {
			//Manejar Excepcion IO y FileNotFound
		}
        
		
		//Metodos para leer dependiendo de si es .doc o .docx
		//String textoDeDoc = leerDoc(entradaArch1);
		
		
		// se imprime
		//System.out.println(textoDeDoc);
		
    }
    
    private static String leerDoc(InputStream doc) throws IOException {
		//Creamos el extractor pasandole el stream
		WordExtractor we = new WordExtractor(doc);
		
		//Regresamos lo leído		
		return we.getText();
	}
	
	private static String leerDocx(InputStream docx) throws IOException {
		//Se crea un documento que la POI entiende pasandole el stream
		//instanciamos el obj para extraer contenido pasando el documento
		XWPFWordExtractor xwpf_we = new XWPFWordExtractor(new XWPFDocument(docx)); 
				
		return xwpf_we.getText();
	}
    
}
