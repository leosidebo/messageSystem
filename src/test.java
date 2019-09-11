import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        ArrayList<Message> msgList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int input;
        int length;
        String msgInput;
        Message msg;

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
                System.out.println("");

                if (input < 1 || input > 6)
                {
                    System.out.println("Det gick inte att läsa in ditt val. Vänligen försök igen.");
                    System.out.print("Tryck Enter när du vill gå vidare.");
                    sc.nextLine();
                }

            } while (input < 1 || input > 6);

            if (input == 1)
            {
                for (int i = 0; i < msgList.size(); i++)
                {
                    System.out.println("Meddelande " + (i + 1) + ":");
                    System.out.println(msgList.get(i));
                }
            }

            if (input == 2)
            {
                do {
                    System.out.println("Tryck Enter när du är klar! (Max 140 tecken)");
                    System.out.print("Vänligen ange ditt meddelande: ");
                    msgInput = sc.nextLine();
                    length = msgInput.length();

                    if (length > 140) {
                        System.out.println("Ditt meddelande var för långt. Vänligen försök igen.");
                        System.out.print("Tryck Enter när du vill gå vidare.\n");
                        sc.nextLine();
                    }

                } while (length > 140);

                msg = new Message(msgInput);
                msgList.add(msg);
            }

        } while(input != 6);


    }
}
