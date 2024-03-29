import com.sun.istack.internal.NotNull;
import sun.misc.resources.Messages;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Message> msgList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int input;
        int length;
        int update;
        String msgInput;
        Message msg;

        // PrintWriter fileSaver = new PrintWriter(new BufferedWriter(new FileWriter("C:/code/messages.txt", true)));
        // BufferedReader fileReader = new BufferedReader(new FileReader("C:/code/messages.txt"));

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

                System.out.print("Tryck Enter när du vill gå vidare.");
                sc.nextLine();
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

            if (input == 3)
            {
                do {
                    System.out.print("Meddelande som ska uppdateras: ");
                    update = sc.nextInt();
                    sc.nextLine();

                    if(update < 1 || update > msgList.size()) {
                        System.out.println("Det meddelande du ville ändra finns inte. Vänligen försök igen.");
                        System.out.print("Tryck Enter för att gå vidare.");
                        sc.nextLine();
                        System.out.println();
                    }

                } while (update < 1 || update > msgList.size());
                do {
                    System.out.print("\nDet uppdaterade meddelandet (Max 140 tecken): ");
                    msgInput = sc.nextLine();
                    length = msgInput.length();

                    if (length > 140) {
                        System.out.println("Ditt meddelande var för långt. Vänligen försök igen.");
                        System.out.print("Tryck Enter när du vill gå vidare.\n");
                        sc.nextLine();
                    }
                } while (length > 140);

                msgList.get(update - 1).msgChange(msgInput);
            }

            if (input == 4) {
                /* for (int i = 0; i < msgList.size(); i++) {
                    fileSaver.println(msgList.get(i).fileSaver);
                }

                fileSaver.close(); */

                FileOutputStream fileReader = new FileOutputStream(new File("C:/code/messageSystem/messages.txt"), true);
                ObjectOutputStream fileSaver = new ObjectOutputStream(fileReader);

                fileSaver.writeObject(msgList);

            }

            if (input == 5) {

                /* FileOutputStream fileReader = new FileOutputStream(new File("C:/code/messages.txt"));
                ObjectOutputStream fileSaver = new ObjectOutputStream(fileReader); */

                // msgList.add(new Message(fileReader.readLine(), fileReader.readLine()), fileReader.readLine(), fileReader.readLine());

                msgList.addAll(readMessages());
            }

        } while(input != 6);


    }

    private static ArrayList<Message> readMessages() throws IOException, ClassNotFoundException {
        ArrayList<Message> messages = new ArrayList<Message>();

        FileInputStream fi = new FileInputStream("C:/code/messageSystem/messages.txt");
        ObjectInputStream oi = new ObjectInputStream(fi);

        messages = (ArrayList<Message>) oi.readObject();

        return messages;
    }
}
