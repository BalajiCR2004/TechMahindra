public class AlternateCapitalizer{
    public static void main(String[] args) {
        String input="balaji";
        StringBuilder result = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            if(i%2==0){
                result.append(Character.toUpperCase(input.charAt(i)));
            }
            else{
                result.append(Character.toLowerCase(input.charAt(i)));
            }
        }

        System.out.println("Original String: "+input);
        System.out.println("Alternate String: "+result );
    }
}