package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SymbolData {
	private String file_path = "C://TEMP";
	private String file_name = "btc.json"; 

	public String findSymbolLastPrice(String symbol_to_find) throws IOException {
		symbol_to_find = symbol_to_find.toUpperCase();
		String text_screen = "";
		File dir = new File(file_path);
		File file = new File(file_path, file_name);
		
		if(!dir.exists() || !dir.isDirectory())
			throw new IOException("Diretório inexistente!");
		if(!file.exists() || !file.isFile())
			throw new IOException("Arquivo inexistente!");
		
		Scanner reader = new Scanner(file);
		reader.useDelimiter("},");
		String line = reader.next();
		while(reader.hasNext()) {
			String []info_symbol = line.split(",");
			
			// Quebra o simbolo em array e pega o segundo valor, sendo o nome do símbolo
			// Também retira aspas do simbolo
			String symbol = (info_symbol[0].split(":")[1]).replace("\"", "");
			
			// Checa se o simbolo corresponde ao simbolo do argumento
			if(symbol.equalsIgnoreCase(symbol_to_find)) {
				String last_price = (info_symbol[5].split(":")[1]).replace("\"", "");
				text_screen += "Simbolo: " + symbol + "\nLastPrice: " + last_price + "\n";
				break;
			}
			line = reader.next();
			
		}

		reader.close();

		return text_screen.isEmpty() ? null : text_screen;
	}
}
