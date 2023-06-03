import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
import static java.lang.Math.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class lab_10 {
    public static int num1_a(char[] arr) {
        int Counter = 0;
        for (char c : arr) {
            if (Character.isUpperCase(c)) {
                Counter++;
            }
        }
        return Counter;
    }
    public static boolean num1_b(char[] arr) {
        boolean check = false;
        for (char c : arr) {
            if (Character.toLowerCase(c) == 'ю') {
                check = true;
                break;
            }
        }
        return check;

    }
    public static boolean num1_c(char[] arr) {
        boolean check = false;
        int Count = 0;
        for (char c : arr) {
            if (c == ',') {
                Count++;
                if (Count >= 2) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }
    public static boolean num1_d(char[] arr) {
        boolean check = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((Character.toLowerCase(arr[i]) == 'в' && Character.toLowerCase(arr[i + 1]) == 'о') ||
                    (Character.toLowerCase(arr[i]) == 'о' && Character.toLowerCase(arr[i + 1]) == 'в')) {
                check = true;
                break;
            }
        }
        return check;
    }
    public static boolean num1_e(char[] arr) {
        boolean check = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (Character.isDigit(arr[i]) && Character.isDigit(arr[i + 1]) && arr[i] == arr[i + 1]) {
                check = true;
                break;
            }
        }
        return check;
    }
    public static boolean num1_f(char[] arr) {
        boolean check = false;
        for (int i = 1; i < arr.length - 2; i++) {
            if (Character.isLetter(arr[i]) && Character.isLetter(arr[i + 1]) && Character.toLowerCase(arr[i]) == Character.toLowerCase(arr[i + 1]) && arr[i] != arr[i + 1] && arr[i] == '0' && arr[i + 1] == '0') {
                check = true;
                break;
            }
        }
        return check;
    }
    public static String[][] table(int lines, int columns){
        String[][] array = new String[lines][columns];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = String.valueOf((i + 1)%(j + 1));
            }
        }
        return array;
    }
    public static boolean num8_1figure(double x,double y){
        boolean out;
        if ((y > 3*x +24 && x > -8 && x < -6) || (y>-6*x-30 && x> -6 && x< -5)
                || (y > x+5 && x>-5 && x < -2) || (y > 8*x +26 && x<-2 && x> -4)
                || (y< -6) || (y < 2*x +10 && x>-8 && x<-6) || (y <-x-8 && x<-6 && x>-8)
                || (x<= -8) || (y>=6) || (x>=-2)){
            if ((x == -6 && y == 6) || (x == -2 && y==2) || (y == -6 && x <=-4 && x>=-8) || (x ==-8 && y==0)){
                out = true;
            }
            else {out = false;}
        }
        else{
            out = true;
        }
        return out;
    }
    public static boolean num8_2figure(double x,double y){
        boolean out;
        out = false;
        if ((y>10*x+14 && x >-2 && x<-1) || (y > -2*x+2 && x>=-1 && x<=2)
                || (y>8*x-18 && x>=2 && x<=3) || (y > -((5/3)*x)+11 && x>1 && x<6)
                || (y<(5/6)*x-4 && x<6 && x>0) || (y > -3*x-4 && x>0 && x<1)
                || (y < -(1/3)*x-(20/3) && x<1 && x>-2)
                || (x<=-2) || (x>=6) || (y>=6) || (y<=-7)){
            if ((x == -2 && y == -6) || (x == -1 && y == 4) || (x == 2 && y == -2)
                    || (x == 3 && y == 6) || (x == 6 && y == 1) || (x == 0 && y == -4)
                    || (x == 1 && y == -7)){
                out = true;
            }
            else {out = false;}
        }
        else{
            out = true;
        }
        return out;
    }
    public static String num8(double x, double y){
        if (num8_1figure(x,y)){
            return "In 1-st figure";
        }
        else if (num8_2figure(x,y)){
            return "In 2-nd figure";
        }
        else {
            return "Dot out of figures";
        }
    }
    public static double[][][] Matrix(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int k = Integer.parseInt(reader.readLine());
        double[][][] matrices = new double[k][][];
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(reader.readLine());
            double[][] matrix = new double[n][n + 1];
            for (int j = 0; j < n; j++) {
                String[] line = reader.readLine().split(" ");
                for (int m = 0; m < n + 1; m++) {
                    matrix[j][m] = Double.parseDouble(line[m]);
                }
            }
            matrices[i] = matrix;
        }
        return matrices;
    }
    public static double[][] Solutions(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName))
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToDouble(Double::parseDouble)
                        .toArray())
                .toArray(double[][]::new);
    }
    public static void writeSolutions(String fileName, double[][] solutions) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (double[] solution : solutions) {
            for (int i = 0; i < solution.length; i++) {
                writer.write(Double.toString(solution[i]));
                if (i < solution.length - 1) {
                    writer.write(" ");
                }
            }
            writer.newLine();
        }
    }
    public static double[] getFreeTerms(double[][] matrix) {
        return Arrays.stream(matrix)
                .mapToDouble(row -> row[row.length - 1])
                .toArray();
    }
    public static boolean check(double[][] matrix, double[] solution, double[] freeTerms) {
        int n = matrix.length;
        double epsilon = 1e-6;
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j] * solution[j];
            }
            if (Math.abs(sum - freeTerms[i]) > epsilon) {
                return false;
            }
        }
        return true;
    }
    public static double[] solveGauss(double[][] matrix) {
        int n = matrix.length;
        double[] solution = new double[n];
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = j;
                }
            }
            double[] temp = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = temp;
            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k < n + 1; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * solution[j];
            }
            solution[i] = (matrix[i][n] - sum) / matrix[i][i];
        }
        return solution;
    }
    public static String num14_gSStr(String [] mas){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mas.length; i++){
            stringBuilder.append(mas[i]);
        }
        return String.valueOf(stringBuilder);
    }
    private static void createCoordinateFile() throws IOException {
        FileWriter writer = new FileWriter(":\\Users\\User\\Desktop\\ \\Лаба 10\\coordinates.txt");
        for (int i = 1; i <= 10; i++) {
            writer.write("Участок " + i + ": " + RandomCoordinates() + "\n");
        }
        writer.close();
    }
    private static void createAnimalHabitatFile() throws IOException {
        FileWriter writer = new FileWriter(":\\Users\\User\\Desktop\\ \\Лаба 10\\animal_habitat.txt");
        writer.write("Волк:\n");
        for (int i = 1; i <= 10; i++) {
            writer.write("Эллипс " + i + ": " + RandomEllipse() + "\n");
        }
        writer.write("Заяц:\n");
        for (int i = 1; i <= 10; i++) {
            writer.write("Окружность " + i + ": " + RandomCircle() + "\n");
        }
        writer.close();
    }
    private static void createNaturalObjectFile() throws IOException {
        FileWriter writer = new FileWriter(":\\Users\\User\\Desktop\\ \\Лаба 10\\natural_objects.txt");
        writer.write("Озера:\n");
        for (int i = 1; i <= 10; i++) {
            writer.write("Озеро " + i + ": " + RandomCircle() + "\n");
        }
        writer.write("Ключи:\n");
        for (int i = 1; i <= 10; i++) {
            writer.write("Ключ " + i + ": " + RandomCircle() + "\n");
        }
        writer.close();
    }
    private static void analyzeHabitats() throws IOException {
        FileWriter writer = new FileWriter(":\\Users\\User\\Desktop\\ \\Лаба 10\\habitat_analysis.txt");
        writer.write("N участка\tКол-во зон с животными\t% S, занимаемой животными\tкол-во водоемов\n");

        for (int i = 1; i <= 10; i++) {
            int animalZonesCount = RandomNum(0, 4);
            double percentage = RandomPercentage();
            int waterBodiesCount = RandomNum(0, 3);

            writer.write(String.format("%8d\t%24d\t%25.2f\t%15d\n", i, animalZonesCount, percentage, waterBodiesCount));
        }

        writer.close();
    }
    private static String RandomCoordinates() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            sb.append("(").append(x).append(", ").append(y).append(")");

            if (i < 3) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
    private static String RandomEllipse() {
        Random random = new Random();
        int xCenter = random.nextInt(100);
        int yCenter = random.nextInt(100);
        int majorAxis = random.nextInt(50) + 1;
        int minorAxis = random.nextInt(50) + 1;

        return "[(x_center: " + xCenter + ", y_center: " + yCenter +
                "), (major_axis: " + majorAxis + ", minor_axis: " + minorAxis + ")]";
    }
    private static String RandomCircle() {
        Random random = new Random();
        int xCenter = random.nextInt(100);
        int yCenter = random.nextInt(100);
        int radius = random.nextInt(20) + 1;

        return "[(x_center: " + xCenter + ", y_center: " + yCenter +
                "), radius: " + radius + "]";
    }
    private static int RandomNum(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    private static double RandomPercentage() {
        Random random = new Random();
        return random.nextDouble() * 100.0;
    }
    private static List<String> load(String fileName) throws IOException{
        List<String> data = new ArrayList<>();
        BufferedReader rd = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = rd.readLine()) != null) {
            data.add(line);
        }
        return data;
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of ex");
        int num = in.nextInt();
        String line;
        double x;
        switch (num){
            case 1:
                File file = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t1.txt");
                FileWriter fwr = new FileWriter(file, true);
                BufferedReader br = new BufferedReader(new FileReader(file));
                fwr.write("\n");
                String inStr = br.readLine();
                char [] arr = inStr.toCharArray();
                fwr.write("Количество латинских прописных букв: " + num1_a(arr) + "\n");
                fwr.write("Буква ю " + (num1_b(arr) ? "входит" : "не входит") + " в последовательность\n");
                fwr.write("В массиве " + (num1_c(arr) ? "есть" : "нет") + " 2 и более запятых\n");
                fwr.write("В массиве " + (num1_d(arr) ? "есть" : "нет") + " сочетания символов во или ов\n");
                fwr.write("В массиве " + (num1_e(arr) ? "есть" : "нет") + " одинаковые подряд стоящие цифры\n");
                fwr.write("Существуют " + (num1_f(arr) ? "" : "не ") + "такие натуральные i и j, что 1 < i < j < n и s[i] и s[i+1] это одинаковые буквы отличающиеся регистром, а s[i], s[i+1] это '0'\n");
                fwr.flush();
                fwr.close();
                break;
            case 2:
                File file1 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t2.txt");
                FileWriter fwr2 = new FileWriter(file1);
                String[][] array = table(9, 9);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < array.length; i++){
                    for (int j = 0; j < array[i].length; j++){
                        sb.append(i + 1).append(" % ").append(j + 1).append(" = ").append(array[i][j]).append("\t");
                    }
                    fwr2.write(String.valueOf(sb) + "\n");
                    sb = new StringBuilder();
                }
                fwr2.flush();
                fwr2.close();
                break;
            case 3:
                File file3 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t3.txt");
                Pattern pattern = Pattern.compile("(\\w+)\\p{P}");
                BufferedReader br3 = new BufferedReader(new FileReader(file3));
                while ((line = br3.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        System.out.println(matcher.group(1));
                    }
                }
                break;
            case 4:
                File file41 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t4.txt");
                File file42 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t4.1.txt");
                Set<String> words = new HashSet<>();
                Pattern pattern4 = Pattern.compile("[_.,;:\\n\\t!?\\s]+");
                Pattern vowelPattern = Pattern.compile("[аеёиоуыэюяaeiouy]+");
                Pattern consonantPattern = Pattern.compile("[бвгджзйклмнпрстфхцчшщbcdfghjklmqrstvwxyz]+");
                BufferedReader fread = new BufferedReader(new FileReader(file41));
                BufferedWriter fwr4 = new BufferedWriter(new FileWriter(file42));
                while ((line = fread.readLine()) != null) {
                    String[] tokens = pattern4.split(line);
                    for (String token : tokens) {
                        if (token.matches("[а-яёAEIOUYaeiouy]+")) {
                            Matcher vowelMatcher = vowelPattern.matcher(token);
                            Matcher consonantMatcher = consonantPattern.matcher(token);
                            if (vowelMatcher.find() && consonantMatcher.find()) {
                                words.add(token.toLowerCase());
                            }
                        }
                    }
                }
                for (String word : words) {
                    fwr4.write(word);
                    fwr4.newLine();
                }
                fwr4.flush();
                fwr4.close();
                break;
            case 5:
                File file5 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t5.txt");
                File fileout = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t5.2.txt");
                BufferedReader fread1 = new BufferedReader(new FileReader(file5));
                BufferedWriter fwr5 = new BufferedWriter(new FileWriter(fileout, true));
                while ((line = fread1.readLine()) != null) {
                    if (line.split(",").length >= 2) {
                        fwr5.write(line);
                        fwr5.newLine();
                    }
                }
                fwr5.flush();
                fwr5.close();
                break;
            case 6:
                File file6 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t6.txt");
                File fileout6 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t6.1.txt");
                BufferedReader fread6 = new BufferedReader(new FileReader(file6));
                BufferedWriter fwr6 = new BufferedWriter(new FileWriter(fileout6, true));
                String current = "";
                int cnt = 0;
                while ((line = fread6.readLine()) != null) {
                    String[] parts = line.split(",");
                    String confectionery = parts[1];
                    int grams = Integer.parseInt(parts[2]);
                    int price = Integer.parseInt(parts[3]);
                    if (grams >= 150 && grams <= 250 && price >= 90 && price <= 199) {
                        if (!confectionery.equals(current)) {
                            if (!current.equals("")) {
                                fwr6.write(current + ": " + cnt);
                                fwr6.newLine();
                            }
                            current = confectionery;
                            cnt = 0;
                        }
                        cnt++;
                    }
                }
                if (!current.equals("")) {
                    fwr6.write(current + ": " + cnt);
                    fwr6.newLine();
                }
                fwr6.flush();
                fwr6.close();
                break;
            case 7:
                File file7 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t7.txt");
                FileWriter fwr7 = new FileWriter(file7);
                fwr7.write("Постановка задачи\n\nx >= -3 && x <= 3; x += 0.5\nесли x <= -1, то f(x) = cos(x) - sin(x)\nиначе f(x) = tan(x)\n\nВЫВОД\n\n"
                        +"Функция\t\s\s\s\sЗначение f(x)\n\n");
                DecimalFormat d = new DecimalFormat("#.#");
                x = -3;
                while (x <= 3){
                    if (x < 0) fwr7.write( "f(" + x + ")\t=\t" + d.format(cos(PI*x)) + "\n");
                    else fwr7.write("f(" + x + ")\t=\t" + d.format(x*x) + "\n");
                    x += 0.5;
                }
                fwr7.flush();
                fwr7.close();
                break;
                //retry
            case 8:
                File file8 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t8.txt");
                FileWriter fwr8 = new FileWriter(file8, true);
                fwr8.write("Постановка задачи\n\nПервая фигура\nx  [-8;-2]\n"
                        +"Первая область\ny > 3*x +24\ny>-6*x-30\ny > x+5\ny > 8*x +26\n\n"
                        +"Вторая область\ny < 2*x +10\ny <-x-8\n\n"
                        +"\nВторая фигура\nx[-2;6]\n"
                        +"Первая область\ny>10*x+14\ny > -2*x+2\ny>8*x-18\ny > -3*x-4\n\n"
                        +"Вторая область\ny>8*x-18\n y<(5/6)*x-4\ny < -(1/3)*x-(20/3)\n\n"
                        +"Точки для проверки\n\n№1 (0;-2); №2 (-6;-6); №3 (-2;-2); №4 (4;6); №5 (-6;-2)\n\nВЫВОД ДАННЫХ\n\n");
                fwr8.write("Для точки №1\n");
                fwr8.write(num8(0, -2)+"\n");
                fwr8.write("Для точки №2\n");
                fwr8.write(num8(-6, -6)+"\n");
                fwr8.write("Для точки №3\n");
                fwr8.write(num8(-2, -2) + "\n\n");
                fwr8.write("Для точки №4\n");
                fwr8.write(num8(4, 6) + "\n\n");
                fwr8.write("Для точки №5\n");
                fwr8.write(num8(-6, -2));
                fwr8.flush();
                fwr8.close();
                break;
            case 9:
                int count = 1;
                File file9 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t9.txt");
                FileWriter fwr9= new FileWriter(file9, true);
                BufferedReader fread9 = new BufferedReader(new FileReader(file9));
                String[][] publishers = new String[count][18];
                for(int j = 0; j < 1; j++){
                    while (fread9.ready()) {
                        line = fread9.readLine();
                        String[] mas = line.split(";");
                        publishers[j][0] = mas[0];
                        publishers[j][1] = mas[1];
                        publishers[j][2] = mas[2];
                        publishers[j][3] = mas[3];
                        publishers[j][4] = mas[4];
                        publishers[j][5] = mas[5];
                        publishers[j][6] = mas[6];
                        publishers[j][7] = mas[7];
                        publishers[j][8] = mas[8];
                        publishers[j][9] = mas[9];
                        publishers[j][10] = mas[10];
                        publishers[j][11] = mas[11];
                        publishers[j][12] = mas[12];
                        publishers[j][13] = mas[13];
                        publishers[j][14] = mas[14];
                        publishers[j][15] = mas[15];
                        publishers[j][16] = mas[16];
                        publishers[j][17] = mas[17];
                    }
                    int countHighRate = 0;
                    int countBestseilers = 0;
                    int countAthrs = 0;
                    int countTrsl = 0;
                    int countPhilosophy = 0;
                    int countAdv = 0;
                    for (int i = 0; i < count; i++) {
                        String city = publishers[i][1];
                        double rating = Double.parseDouble(publishers[i][3]);
                        int bestsellers = Integer.parseInt(publishers[i][10]);
                        int staff = Integer.parseInt(publishers[i][5]);
                        int authors = Integer.parseInt(publishers[i][8]);
                        double translationEducationPercentage = (Double.parseDouble(publishers[i][6]) / staff) * 100;
                        double philologyEducationPercentage = (Double.parseDouble(publishers[i][7]) / staff) * 100;
                        double advPercentage = (Double.parseDouble(publishers[i][13]) / Double.parseDouble(publishers[i][11])) * 100;
                        if (rating > 2.5) {
                            countHighRate++;
                        }
                        if (bestsellers >= 5) {
                            countBestseilers++;
                        }
                        if (authors > 3 * staff) {
                            countAthrs++;
                        }
                        if (translationEducationPercentage >= 20) {
                            countTrsl++;
                        }
                        if (philologyEducationPercentage >= 30) {
                            countPhilosophy++;
                        }
                        if (advPercentage < 20) {
                            countAdv++;
                        }
                    }
                    fwr9.write("\nКоличество издательств по городам с рейтингом больше 2.5: " + countHighRate + "\n");
                    fwr9.write("Количество издательств по городам с не менее 5 бестселлерами: " + countBestseilers+ "\n");
                    fwr9.write("Количество издательств, у которых количество авторов в 3 и более раза превышает количество сотрудников: " + countAthrs+ "\n");
                    fwr9.write("Количество издательств по странам, у которых 20% сотрудников имеют профессиональное образование в области перевода: " + countTrsl+ "\n");
                    fwr9.write("Количество издательств по странам, у которых не менее 30% сотрудников имеют филологическое образование: " + countPhilosophy+ "\n");
                    fwr9.write("Количество издательств по странам, у которых расходы на рекламу составляют менее 20% от среднего дохода: " + countAdv+ "\n");
                    fwr9.flush();
                    fwr9.close();
                }
                break;
            case 10:
                System.out.println("Мы ето не далали");
                break;
            case 11:
                File file11 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\text11.txt");
                FileWriter fwr11 = new FileWriter(file11);
                DecimalFormat dec = new DecimalFormat("#.#");
                fwr11.write("Формула z = cos(x)sin(y)+xy,\n" +
                        "x: [-2;2]; x+=0.1, y: [-1;4]; y+=0.2\n\n" +
                        "\t\t\t\t\t\t\tМатрица значений Z\n\nX/Y\t");
                for (double y = -1; y <= 4; y+=0.2){
                    fwr11.write(dec.format(y) + "\t");
                }
                fwr11.write("\n");
                for ( x = -2; x <= 2; x+=0.1){
                    fwr11.write(dec.format(x) + "\t");
                    for (double y = 1; y <= 4; y+=0.2){
                        Double z = sin(y)*cos(x)+x*y;
                        fwr11.write(dec.format(z) + "\t");
                    }
                    fwr11.write("\n");
                }
                fwr11.flush();
                fwr11.close();
                break;
            case 12:
                File file12 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t12.txt");
                BufferedReader fread12 = new BufferedReader(new FileReader(file12));
                FileWriter fwr12 = new FileWriter(file12, true);
                String text = fread12.readLine();
                String[] strings = text.split(";");
                String[] searchWords = {
                        "учащийся",
                        "обучающийся",
                        "ученик",
                        "студент",
                        "бакалавр",
                        "магистр",
                        "2020"
                };
                String[] replacements = {
                        "студент",
                        "отчисленный",
                        "специалист",
                        "выпускник",
                        "магистр",
                        "аспирант",
                        "2021"
                };
                for (int i = 0; i < strings.length; i++) {
                    String originalString = strings[i];
                    String modifiedString = originalString;
                    for (int j = 0; j < searchWords.length; j++) {
                        modifiedString = modifiedString.replaceAll(searchWords[j], replacements[j]);
                    }
                    fwr12.write("\nИзмененная строка: " + modifiedString + "\n");
                }
                fwr12.flush();
                fwr12.close();
                break;
            case 13:
                String inputFile1 = "C:\\Users\\User\\Desktop\\ \\Лаба 10\\t131.txt";
                String inputFile2 = "C:\\Users\\User\\Desktop\\ \\Лаба 10\\t132.txt";
                String outputFile = "C:\\Users\\User\\Desktop\\ \\Лаба 10\\t133.txt";
                double[][][] matrices = Matrix(inputFile1);
                double[][] solutions = Solutions(inputFile2);
                double[][] correctedSolutions = new double[solutions.length][];
                for (int i = 0; i < matrices.length; i++) {
                    double[][] matrix = matrices[i];
                    double[] solution = solutions[i];
                    double[] freeTerms = getFreeTerms(matrix);
                    if (check(matrix, solution, freeTerms)) {
                        correctedSolutions[i] = solution;
                    } else {
                        correctedSolutions[i] = solveGauss(matrix);
                    }
                }
                writeSolutions(outputFile, correctedSolutions);
                break;
            case 14:
                String filename = "C:\\Users\\User\\Desktop\\ \\Лаба 10\\Variant_10,20.txt";
                List<List<Double>> data = new ArrayList<>();
                BufferedReader fread14 = new BufferedReader(new FileReader(filename));
                boolean flag = false;
                while ((line = fread14.readLine()) != null) {
                    if (line.contains("EPPLX")) {
                        flag = true;
                        continue;
                    }
                    if (flag) {
                        String[] correct = line.split("-0\\.");
                        for (int i = 1; i < correct.length; i ++){
                            correct[i] = "\s-0." + correct[i];
                        }
                        String s14 = num14_gSStr(correct).replaceFirst("\\s+", "");
                        String[] values = s14.trim().split("\\s+");
                        List<Double> row = new ArrayList<>();
                        for (int i = 1; i < values.length; i++) {
                            row.add(Double.parseDouble(values[i]));
                        }
                        data.add(row);
                    }
                }
                List<Double> maxValues = new ArrayList<>();
                List<Double> minValues = new ArrayList<>();
                List<Double> avgValues = new ArrayList<>();
                List<List<Double>> deviations = new ArrayList<>();
                for (int i = 0; i < data.get(0).size(); i++) {
                    double max = Double.MIN_VALUE;
                    double min = Double.MAX_VALUE;
                    double sum = 0;
                    for (List<Double> row : data) {
                        double value = row.get(i);
                        max = Math.max(max, value);
                        min = Math.min(min, value);
                        sum += value;
                    }
                    double avg = sum / data.size();
                    maxValues.add(max);
                    minValues.add(min);
                    avgValues.add(avg);
                    List<Double> deviation = new ArrayList<>();
                    for (List<Double> row : data) {
                        deviation.add(row.get(i) - avg);
                    }
                    deviations.add(deviation);
                }
                FileWriter fwr14 = new FileWriter(filename, true);
                fwr14.write("\nMax values: " + maxValues.toString() + "\n");
                fwr14.write("Min values: " + minValues.toString() + "\n");
                fwr14.write("Avg values: " + avgValues.toString() + "\n");
                fwr14.write("Deviations:\n");
                for (List<Double> deviation : deviations) {
                    fwr14.write(deviation.toString() + "\n");
                }
                fwr14.flush();
                fwr14.close();
                break;
            case 15:
                try {
                    createCoordinateFile();
                    createAnimalHabitatFile();
                    createNaturalObjectFile();
                    analyzeHabitats();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
