class Task1 {
	// метод genInt3 генеририут случайное 3-х значное число
	static int genInt3(){
		// указываем диапазон 3-х значных чисел [100, 999]
		int min = 100;
		int max = 999;
		return (int)(Math.random()*((max - min) + 1)) + min;
	}

	public static void main(String[] args) {
		// количестов генерируемых 3-х значных чисел
		int n = 3;
		// сумма для первых цифр 3-х значных чисел
		int sum = 0;
		for(int i=0; i < n; i++) {
			// получаем очередное 3-х значное число
			int x = genInt3();
			// суммируем первые цифры чисел
			sum += x/100;
			System.out.println((i+1)+") "+x);

		}
		System.out.println("Сумма первых цифр: "+sum);
	}
}