package boaspraticas;

import java.io.File;

public class Methods {

	public static void main(String[] args) {
		// método com nomes obscuros dificultam o entendimento
		System.out.println(n("ssss"));
		
		// opções boleanas são difíceis de entender
		System.out.println(isNumber("333", true));
		System.out.println(isNumber("333", false));
		
		// assim é melhor:
		System.out.println(isNumber("333", Spaces.areIgnored));
		
		// parâmetro não revela propósito:
		System.out.println("|" + pad("teste", 40, 0, ' ') + "|");		
		System.out.println("|" + pad("teste", 40, 1, ' ') + "|");
		System.out.println("|" + pad("teste", 40, 2, ' ') + "|");
		

		// parâmetros indesejados: null!
		System.out.println("|" + pad("teste", 40, Align.left, null) + "|");
		
		// parâmetro clarificado:
		System.out.println("|" + pad("teste", 40, Align.left) + "|");		
		System.out.println("|" + pad("teste", 40, Align.center) + "|");
		System.out.println("|" + pad("teste", 40, Align.right) + "|");

		
		ff("/", "*.txt", "/etc", 200, 100, 150); //obscuro
		
		// solução tentadora, adicionar um comentário:
		
		// procura arquivos a partir do raiz que sejam txt e tenham o texto etc
		// até o tempo máximo de 200ms, investigando no máximo 100 subdiretórios e 
		// encontrando no máximo 150 arquivos
		ff("/", "*.txt", "/etc", 200, 100, 150); //obscuro
		
		
		
		findFiles("/", "*.txt", "/etc", 200, 100, 150); //um pouco melhor
		
		
		
		findFiles("/", "*.txt", "/etc", null, null, 150); //pior se existem parâmetros anuláveis
		
		// Agora está mais claro
		FindOptions options = new FindOptions();
		options.startDirectory = "/";
		options.namePattern = "*.txt";
		options.textToFind = "/etc";
		options.timeout = 200;
		options.maxDepth = 100;
		options.maxFiles = 150;
		
		findFiles(options);
		
		
	}

	// precisa de um nome mais significativo:
	public static boolean n(String s) {
		for (char c : s.toCharArray()) 
			if (!Character.isDigit(c)) return false;
		return true;
	}
	
	// melhor:
	public static boolean isNumber(String s) {
		for (char c : s.toCharArray()) 
			if (!Character.isDigit(c)) return false;
		return true;
	}
	
	// evite boleanos, string e números para opções
	// torne mais claro
	public static boolean isNumber(String s, boolean b) {
		for (char c : b ? s.trim().toCharArray() : s.toCharArray()) 
			if (!Character.isDigit(c)) return false;
		return true;
	}
	
	public static boolean isNumber(String s, Spaces spaces) {
		if (Spaces.areIgnored.equals(spaces)) s = s.trim();
		
		for (char c : s.toCharArray()) 
			if (!Character.isDigit(c)) return false;
		
		return true;
	}
	
	// pouco comunicativo:
	public static String pad(String s, int w, int a, Character c) {
		StringBuilder b = new StringBuilder();		
		if (a == 0) b.append(s);
		for (int i = 0; i < w - s.length(); i++) b.append(c);
		if (a == 1) b.insert(w / 2 - 1, s);
		if (a == 2) b.append(s);		
		return b.toString();
	}
	
	
	
	// mais comunicativo:
	/*
	public static String pad(String s, int w, Align a, Character c) {
		StringBuilder b = new StringBuilder();		
		
		for (int i = 0; i < w - s.length(); i++) b.append(' ');
		
		if (a.equals(Align.left))   b.insert(0, s);
		if (a.equals(Align.center)) b.insert(w / 2 - 1, s);
		if (a.equals(Align.right))  b.append(s);
		
		return b.toString();
	}
	*/
	
	// comunicativo e defensivo:
	public static String pad(String s, int w, Align a, Character c) {
		
		if (c == null) c = ' ';
		
		StringBuilder b = new StringBuilder();		
		
		for (int i = 0; i < w - s.length(); i++) b.append(' ');
		
		if (a.equals(Align.left))   b.insert(0, s);
		if (a.equals(Align.center)) b.insert(w / 2 - 1, s);
		if (a.equals(Align.right))  b.append(s);
		
		return b.toString();
	}
	
	// sobrecarga para que nulo não seja passado como parâmetro:
	private static String pad(String s, int w, Align a) {
		return pad(s, w, a, null);
	}
	
	
	
	
	// maus nomes
	public static File[] ff(String sd, String np, String ttf, Integer t, Integer md, Integer mf) {
		return new File[0];
	}
	
	// bons nomes, muitos parâmetros
	public static File[] findFiles(String startDirectory, String namePattern, String textToFind, Integer timeout, Integer maxDepth, Integer maxFiles) {
		return new File[0];
	}
	
	
	// melhor: bom nome, um parâmetro
	public static File[] findFiles(FindOptions options) {
		return new File[0];
	}
	
	
	
	
	static class FindOptions {
		String startDirectory, namePattern, textToFind;
		Integer timeout, maxDepth, maxFiles;
	}
		
	enum Align {
		left, right, center;
	}
		
	
	enum Spaces {
		areIgnored, areInvalids;		
	}
	
	
	
}
