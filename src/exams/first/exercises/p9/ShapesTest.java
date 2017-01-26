package exams.first.exercises.p9;

/**
 * Stacked canvas Problem 9
 * Да се имплементира класа Canvas на која ќе чуваат различни форми. За секоја форма се чува:
 * <p>
 * id:String
 * color:Color (enum дадена)
 * Притоа сите форми треба да имплментираат два интерфејси:
 * <p>
 * Scalable - дефиниран со еден метод void scale(float scaleFactor) за соодветно зголемување/намалување на формата за дадениот фактор
 * Stackable - дефиниран со еден метод float weight() кој враќа тежината на формата (се пресметува како плоштина на соодветната форма)
 * Во класата Canvas да се имплементираат следните методи:
 * <p>
 * void add(String id, Color color, float radius) за додавање круг
 * void add(String id, Color color, float width, float height) за додавање правоаголник
 * При додавањето на нова форма, во листата со форми таа треба да се смести на соодветното место според нејзината тежина. Елементите постојано се подредени според тежината во опаѓачки редослед.
 * <p>
 * void scale(String id, float scaleFactor) - метод кој ја скалира формата со даденото id за соодветниот scaleFactor. Притоа ако има потреба, треба да се изврши преместување на соодветните форми, за да се задржи подреденоста на елементите.
 * Не смее да се користи сортирање на листата.
 * <p>
 * toString() - враќа стринг составен од сите фигури во нов ред. За секоја фигура се додава:
 * C: [id:5 места од лево] [color:10 места од десно] [weight:10.2 места од десно] ако е круг
 * R: [id:5 места од лево] [color:10 места од десно] [weight:10.2 места од десно] ако е правоаголник
 * Користење на instanceof ќе се смета за неточно решение
 * <p>
 * Sample input
 * 1 c1 RED 7
 * 1 c2 GREEN 12
 * 1 c3 RED 3
 * 2 r1 BLUE 4 7
 * 2 r2 GREEN 10 8
 * 1 c4 RED 5
 * 2 r3 RED 6 7
 * 1 c5 GREEN 14
 * 2 r4 BLUE 6 3
 * 3 c4 1.4
 * 3 r2 0.4
 * 3 c2 2.1
 * <p>
 * Sample output
 * ORIGNAL:
 * C: c5   GREEN         615.75
 * C: c2   GREEN         452.39
 * C: c1   RED           153.94
 * R: r2   GREEN          80.00
 * C: c4   RED            78.54
 * R: r3   RED            42.00
 * C: c3   RED            28.27
 * R: r1   BLUE           28.00
 * R: r4   BLUE           18.00
 * AFTER SCALING: c4 1.40
 * C: c5   GREEN         615.75
 * C: c2   GREEN         452.39
 * C: c1   RED           153.94
 * C: c4   RED           153.94
 * R: r2   GREEN          80.00
 * R: r3   RED            42.00
 * C: c3   RED            28.27
 * R: r1   BLUE           28.00
 * R: r4   BLUE           18.00
 * ORIGNAL:
 * C: c5   GREEN         615.75
 * C: c2   GREEN         452.39
 * C: c1   RED           153.94
 * C: c4   RED           153.94
 * R: r2   GREEN          80.00
 * R: r3   RED            42.00
 * C: c3   RED            28.27
 * R: r1   BLUE           28.00
 * R: r4   BLUE           18.00
 * AFTER SCALING: r2 0.40
 * C: c5   GREEN         615.75
 * C: c2   GREEN         452.39
 * C: c1   RED           153.94
 * C: c4   RED           153.94
 * R: r3   RED            42.00
 * C: c3   RED            28.27
 * R: r1   BLUE           28.00
 * R: r4   BLUE           18.00
 * R: r2   GREEN          12.80
 * ORIGNAL:
 * C: c5   GREEN         615.75
 * C: c2   GREEN         452.39
 * C: c1   RED           153.94
 * C: c4   RED           153.94
 * R: r3   RED            42.00
 * C: c3   RED            28.27
 * R: r1   BLUE           28.00
 * R: r4   BLUE           18.00
 * R: r2   GREEN          12.80
 * AFTER SCALING: c2 2.10
 * C: c2   GREEN        1995.04
 * C: c5   GREEN         615.75
 * C: c1   RED           153.94
 * C: c4   RED           153.94
 * R: r3   RED            42.00
 * C: c3   RED            28.27
 * R: r1   BLUE           28.00
 * R: r4   BLUE           18.00
 * R: r2   GREEN          12.80
 */

enum Color {
	RED, GREEN, BLUE
}

public class ShapesTest {
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Canvas canvas = new Canvas();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int type = Integer.parseInt(parts[0]);
            String id = parts[1];
            if (type == 1) {
                Color color = Color.valueOf(parts[2]);
                float radius = Float.parseFloat(parts[3]);
                canvas.add(id, color, radius);
            } else if (type == 2) {
                Color color = Color.valueOf(parts[2]);
                float width = Float.parseFloat(parts[3]);
                float height = Float.parseFloat(parts[4]);
                canvas.add(id, color, width, height);
            } else if (type == 3) {
                float scaleFactor = Float.parseFloat(parts[2]);
                System.out.println("ORIGNAL:");
                System.out.print(canvas);
                canvas.scale(id, scaleFactor);
                System.out.printf("AFTER SCALING: %s %.2f\n", id, scaleFactor);
                System.out.print(canvas);
            }

        }
    }*/
}

class Canvas {

}