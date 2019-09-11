import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input;

        do {
            do {
                System.out.println("1. Visa meddelanden");
                System.out.println("2. Lägg till meddelande");
                System.out.println("3. Uppdatera meddelande");
                System.out.println("4. Spara meddelanden till fil");
                System.out.println("5. Läs in meddelande från fil");
                System.out.println("6. Avsluta");

                System.out.print("\nAnge ditt val, tryck sedan Enter: ");
                input = sc.nextInt();
                sc.nextLine();

                if (input < 1 || input > 6)
                {
                    System.out.println("\nDet gick inte att läsa in ditt val. Vänligen försök igen.");
                    System.out.print("Tryck Enter när du vill gå vidare.");
                    sc.nextLine();
                }

            } while (input < 1 || input > 6);

            if (input == 1)
            {

            }

            if (input == 2)
            {

            }

        } while(input != 6);


    }
}
