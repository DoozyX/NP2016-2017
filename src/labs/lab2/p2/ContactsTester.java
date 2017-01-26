package labs.lab2.p2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Контакти Problem 2
 * Се со цел да се подобри комуникацијата на факултетот потребно е да се направи систем за чување на контакти за секој студент.
 * <p>
 * Да се креира класа Contact. За потребите на оваа класа да се дефинираат следниве методи:
 * <p>
 * Contact(String date) - конструктор каде што date е датумот кога е креиран контактот даден во следниов формат YYYY-MM-DD
 * isNewerThan(Contact c):boolean - метод кој враќа true доколку контактот е креиран подоцна од контактот c и обратно
 * getType():String - метод кој враќа вредност "Email" или "Phone" во зависност од типот на контактот
 * Од класата Contact не треба да може директно да се инстанцира објект.
 * <p>
 * Од оваа класа се изведуваат класите EmailContact и PhoneContact.
 * <p>
 * За класата EmailContact дополнително се чува e-маил кој што е од типот String. Да се дефинираат следниве методи:
 * <p>
 * EmailContact(String date, String email) - конструктор
 * getEmail():String - метод кој што го враќа е-маилот
 * getType():String- имплементација на методот од класата Contact
 * За класата PhoneContact дополнително се чува телефонски број кој што е од типот String и оператор кој што е енумерација и се дефинира на следниов начин enum Operator { VIP, ONE, TMOBILE }.
 * За оваа класа да се дефинираат следниве методи:
 * <p>
 * PhoneContact(String date, String phone) - конструктор
 * getPhone():String - метод кој што го враќа телефонскиот број
 * getOperator():Operator - метод кој што го враќа операторот (070, 071, 072 – TMOBILE, 075,076 – ONE, 077, 078 – VIP)
 * getType():String- имплементација на методот од класата Contact
 * Забелешка: Сите телефонски броеви се во формат 07X/YYY-ZZZ каде што X има вредност {0,1,2,5,6,7,8}
 * <p>
 * Потоа да се дефинира класата Student каде што се чува низа на контакти за секој студент
 * <p>
 * Student(String firstName, String lastName, String city, int age, long index) – конструктор
 * addEmailContact(String date, String email):void – метод што додава е-маил контакт во низата на контакти
 * addPhoneContact(String date, String phone):void – метод што додава телефонски контакт во низата на контакти
 * getEmailContacts():Contact[] – враќа низа на email контактите на студентот
 * getPhoneContacts():Contact[] – враќа низа на phone контактите на студентот
 * getCity():String - метод кој го враќа градот
 * getFullName():String - метод кој го враќа целосното име на студентот во формат IME PREZIME
 * getIndex():long - метод кој го враќа индексот на студентот
 * getLatestContact():Contact – го враќа најновиот контакт (според датум) од студентот
 * toString() – претставува JSON репрезентација на класата студент пр. {"ime":"Jovan", "prezime":"Jovanov", "vozrast":20, "grad":"Skopje", "indeks":101010, "telefonskiKontakti":["077/777-777", "078/888-888"],
 * "emailKontakti":["jovan.jovanov@example.com", "jovanov@jovan.com", "jovan@jovanov.com"]}
 * Забелешка: Во класата Student да се чува само една низа од контакти Contact[], а не две низи одделно (PhoneContact[] и EmailContact[])
 * <p>
 * Напомена да не се користи instanceOf или getClass при имплементација на овие методи
 * <p>
 * Дополнително да се дефинира класа Faculty. За оваа класа да се дефинираат следниве методи:
 * <p>
 * Faculty(String name, Student [] students) – конструктор
 * countStudentsFromCity(String cityName):int – враќа колку студенти има од даден град
 * getStudent(long index):Student – метод кој го враќа студентот кој го има дадениот индекс
 * getAverageNumberOfContacts():double – враќа просечен број на контакти по студент
 * getStudentWithMostContacts():Student – метод кој го враќа студентот со најмногу контакти (доколку има повеќе студенти со ист број на контакти да го врати студентот со најголем индекс)
 * toString() – претставува JSON репрезентација на класата Faculty пример: {"fakultet":"FINKI", "studenti":[STUDENT1, STUDENT2, ...]} каде што треба да има целосни информации за секој студент.
 * <p>
 * Sample input
 * 4
 * CREATE_FACULTY Ekonomski fakultet
 * 3
 * Sanja Mihova Skopje 21 82907017
 * Emil Stankov Bitola 29 43009931
 * Emil Trajanov Bitola 29 24914336
 * ADD_EMAIL_CONTACT 82907017 2012-04-10 sanja@ef.ukim.mk
 * ADD_PHONE_CONTACT 82907017 2010-03-05 070/744-235
 * CHECK_SIMPLE
 * <p>
 * Sample output
 * Average number of contacts: 0.67
 * Number of students from Skopje: 1
 */

