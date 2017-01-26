package exams.first.exercises.p7;

enum TimeFormat {
	FORMAT_24, FORMAT_AMPM
}

/**
 * TimeTable Problem 7
 * Да се имплементира класа TimeTable која ќе чита од влезен тек (стандарден влез, датотека, ...) податоци за времиња во 24-часовен формат. Сите времиња се разделени со едно празно место, а во самото време часот и минутите може да бидат разделени со : или .. Пример за форматот на податоците:
 * <p>
 * 11:15 0.45 23:12 15:29 18.46
 * <p>
 * Ваша задача е да ги имплементирате методите:
 * <p>
 * TimeTable() - default конструктор
 * void readTimes(InputStream inputStream) - метод за читање на податоците
 * void writeTimes(OutputStream outputStream, TimeFormat format) - метод кој ги печати сите времиња сортирани во растечки редослед во зададениот формат (24 часовен или AM/PM).
 * Методот за читање readTimes фрла исклучоци од тип UnsupportedFormatException ако времињата се разделени со нешто друго што не е : или . и InvalidTimeException ако времето (часот или минутите) е надвор од дозволениот опсег (0-23, 0-59). И двата исклучоци во пораката getMessage() треба да го вратат влезниот податок кој го предизвикал исклучокот. Сите времиња до моментот кога ќе се фрли некој од овие два исклучоци треба да си останат вчитани.
 * Правила за конверзија од 24-часовен формат во AM/PM:
 * <p>
 * за првиот час од денот (0:00 - 0:59), додадете 12 и направете го "AM"
 * од 1:00 до 11:59, само направето го "AM"
 * од 12:00 до 12:59, само направето го "PM"
 * од 13:00 до 23:59 одземете 12 и направете го "PM"
 * <p>
 * Sample input
 * 11:15 0.45 23:12
 * 15:29 18-46
 * <p>
 * Sample output
 * UnsupportedFormatException: 18-46
 * 24 HOUR FORMAT
 * 0:45
 * 11:15
 * 15:29
 * 23:12
 * AM/PM FORMAT
 * 12:45 AM
 * 11:15 AM
 * 3:29 PM
 * 11:12 PM
 */
public class TimesTest {
/*
    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable();
        try {
            timeTable.readTimes(System.in);
        } catch (UnsupportedFormatException e) {
            System.out.println("UnsupportedFormatException: " + e.getMessage());
        } catch (InvalidTimeException e) {
            System.out.println("InvalidTimeException: " + e.getMessage());
        }
        System.out.println("24 HOUR FORMAT");
        timeTable.writeTimes(System.out, TimeFormat.FORMAT_24);
        System.out.println("AM/PM FORMAT");
        timeTable.writeTimes(System.out, TimeFormat.FORMAT_AMPM);
    }*/

}