
public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        String lcName = name.trim();

        if (lcName.length() <= 3 || lcName.length() >= 19) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < lcName.length(); i++) {
            if (Character.isWhitespace(lcName.charAt(i))) {
                count++;
            }
        }

        if (count == 1) {

            return true;
        }
        return false;
    }
}