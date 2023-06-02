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
    public static String num8(double x, double y){
        if (((y > 0.25 * x - 1) & y > 1.25 * x - 1 & y > - 4 * x - 18)
                & ((x < -3 & x > -5 & y < 0.5*x + 4.5)
                || (x > -3 & x < 1 & y < sqrt(4-pow(x + 1,2)) + 3)
                ||(x > 1 & x < 4 & y < 0.33*x + 2.67) )){
            return "Точка попала в область первой фигуры\n";
        }else if ((y < x - 2 & y < -4*x +28 & y > -3*x + 14 & y >= 0)
                || (y > -sqrt(4-pow(x - 5,2))&(x <= 5 & x > 3 & (y < -0.5*x + 1.5
                || y > -3*x + 14) || x > 5)&y<=2)){
            return "Точка попала в область второй фигуры\n";
        }else if (((y >= 0.25 * x - 1) & y >= 1.25 * x - 1 & y >= - 4 * x -18)
                & ((x <= -3 & x >= -5 & y <= 0.5*x + 4.5)
                || (x >= -3 & x <= 1 & y <= sqrt(4-pow(x + 1,2)) + 3)
                ||(x >= 1 & x <= 4 & y <= 0.33*x + 2.67) )){
            return "Точка попала на границу первой фигуры";
        }else if ((y <= x - 2 & y <= -4*x +28 & y >= -3*x + 14 & y >= 0)
                || (y >= -sqrt(4-pow(x - 5,2))&(x <= 5 & x > 3 & (y <= -0.5*x + 1.5
                || y >= -3*x + 14) || x >= 5)&y<=2)){
            return "Точка попала на границу второй фигуры";
        }else {
            return "Точка не попала ни в область, ни на границу";
        }
    }
    public static int factorial10(int enter1){
        int res1 = 1;
        for (int i = 1; i <= enter1; i ++){
            res1 *= i;
        }
        return res1;
    }
    private static List<double[][]> num13_read(String file) throws IOException {
        List<double[][]> array1 = new ArrayList<>();
        List<String> line = Files.readAllLines(Paths.get(file));
        int n = Integer.parseInt(line.get(0));
        line.remove(0);
        while (!line.isEmpty()) {
            double[][] matrix = new double[n][n + 1];
            for (int i = 0; i < n; i++) {
                String[] value = line.get(0).split(" ");
                for (int j = 0; j < n + 1; j++) {
                    matrix[i][j] = Double.parseDouble(value[j]);
                }
                line.remove(0);
            }
            array1.add(matrix);
        }
        return array1;
    }
    private static List<double[]> num13_readSLAU(String file) throws IOException {
        List<double[]> arrayS = new ArrayList<>();
        List<String> line = Files.readAllLines(Paths.get(file));
        while (!line.isEmpty()) {
            String[] values = line.get(0).split(" ");
            double[] s = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                s[i] = Double.parseDouble(values[i]);
            }
            arrayS.add(s);
            line.remove(0);
        }
        return arrayS;
    }
    private static double[] check(double[][] array, double[] array1) {
        int n = array.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += array[i][j] * array1[j];
            }
            res[i] = sum;
        }
        boolean f = true;
        for (int i = 0; i < n; i++) {
            if (Math.abs(res[i] - array[i][n]) > 1e-6) {
                f = false;
                break;
            }
        }
        return f ? array1 : res;
    }
    private static void write(String file, List<double[]> resh) throws IOException {
        try (BufferedWriter fwr = new BufferedWriter(new FileWriter(file))) {
            for (double[] array1 : resh) {
                for (int i = 0; i < array1.length; i++) {
                    fwr.write(Double.toString(array1[i]));
                    if (i < array1.length - 1) {
                        fwr.write(" ");
                    }
                }
                fwr.newLine();
            }
        }
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
                fwr8.write("Постановка задачи\n\nПервая фигура\nx  [-9;4]\n"
                        +"Первая область\ny > 0.25 * x - 1\ny > 1.25 * x - 1\ny > - 4 * x - 18\ny < 0.5*x + 4.5\n\n"
                        +"Вторая область\nx  [-3;1]\ny < sqrt(4-pow(x + 1,2)) + 3\n"
                        +"Третяя область\nx  [1;4]\ny < 0.33*x + 2.67\n\n"
                        +"\nВторая фигура\nx[-;-]\n"
                        +"Первая область\nx[-;-]\ny < x - 2\ny < -4*x +28\ny > -3*x + 14\n\n"
                        +"Вторая область\nx[3;5]\ny > -sqrt(4-pow(x - 5,2))\n y > -3*x + 14\n"
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
                File file10 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t10.txt");
                FileWriter fwr10 = new FileWriter(file10, true);
                x = 0;
                System.out.println("Введите значение x");
                while (Math.abs(x = in.nextDouble()) >= 2.4){
                    System.out.println("Ошибка! Введите другое значение x");
                }
                int k = 0;
                double s = 0;
                for (double ep = 0.0001; ep <= 0.01; ep*=10){
                    s = 0;
                    k = 0;
                    while (Math.abs(Math.exp(x)*(1+x)-s) > ep){
                        s += (Math.pow(x,k)*(k + 1))/(factorial10(k));
                        k++;
                    }
                    fwr10.write("Функция f(x) = e^x(1 + x) для x = " + x + " равняется " + s + "\n"
                            +"Результаты определения значений функции f(x) = e^x(1 + x) с помощью ряда Маклорена\n"
                            +"Погрешность итерационной процедуры "+ep+"\n"
                            +"Значение функции по Маклорену\t\tПогрешность, %\tЧисло итераций\n"
                            +"\t"+s+"\t\t\t\t"+ep*100+"\t\t\t"+k+"\n\n");
                }
                fwr10.flush();
                fwr10.close();
                break;
            case 11:
                File file11 = new File("C:\\Users\\User\\Desktop\\ \\Лаба 10\\text11.txt");
                FileWriter fwr11 = new FileWriter(file11);
                DecimalFormat dec = new DecimalFormat("#.#");
                fwr11.write("Формула z = x^3*sin(y^2) + x^2*y^3,\n" +
                        "x: [-3;2]; x+=0.1, y: [-2;1]; y+=0.2\n\n" +
                        "\t\t\t\t\t\t\tМатрица значений Z\n\nX/Y\t");
                for (double y = -2; y <= 1; y+=0.2){
                    fwr11.write(dec.format(y) + "\t");
                }
                fwr11.write("\n");
                for ( x = -3; x <= 2; x+=0.1){
                    fwr11.write(dec.format(x) + "\t");
                    for (double y = -2; y <= 1; y+=0.2){
                        Double z = pow(x, 3)*sin(pow(y, 2))+pow(x,2)*pow(y, 3);
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
                String out = "C:\\Users\\User\\Desktop\\ \\Лаба 10\\t133.txt";
                List<double[][]> f1 = num13_read("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t131.txt");
                List<double[]> f2 = num13_readSLAU("C:\\Users\\User\\Desktop\\ \\Лаба 10\\t132.txt");
                List<double[]> corrected = new ArrayList<>();
                for (int i = 0; i < f1.size(); i++) {
                    double[][] array13 = f1.get(i);
                    double[] array113 = f2.get(i);
                    double[] array213 = check(array13, array113);
                    corrected.add(array213);
                }
                write(out, corrected);
                break;
            case 14:

                break;
            case 15:

                break;
        }

    }
}
