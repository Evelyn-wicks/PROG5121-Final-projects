/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog_5121final;
// Part 1


/**
 *
 * @author evely
 */
public class Prog_5121final {

    public static void main(String[] args) {
        System.out.println("Message");
        
    package com.mycompany.prog_5121final;
    
    import java.io.FileWriter;
    import java.io.IOException;
            
     public class message {       
         //message ID should not have more than 10 characters
     public boolean checkMessageID(String messageID) {   
         return messagID != null && messageID.length() <= 10;
     }
         
         //make sure the receiver cell number has an international code
         public boolean checkRecipientCell(String cellNumber) {
             //check number
             if (cellNumber != null && (cellNumber.matches("^\\+27\\d{9}") || (cellNumber.startsWith("+") && cellNumber.length() <= 12))) {
                 return true;
         }
         return false;
         
         //create the message hash
         public String create MessageHash(String messageID, int messageNumber, String messageText) {
             String idPrefix = (messageID != null && messageID.length() >= 2 ? messageID.substring(0, 2) : "00");
             //tidy up message
             String cleanText =messageText == null ? "" : messageText.trim().replaceAll("[^a-zA-Z ]","");
             String [] words = cleanText.split("\\s+");
             
             String firstword = "";
             String lastWord = "";
             
             if (words.length > 0 && !words[0].isEmpty()) {
                 firstWord = words[0];
             }
             if (words.length > 1 && !words[0].isEmpty()) {
                 lastWord = words[words.length - 1];
             } else if (words.length == 1) {
                 lastWord = firstword;
             }
             
             String combinationWords = (firstWord + lastWord.toUpperCase();
             return idPrefix + ":" + messageNumber + ":" + combinationWords;
         }
         //message actions
         public String sentMessageChoice(int choice) {
             switch (choice) {
                 case 1:
                     return "Message successfully sent.";
                 case 2:
                     return "press 0 to delete this message.";
                 case 3:
                     return "Message stored";
                  default:
                       return "Invalid choice.";
             }
             
             //message details
             public void storeMessage(String messageID, String recipient,String messageText, String hash) {
                 //file structure
                 String jsonContent = "{\n" +
                         "  \"MessageID\": \"" + messageID + "\",\n" +
                         "  \"Recipient\": \"" + recipient + "\",\n" +
                         "  \"Message\": \"" + messageText + "\",\n" +
                         " \"?Hash\": \"" + hash + "\"\n" +
                         "}";
                 
                 try (FileWriter file = new FileWritter("stored_messages.json", true)) {
                     file.write(jsonContent + "\n");
                     System.out.println("message approved.");
                 } catch (IOExeption e) {
                     System.out,println("Error writing: " + e.getMessage());
                     
                     //part 2 messaging feature updates
           import java.util.Scanner;
import java.util.Random;

public class Prog_5121final {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        Message msgHelper = new Message();

        System.out.println("=== PART 1: REGISTRATION & LOGIN ===");
        
        // Registration phase
        System.out.print("Enter username (must contain '_' and be <= 5 chars): ");
        String regUser = scanner.nextLine();
        
        System.out.print("Enter password (>= 8 chars, 1 capital, 1 number, 1 special char): ");
        String regPass = scanner.nextLine();
        
        System.out.print("Enter cell phone number (e.g., +27838968976): ");
        String regCell = scanner.nextLine();

        String regResult = login.registerUser(regUser, regPass, regCell);
        System.out.println(regResult);

        // Only proceed to login if registration was successful
        boolean isLoggedIn = false;
        if (regResult.contains("successfully")) {
            System.out.println("\n--- Please Login ---");
            System.out.print("Username: ");
            String loginUser = scanner.nextLine();
            
            System.out.print("Password: ");
            String loginPass = scanner.nextLine();

            isLoggedIn = login.loginUser(loginUser, loginPass, regUser, regPass);
            
            // Assuming default first/last name for welcome message
            String loginStatus = login.returnLoginStatus(isLoggedIn, "John", "Doe");
            System.out.println(loginStatus);
        }

        // PART 2: MESSAGING FEATURE (Potected by successful login)[span_5](start_span)[span_5](end_span)
        if (isLoggedIn) {
            System.out.println("\nWelcome to whatsapp.");[span_6](start_span)[span_6](end_span)
            boolean running = true;
            
            while (running) {[span_7](start_span)[span_7](end_span)[span_8](start_span)[span_8](end_span)
                System.out.println("\n--- Whatsapp Menu ---");
                System.out.println("1) Send Messages");[span_9](start_span)[span_9](end_span)
                System.out.println("2) Show recently sent messages");[span_10](start_span)[span_10](end_span)
                System.out.println("3) Quit");[span_11](start_span)[span_11](end_span)
                System.out.print("Choose an option (1-3): ");
                
                int choice = -1;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                } else {
                    scanner.nextLine(); // clear invalid input
                    System.out.println("Please enter a valid numeric option.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("How many messages do you wish to enter? ");
                        int totalMessages = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        int sentCount = 0;
                        Random random = new Random();

                        for (int i = 0; i < totalMessages; i++) {[span_12](start_span)[span_12](end_span)
                            System.out.println("\n--- Entering Message " + (i + 1) + " of " + totalMessages + " ---");
                            
                            // Generate random 10-digit message ID
                            long randomID = 1000000000L + (long)(random.nextDouble() * 9000000000L);
                            String messageID = String.valueOf(randomID);

                            if (!msgHelper.checkMessageID(messageID)) {
                                System.out.println("Error: Message ID exceeds 10 characters.");
                                continue;
                            }

                            System.out.print("Enter recipient cell number (e.g., +27838968976): ");
                            String recipient = scanner.nextLine();

                            if (!msgHelper.checkRecipientCell(recipient)) {
                                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                                continue;
                            }

                            System.out.print("Enter message text (max 250 characters): ");
                            String messageText = scanner.nextLine();

                            if (messageText.length() > 250) {
                                System.out.println("Please enter a message of less than 250 characters.");[span_13](start_span)[span_13](end_span)
                                continue;
                            } else {
                                System.out.println("Message ready to send.");[span_14](start_span)[span_14](end_span)
                            }

                            // Generate Message Hash
                            String messageHash = msgHelper.createMessageHash(messageID, i, messageText);
                            System.out.println("Generated Message Hash: " + messageHash);[span_15](start_span)[span_15](end_span)[span_16](start_span)[span_16](end_span)

                            // Action selection: Send, Discard, or Store
                            System.out.println("Choose action: 1) Send Message | 2) Disregard Message | 3) Store Message to send later");
                            int actionChoice = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            String actionResult = msgHelper.sentMessageChoice(actionChoice);
                            System.out.println(actionResult);

                            if (actionChoice == 3) {
                                msgHelper.storeMessage(messageID, recipient, messageText, messageHash);[span_17](start_span)[span_17](end_span)
                            }

                            if (actionChoice == 1) {
                                sentCount++;
                                System.out.println("\n--- Message Details ---");
                                System.out.println("Message ID: " + messageID);[span_18](start_span)[span_18](end_span)
                                System.out.println("Message Hash: " + messageHash);[span_19](start_span)[span_19](end_span)
                                System.out.println("Recipient: " + recipient);[span_20](start_span)[span_20](end_span)
                                System.out.println("Message: " + messageText);[span_21](start_span)[span_21](end_span)
                            }
                        }
                        System.out.println("\nTotal messages processed in this session: " + totalMessages);[span_22](start_span)[span_22](end_span)
                        break;

                    case 2:
                        System.out.println("Coming Soon.");[span_23](start_span)[span_23](end_span)
                        break;

                    case 3:
                        running = false;
                        System.out.println("Exiting Whatsapp. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose between 1 and 3.");
                }
            }
        } else {
            System.out.println("Access denied. You must log in successfully to use Whatsapp.");[span_24](start_span)[span_24](end_span)
        }
        scanner.close();
    }
}
    }
}
             
             //Part 3
             //ways to read stored messages
             //storing data into arrays
             
             public int loadStoredMessagesToArray(String[] storedMessagesArray, String[] recipientArray, String[] hashArray, String[] idArray) {
        // In a complete implementation, you would read line-by-line from "stored_messages.json"
        // Here is the sample test data required by the PoE to populate arrays for testing:
        String[] testRecipients = {"+27834667896", "+27835554567", "+27834444567", "0838884567", "+27838884567"};
        String[] testMessages = {
            "come get the cake?",
            "Where are you? You are always late Mbali! I have asked you to be on time.",
            "Heyyy!, I am at your gate.",
            "It is dinner time !",
            "Fine, I am leaving without you bye."
        };
        String[] testHashes = {"00:0:DIDCAKE", "00:1:WHEREWA", "00:2:YOHOOOO", "00:3:ITDINNER", "00:4:OKLEAVING"};
        String[] testIds = {"1001", "1002", "1003", "1004", "1005"};

        int count = testMessages.length;
        for (int i = 0; i < count; i++) {
            storedMessagesArray[i] = testMessages[i];
            recipientArray[i] = testRecipients[i];
            hashArray[i] = testHashes[i];
            idArray[i] = testIds[i];
        }
        return count;
    }

    // Display longest stored message
    public String getLongestMessage(String[] messages, int count) {
        if (count <= 0) return "No messages available.";
        String longest = messages[0];
        for (int i = 1; i < count; i++) {
            if (messages[i] != null && messages[i].length() > longest.length()) {
                longest = messages[i];
            }
        }
        return longest;
    }

    // Search messages by recipient
    public String searchByRecipient(String targetRecipient, String[] recipients, String[] messages, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (recipients[i] != null && recipients[i].equals(targetRecipient)) {
                result.append("\"").append(messages[i]).append("\" ");
            }
        }
        return result.length() > 0 ? result.toString().trim() : "No messages found for this recipient.";
    }

    // Delete message using message hash
    public boolean deleteMessageByHash(String targetHash, String[] hashes, String[] messages, int count) {
        for (int i = 0; i < count; i++) {
            if (hashes[i] != null && hashes[i].equalsIgnoreCase(targetHash)) {
                hashes[i] = null;
                messages[i] = null;
                return true;
            }
        }
        return false;
    }

    // Display Full Report of Stored Messages
    public void displayReport(String[] ids, String[] hashes, String[] recipients, String[] messages, int count) {
        System.out.println("\n--- STORED MESSAGES REPORT ---");
        for (int i = 0; i < count; i++) {
            if (messages[i] != null) {
                System.out.println("Message ID: " + ids[i]);
                System.out.println("Message Hash: " + hashes[i]);
                System.out.println("Recipient: " + recipients[i]);
                System.out.println("Message: " + messages[i]);
                System.out.println("--------------------------------");
            }
        }
    }

                     
         
                     
                     
  
                 
                 
    
}
