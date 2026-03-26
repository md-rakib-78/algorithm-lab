import java.io.*;
import java.util.*;

public class huffmanCodeArrayList {


    public static void huffmanCoding(ArrayList<ArrayList<Object>> list) 
    {
        while (list.size() > 1) 
        {
    
            list.sort(Comparator.comparingInt(innerList -> (int) innerList.get(0)));

        
            int sum = (int) list.get(0).get(0) + (int) list.get(1).get(0);

           
            ArrayList<Object> combined = new ArrayList<>();

            combined.add(sum);
            combined.add(list.get(0)); 
            combined.add(list.get(1)); 

         
            list.remove(0);
            list.remove(0);

          
            list.add(combined);
        }

        
        ArrayList<Object> root = list.get(0);
        System.out.println("Huffman Tree Constructed Successfully!");

 
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void generateCodes(ArrayList<Object> node, String code, Map<Character, String> huffmanCodes) {
        if (node.size() == 2) {
        
            char character = (char) ((int) node.get(1) + 'a');
            huffmanCodes.put(character, code);
            return;
        }

        
        generateCodes((ArrayList<Object>) node.get(1), code + "0", huffmanCodes);

        generateCodes((ArrayList<Object>) node.get(2), code + "1", huffmanCodes);
    }

    public static void main(String[] args) {
        File file = new File("input.txt");
        String text = "";

        
        try (Scanner scanner = new Scanner(file)) 
        {
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine())
           {
                sb.append(scanner.nextLine());
            }

            text = sb.toString();

        } 
        catch (Exception e) 
        {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        int[] freq = new int[26];
        for (char c : text.toCharArray()) 
        {
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            }
        }

        
        ArrayList<ArrayList<Object>> list = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) 
            {
                ArrayList<Object> node = new ArrayList<>();
                node.add(freq[i]);
                node.add(i);      
                list.add(node);
            }
        }

 
        huffmanCoding(list);
    }
}

