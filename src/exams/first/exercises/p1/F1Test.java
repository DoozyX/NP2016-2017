package exams.first.exercises.p1;

/**
 * Ф1 Трка (30 поени) Problem 1
 * Да се имплементира класа F1Race која ќе чита од влезен тек (стандарден влез, датотека, ...) податоци за времињата од последните 3 круга на неколку пилоти на Ф1 трка. Податоците се во следниот формат:
 * <p>
 * Driver_name lap1 lap2 lap3, притоа lap е во формат mm:ss:nnn каде mm се минути ss се секунди nnn се милисекунди (илјадити делови од секундата). Пример:
 * <p>
 * Vetel 1:55:523 1:54:987 1:56:134.
 * <p>
 * Ваша задача е да ги имплементирате методите:
 * <p>
 * F1Race() - default конструктор
 * void readResults(InputStream inputStream) - метод за читање на податоците
 * void printSorted(OutputStream outputStream) - метод кој ги печати сите пилоти сортирани според нивното најдобро време (најкраткото време од нивните 3 последни круга)
 * во формат Driver_name best_lap со 10 места за името на возачот (порамнето од лево) и 10 места за времето на најдобриот круг порамнето од десно.
 * Притоа времето е во истиот формат со времињата кои се читаат.
 * <p>
 * Sample input
 * Massa 1:57:563 1:55:187 1:55:634
 * Vettel 1:55:523 1:54:987 1:56:134
 * Alonso 1:53:563 1:56:187 1:54:139
 * Hamilton 1:56:174 1:54:371 1:56:199
 * <p>
 * Sample output
 * 1. Alonso      1:53:563
 * 2. Hamilton    1:54:371
 * 3. Vettel      1:54:987
 * 4. Massa       1:55:187
 */

public class F1Test {
/*
    public static void main(String[] args) {
        F1Race f1Race = new F1Race();
        f1Race.readResults(System.in);
        f1Race.printSorted(System.out);
    }
*/

}