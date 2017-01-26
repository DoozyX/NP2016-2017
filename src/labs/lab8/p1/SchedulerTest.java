package labs.lab8.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 * Распоредувач со Map Problem 1
 * Оваа задача е многу слична како задачата од лабараториска вежба 4 задача број 2 - меѓутоа сега ќе користите мапа за да ја имплементирате класата Sheduler и НЕ ви треба класата Timestamp.
 * <p>
 * Потсетување за задачата: Да се развие класа Scheduler.
 * Оваа класа чува објекти од генерички тип T кои единствено се референцираат преку време (објект од класата Date). Класата треба да ги имплементира следниве методи:
 * <p>
 * Sheduler() - креира нов празен распоредувач
 * add(Date d, T t) - додава нов објект во распоредувачот
 * remove(Date d):boolean - го брише соодветниот елемент од распоредувачот доколку постои и враќа true, во спротивно враќа false
 * next():T - го враќа следниот објект, односно тој објект кој е асоциран со дата најблиска до тековната и сеуште не е помината
 * last():T - го враќа следниот објект, односно тој објект кој е асоциран со дата најблиска до тековната и веќе е помината
 * getAll(Date begin,Date end):ArrayList<Т> - враќа листа на објекти чии дати се наоѓаат помеѓу begin и end.
 * _Забелешка_: Два објекти НЕ може да имаат исто време.
 * <p>
 * Имплементирајте и два дополнителни методи:
 * <p>
 * getFirst():Т - го враќа објектот асоциран со најмала дата (севкупно)
 * getLast():Т - го враќа објектот асоциран со најголема дат
 * Која мапа ги има функциите што ви се потребни:
 * HashMap или TreeMap?
 * <p>
 * Sample input
 * 0 whatever whatever first whatever whatever whatever last
 * <p>
 * Sample output
 * first
 * last
 */

public class SchedulerTest {


	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);
		int k = jin.nextInt();
		if ( k == 0 ) {
			Scheduler<String> scheduler = new Scheduler<String>();
			Date now = new Date();
			scheduler.add(new Date(now.getTime()-7200000), jin.next());
			scheduler.add(new Date(now.getTime()-3600000), jin.next());
			scheduler.add(new Date(now.getTime()-14400000), jin.next());
			scheduler.add(new Date(now.getTime()+7200000), jin.next());
			scheduler.add(new Date(now.getTime()+14400000), jin.next());
			scheduler.add(new Date(now.getTime()+3600000), jin.next());
			scheduler.add(new Date(now.getTime()+18000000), jin.next());
			System.out.println(scheduler.getFirst());
			System.out.println(scheduler.getLast());
		}
		if ( k == 3 ) { //test Scheduler with String
			Scheduler<String> scheduler = new Scheduler<String>();
			Date now = new Date();
			scheduler.add(new Date(now.getTime()-7200000), jin.next());
			scheduler.add(new Date(now.getTime()-3600000), jin.next());
			scheduler.add(new Date(now.getTime()-14400000), jin.next());
			scheduler.add(new Date(now.getTime()+7200000), jin.next());
			scheduler.add(new Date(now.getTime()+14400000), jin.next());
			scheduler.add(new Date(now.getTime()+3600000), jin.next());
			scheduler.add(new Date(now.getTime()+18000000), jin.next());
			System.out.println(scheduler.next());
			System.out.println(scheduler.last());
			ArrayList<String> res = scheduler.getAll(new Date(now.getTime()-10000000), new Date(now.getTime()+17000000));
			Collections.sort(res);
			for ( String t : res ) {
				System.out.print(t+" , ");
			}
		}
		if ( k == 4 ) {//test Scheduler with ints complex
			Scheduler<Integer> scheduler = new Scheduler<Integer>();
			int counter = 0;
			ArrayList<Date> to_remove = new ArrayList<Date>();

			while ( jin.hasNextLong() ) {
				Date d = new Date(jin.nextLong());
				int i = jin.nextInt();
				if ( (counter&7) == 0 ) {
					to_remove.add(d);
				}
				scheduler.add(d,i);
				++counter;
			}
			jin.next();

			while ( jin.hasNextLong() ) {
				Date l = new Date(jin.nextLong());
				Date h = new Date(jin.nextLong());
				ArrayList<Integer> res = scheduler.getAll(l,h);
				Collections.sort(res);
				System.out.println(l+" <: "+print(res)+" >: "+h);
			}
			System.out.println("test");
			ArrayList<Integer> res = scheduler.getAll(new Date(0),new Date(Long.MAX_VALUE));
			Collections.sort(res);
			System.out.println(print(res));
			for ( Date d : to_remove ) {
				scheduler.remove(d);
			}
			res = scheduler.getAll(new Date(0),new Date(Long.MAX_VALUE));
			Collections.sort(res);
			System.out.println(print(res));
		}
	}

	private static <T> String print(ArrayList<T> res) {
		if ( res == null || res.size() == 0 ) return "NONE";
		StringBuffer sb = new StringBuffer();
		for ( T t : res ) {
			sb.append(t+" , ");
		}
		return sb.substring(0, sb.length()-3);
	}


}
