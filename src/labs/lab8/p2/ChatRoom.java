package labs.lab8.p2;

import java.util.Set;
import java.util.TreeSet;

class ChatRoom {
	private String name;
	private Set<String> users;

	public ChatRoom(String name) {
		this.name = name;
		users = new TreeSet<>();
	}

	public void addUser(String username) {
		users.add(username);
	}

	public void removeUser(String username) {
		users.remove(username);
	}

	public boolean hasUser(String username) {
		return users.contains(username);
	}

	public int numUsers() {
		return users.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name).append('\n');
		if (numUsers() == 0) {
			sb.append("EMPTY").append('\n');
		} else {
			for (String s : users) {
				sb.append(s).append('\n');
			}
		}
		return sb.toString();
	}
}