public class ContactsTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int tests = scanner.nextInt();
		Faculty faculty = null;

		int rvalue = 0;
		long rindex = -1;

		DecimalFormat df = new DecimalFormat("0.00");

		for (int t = 0; t < tests; t++) {

			rvalue++;
			String operation = scanner.next();

			switch (operation) {
				case "CREATE_FACULTY": {
					String name = scanner.nextLine().trim();
					int N = scanner.nextInt();

					Student[] students = new Student[N];

					for (int i = 0; i < N; i++) {
						rvalue++;

						String firstName = scanner.next();
						String lastName = scanner.next();
						String city = scanner.next();
						int age = scanner.nextInt();
						long index = scanner.nextLong();

						if ((rindex == -1) || (rvalue % 13 == 0))
							rindex = index;

						Student student = new Student(firstName, lastName, city,
								age, index);
						students[i] = student;
					}

					faculty = new Faculty(name, students);
					break;
				}

				case "ADD_EMAIL_CONTACT": {
					long index = scanner.nextInt();
					String date = scanner.next();
					String email = scanner.next();

					rvalue++;

					if ((rindex == -1) || (rvalue % 3 == 0))
						rindex = index;

					faculty.getStudent(index).addEmailContact(date, email);
					break;
				}

				case "ADD_PHONE_CONTACT": {
					long index = scanner.nextInt();
					String date = scanner.next();
					String phone = scanner.next();

					rvalue++;

					if ((rindex == -1) || (rvalue % 3 == 0))
						rindex = index;

					faculty.getStudent(index).addPhoneContact(date, phone);
					break;
				}

				case "CHECK_SIMPLE": {
					System.out.println("Average number of contacts: "
							+ df.format(faculty.getAverageNumberOfContacts()));

					rvalue++;

					String city = faculty.getStudent(rindex).getCity();
					System.out.println("Number of students from " + city + ": "
							+ faculty.countStudentsFromCity(city));

					break;
				}

				case "CHECK_DATES": {

					rvalue++;

					System.out.print("Latest contact: ");
					Contact latestContact = faculty.getStudent(rindex)
							.getLatestContact();
					System.out.println(latestContact.getType());
					if (latestContact.getType().equals("Email"))
						System.out.println(((EmailContact) latestContact)
								.getEmail());
					if (latestContact.getType().equals("Phone"))
						System.out.println(((PhoneContact) latestContact)
								.getPhone()
								+ " ("
								+ ((PhoneContact) latestContact).getOperator()
								.toString() + ")");

					if (faculty.getStudent(rindex).getEmailContacts().length > 0
							&& faculty.getStudent(rindex).getPhoneContacts().length > 0) {
						System.out.print("Number of email and phone contacts: ");
						System.out
								.println(faculty.getStudent(rindex)
										.getEmailContacts().length
										+ " "
										+ faculty.getStudent(rindex)
										.getPhoneContacts().length);

						System.out.print("Comparing dates: ");
						int posEmail = rvalue
								% faculty.getStudent(rindex).getEmailContacts().length;
						int posPhone = rvalue
								% faculty.getStudent(rindex).getPhoneContacts().length;

						System.out.println(faculty.getStudent(rindex)
								.getEmailContacts()[posEmail].isNewerThan(faculty
								.getStudent(rindex).getPhoneContacts()[posPhone]));
					}

					break;
				}

				case "PRINT_FACULTY_METHODS": {
					System.out.println("Faculty: " + faculty.toString());
					System.out.println("Student with most contacts: "
							+ faculty.getStudentWithMostContacts().toString());
					break;
				}

			}

		}

		scanner.close();
	}
}
