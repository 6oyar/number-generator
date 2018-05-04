package configuration;

import java.io.*;

public class Configuration {
    /**
     * Измените путь!
     * */
    private static final String CONFIG_PATH = "C:\\Users\\boris\\Documents\\number-generator\\config.txt";

    public static int[] getStartNumber() {
        File file = new File(CONFIG_PATH);
        int[] symbols = new int[6];
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
                for (int i = 0; i < symbols.length; i++) {
                    symbols[i] = Integer.parseInt(reader.readLine());
                }
            }catch (IOException e) {
                e.printStackTrace();
                symbols = new int[]{0,0,0,0,0,0};
            }
        } else {
            symbols = new int[]{0,0,0,0,0,0};
        }
        return symbols;
    }
}
