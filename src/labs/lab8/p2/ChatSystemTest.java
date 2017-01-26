package labs.lab8.p2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Администрација на чет-систем Problem 2
 * Треба да се развие класа за администрација на чет‐систем(chat).
 * Системот се состои од повеќе чет‐соби, објекти од класата ChatRoom.
 * Во ChatRoom ги чуваме името на собата и имињата на корисниците кои тековно се наоѓаат во таа соба (за корисниците да се користи соодветен Set).
 * <p>
 * ChatRoom(String name) ‐ креира нова празна соба за чет (празна значи без корисници).
 * addUser(String username) - го додава корисникот со тоа име во собата.
 * removeUser(String username) - го отстранува корисникот со тоа име од собата доколку има таков, во спротивно не прави ништо.
 * toString():String - враќа стринг кои ги содржи името на собата и сите корисници кои се во собата секој одделен со нов ред.
 * Корисниците се подредени алфабетски. Ако собата е празна се враќа името на собата во еден ред, а во вториот ред стрингот "EMPTY" (наводници само за појаснување).
 * hasUser(String username):boolean - враќа true ако постои корисник со тоа име во собата.
 * numUsers():int - го враќа бројот на корисници во собата.
 * Главната  класа ChatSystem  ги  содржи  сите  соби  и  сите  орисници. Корисниците може да се членови на една, повеќе или да не се членови на ниедна соба.
 * За менаџмент на собите треба да ги понудите следните три методи:
 * <p>
 * addRoom(String roomName) - додава нова празна соба во листата на соби.
 * removeRoom(String roomName) - ја отстранува собата од листата.
 * getRoom(String roomName):ChatRoom - го враќа објектот кој ја претставува собата со име roomName. Фрлете NoSuchRoomException(roomName) доколку не постои соба со тоа име.
 * Забелешка: Собите чувајте ги во TreeMap за да бидат секогаш подредени по нивното име.
 * <p>
 * Дополнително во класата ChatSystem постојат следните методи за работа со корисниците:
 * <p>
 * ChatSystem() - default constructor
 * register(String userName) - го регистрира корисникот во системот. Го додава во собата со најмалку корисници. Доколку има повеќе такви соби тогаш го додава во првата соба по лексикоргафско подредување.
 * registerAndJoin(String userName, String roomName) - го регистрира корисникот во системот. Дополнително го додава во собата со име roomName.
 * joinRoom(String userName, String roomName) - го  додава  корисникот  во  собата  со соодветно  име  доколку  таа  постои,  во  спротивно  фрла  исклучок  од  типот NoSuchRoomExcеption(roomName).
 * Ако не постои регистриран корисник со тоа име се фрла исклучок NoSuchUserException(userName).
 * leaveRoom(String username, String roomName) - го отстранува корисникот од собата со соодветно  име  доколку  таа  постои.  во  спротивно  фрла  исклучок  од  типот NoSuchRoomExcеption(roomName).
 * Ако не постои регистриран корисник со тоа име се фрла исклучок NoSuchUserException(userName).
 * followFriend(String username, String friend_username) – корисникот со име username го приклучува во сите соби во кој е член корисникот со име friendUsername.
 * Ако не постои регистриран корисник со тоа име се фрла исклучок NoSuchUserException(userName).
 *
 * Sample input
 0 ChatRoom1
 5
 0 user1
 0 user2
 0 user3
 0 user4
 0 user5
 0
 *
 *Sample output
 ChatRoom1
 user1
 user2
 user3
 user4
 user5
 */


public class ChatSystemTest {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchRoomException {
		Scanner jin = new Scanner(System.in);
		int k = jin.nextInt();
		if (k == 0) {
			ChatRoom cr = new ChatRoom(jin.next());
			int n = jin.nextInt();
			for (int i = 0; i < n; ++i) {
				k = jin.nextInt();
				if (k == 0) cr.addUser(jin.next());
				if (k == 1) cr.removeUser(jin.next());
				if (k == 2) System.out.println(cr.hasUser(jin.next()));
			}
			System.out.println("");
			System.out.println(cr.toString());
			n = jin.nextInt();
			if (n == 0) return;
			ChatRoom cr2 = new ChatRoom(jin.next());
			for (int i = 0; i < n; ++i) {
				k = jin.nextInt();
				if (k == 0) cr2.addUser(jin.next());
				if (k == 1) cr2.removeUser(jin.next());
				if (k == 2) cr2.hasUser(jin.next());
			}
			System.out.println(cr2.toString());
		}
		if (k == 1) {
			ChatSystem cs = new ChatSystem();
			Method mts[] = cs.getClass().getMethods();
			while (true) {
				String cmd = jin.next();
				if (cmd.equals("stop")) break;
				if (cmd.equals("print")) {
					System.out.println(cs.getRoom(jin.next()) + "\n");
					continue;
				}
				for (Method m : mts) {
					if (m.getName().equals(cmd)) {
						String params[] = new String[m.getParameterTypes().length];
						for (int i = 0; i < params.length; ++i) {
							params[i] = jin.next();
						}
						m.invoke(cs, params);
					}
				}
			}
		}
	}

}
