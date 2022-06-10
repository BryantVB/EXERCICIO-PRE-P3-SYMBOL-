package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.SymbolData;

public class Main {
	public static void main(String[] args) {
		SymbolData data = new SymbolData();
		String symbol_to_find = JOptionPane.showInputDialog("Digite o simbolo que deseja ver");
		String buffer;
		try {
			String resultados = data.findSymbolLastPrice(symbol_to_find);
			if(resultados == null)
				buffer = "Nenhum dado sobre " + symbol_to_find + " foi encontrado.";
			else
				buffer = resultados;
			
			JOptionPane.showMessageDialog(null, buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
