package br.edu.ifrn.localizaimovel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BuscaTeste {

	List<String> fileList;

	static String zipFilePath = "C:\\Users\\joao_\\eclipse-workspace\\BuscaImovel\\ListaImoveis\\ListaImoveis .zip";
    
    static String destDir = "c:\\output";

	public static void main(String[] args) throws IOException {

		unzip(zipFilePath, destDir);

		Document doc = Jsoup.parse("");
		// JSONObject jsonParentObject = new JSONObject();
		JSONArray list = new JSONArray();
		for (Element table : doc.select("table")) {
			for (Element row : table.select("tr")) {
				JSONObject jsonObject = new JSONObject();
				Elements tds = row.select("td");
				String link = tds.get(0).html();
				String endereco = tds.get(1).text();
				String bairro = tds.get(2).text();
				String descricao = tds.get(3).text();
				String preco = tds.get(4).text();
				String foto = tds.get(5).text();
				String cidade = tds.get(6).text();
				String estado = tds.get(7).text();

				jsonObject.put("Link", link);
				jsonObject.put("Descricao", descricao);
				jsonObject.put("Foto", foto);
				jsonObject.put("Preco", preco);
				jsonObject.put("Bairro", bairro);
				jsonObject.put("Endereco", endereco);
				jsonObject.put("Cidade", cidade);
				jsonObject.put("Estado", estado);

				list.put(jsonObject);
			}
		}

		System.out.println(list.toString());
	}

    private static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
         
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
        	FileInputStream fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
