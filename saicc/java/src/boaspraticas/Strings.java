package boaspraticas;

import java.util.Scanner;

public class Strings {
	
	public static void main(String[] args) {		
		
		// EXEMPLOS DE PERFORMANCE
		
		long start = 0L;
		/*
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) concatenarStringsMuitoErrado();
		System.out.println((System.currentTimeMillis() - start) + "ms");
		
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) concatenarStringsErrado();
		System.out.println((System.currentTimeMillis() - start) + "ms");
		
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) concatenarStringsCerto();
		System.out.println((System.currentTimeMillis() - start) + "ms");
		
		
		start = System.currentTimeMillis();		
		for (int i = 0; i < 1000; i++) concatenarStringsCertissimo();		
		System.out.println((System.currentTimeMillis() - start) + "ms");
		*/
		
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) converterNumeroParaStringCerto(89);
		System.out.println((System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) converterNumeroParaStringErrado(89);
		System.out.println((System.currentTimeMillis() - start) + "ms");
		
		
		
		
		// EXEMPLOS DE PROGRAMAÇÃO DEFENSIVA
		/*
		String input = new Scanner(System.in).nextLine();
		// comparação errada
		System.out.println(input == "teste");
		// comparação correta
		System.out.println(input.equals("teste"));
		// comparação segura
		System.out.println("teste".equals(input));
		*/
				
	}	
	

	private static String converterNumeroParaStringErrado(int n) {
		return n + "";
	}

	private static String converterNumeroParaStringCerto(int n) {
		return String.valueOf(n);		
	}

	private static String concatenarStringsMuitoErrado() {
		String s = new String(".");
		for (int i = 0; i < 1000; i++) {
			s = s + ".";
		}
		return s;
	}
	
	private static String concatenarStringsErrado() {
		String s = ".";
		for (int i = 0; i < 1000; i++) {
			s = s + ".";
		}
		return s;
	}

	private static String concatenarStringsCerto() {
		StringBuilder b = new StringBuilder(".");
		for (int i = 0; i < 1000; i++) {
			b.append(".");
		}
		return b.toString();
	}
	
	private static String concatenarStringsCertissimo() {
		StringBuilder b = new StringBuilder('.');
		for (int i = 0; i < 1000; i++) {
			b.append('.');
		}
		return b.toString();
	}
	
	
}

interface IOperation {
	void execute();
}

class Instrument {
	
	private int loops;
	private long time;
	private IOperation op;
	
	public Instrument(IOperation op, long time, int loops) {
		this.op = op;
		this.time = time;
		this.loops = loops;
	}


	public static Instrument measure(IOperation op, int loops) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < loops; i++) op.execute();		
		long end = System.currentTimeMillis();
		return new Instrument(op, end -start, loops);
	}
	
	public long getTime() { return time; }
	
	public int getLoops() { return loops; }
	
	public IOperation getOperation() { return op; }

	public void print() {
		System.out.println(this.toString());		
	}

	@Override
	public String toString() {
		return "Operation " + op + " taken " + time + "ms looping " + loops + " times";
	}	
}