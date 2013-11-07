package boaspraticas;

import java.math.BigDecimal;

public class Numbers {

	public static void main(String[] args) {
		long start = 0L;
						
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) declarandoNumerosErrado();
		System.out.println((System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) declarandoNumerosCerto();
		System.out.println((System.currentTimeMillis() - start) + "ms");
		
		System.out.println(precisaoFeitoErrado());
		System.out.println(precisaoFeitoCerto());
		
	}
	
	
	private static double precisaoFeitoErrado() {
		double d = 0.0;
		for (int i = 0; i < 10; i++) d = d + 0.1;
		return d;
	}
	
	private static double precisaoFeitoCerto() {
		BigDecimal d = BigDecimal.ZERO;
		for (int i = 0; i < 10; i++) d = d.add(BigDecimal.valueOf(0.1));
		return d.doubleValue();
	}

	private static void declarandoNumerosErrado() {
		Integer i = 8;
		Long l = 8L;
		Float f = 8F;
		Double d = 8D;		
	}

	private static void declarandoNumerosCerto() {
		int i = 8;
		long l = 8;
		float f = 8;
		double d = 8;		
	}

}
