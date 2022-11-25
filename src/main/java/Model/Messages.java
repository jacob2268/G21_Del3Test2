package Model;

import java.io.*;

public class Messages  {

    String messages = "messages.txt";
    public void createMessages() throws IOException {
        try {
            File messages = new File("message.txt");
            if(messages.createNewFile())
                System.out.println("File created: " + messages.getName());
             else
                System.out.println("File already exists");

        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {

        BufferedReader reader =  new BufferedReader(new FileReader(messages));
        String currentLine = reader.readLine();



    }
}
