import java.util.Scanner;
public class Calculator {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("List of operations: add subtract multiply divide alphabetize");
			System.out.println("Enter an operation:");
			String operator = input.nextLine().toLowerCase();
			if (!((operator.equals("add")) || (operator.equals("subtract")) || (operator.equals("multiply")) || (operator.equals("divide")) || (operator.equals("alphabetize")))) {
				System.out.println("Invalid input entered. Terminating...");
			} else {
				int int1,int2;
				double double1,double2;
				switch (operator.toLowerCase()) {
					case "add":
					case "subtract":
						System.out.println("Enter two integers:");
						if (input.hasNextInt())
							int1 = input.nextInt();
						else {
							System.out.println("Invalid input entered. Terminating...");
							break;
						}	
						if (input.hasNextInt())
							int2 = input.nextInt();
						else {
							System.out.println("Invalid input entered. Terminating...");
							break;
						}
						if (operator.equals("add"))
							System.out.println("Answer: "+(int1+int2));
						else
							System.out.println("Answer: "+(int1-int2));
						break;
					case "multiply":
					case "divide":
						System.out.print("Enter two doubles: ");
						if (input.hasNextDouble())
							double1 = input.nextDouble();
						else {
							System.out.println("Invalid input entered. Terminating...");
							break;
						}	
						if (input.hasNextDouble())
							double2 = input.nextDouble();
						else {
							System.out.println("Invalid input entered. Terminating...");
							break;
						}
						if (operator.equals("multiply")) 
							System.out.printf("Answer: %.2f\n",(double1*double2));
						else if (double2 != 0) 
							System.out.printf("Answer: %.2f\n",(double1/double2));
						else 
							System.out.println("Invalid input entered. Terminating...");
						break;
					case "alphabetize":
						System.out.print("Enter two words: ");
						String str1 = input.next();
						String str2 = input.next();
						if (str1.toLowerCase().compareTo(str2.toLowerCase()) >0)
							System.out.printf("Answer: %s comes before %s alphabetically.\n", str2, str1);
						else if (str1.compareTo(str2) <0)
							System.out.printf("Answer: %s comes before %s alphabetically.\n", str1, str2);
						else
							System.out.printf("Answer: Chicken or Egg.\n");
						break;
					
					
					
					
				}
			}
		
		}
}