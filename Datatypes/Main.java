public class Main {					 // osztály neve egyezzen meg a fájl nevével
	public static void main(String[] args) {	 // Belépési pont
		System.out.println("Hello kiscica!"); 	 // Kiíratás

		// primitív típusok

		boolean igazE = true;			 // Logikai típusú változó (1bit)
		byte bajtocska = 50; 			 // 8 bit  -128 és +127 között
		short szam = -1000;			 // 16 bit -32768 és + 32767 között
		int szam2 = 70000;			 // 32 bit <---- ezt használjuk
		long szam3 = 400000000l;		 // 64 bit (l kell a végére ha literálként akarjuk használni)

		float szam4 = 2.5f;			 // 32 bit lebegőpontos
		double szam5 = 121.3;			 // 64 bit lebegőpontos <--- ezt használjuk

		char ch = 'a';				 // Karakter 16-bit

		// lehet belőlük tömböket készíteni

		int[] tomb = new int[10];		 // 1D tömb definiálása, 10 méretben
		int[][] tomb2 = new int[3][4];		 // 2D tömb

		// Referencia típusok

		String szo = "Macska";			 // Karakterlánc tárolása

		int a = 10;
		int b = 20;
		int res = a+b;
		System.out.println(szo + (a + b));
		a *= 10;				 // a = a + 10
		byte c = 0b1011;
		byte d = 0b0101;
		System.out.println(c + " " + d);

		// bitenkénti logikai műveletek ( egy &, | jel )

		System.out.println(c & d);		 // logikai AND (0001)
		System.out.println(c | d);		 // logikai OR (1111)
		System.out.println(~c);			 // logikai NEG (0100)
		System.out.println(c ^ d);		 // logikai XOR

		// logikai műveletek ( két &&, || jel )

		System.out.println(true && false);	 // AND művelet (&& - ha nem számolunk, hanem a logikai változók értékét vizsgáljuk
 		System.out.println(true || false);	 // OR
		System.out.println(!true);		 // NEG
		System.out.println(true == false);	 // Megegyezés ( csak két = kell, mert a típusok már benne vannak a változóban)

		// Vezérlési szerkezetek

		if(a == 10) {
			System.out.println("Az a 10");
		} else if(b == 20) {
			b += 200;
		} else {
			b++;
		}

		switch(a){
			case 1:
				System.out.println("Egy");
				break;
			default:
				System.out.println("Nem egy");
				break;
		}

		for(int i = 0; i<10; i++){
			System.out.println(i);
		}

		int i = 0;
		while(i< 10) {
			System.out.println("while" + i);
			i++;
		}

		do {
			System.out.println("Do" + i);
			i--;
		} while(i>=0);

		int q = addTwoNumbers(10, a);
		printNumber(q);

	}

	public static int addTwoNumbers(int a, int b) {
		int result = a + b;
		return result;
	}

	public static void printNumber(int a) {
		System.out.println("A kapott szám: " + a);
	}

}
