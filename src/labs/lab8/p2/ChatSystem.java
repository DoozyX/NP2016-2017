package labs.lab8.p2;

import java.util.*;

class ChatSystem {
	private TreeMap<String, ChatRoom> rooms;
	private Map<String, UserRooms> users;

	public ChatSystem() {
		rooms = new TreeMap<>();
		users = new HashMap<>();
	}

	public void addRoom(String roomName) {
		rooms.put(roomName, new ChatRoom(roomName));
	}

	public void removeRoom(String roomName) {
		rooms.remove(roomName);
	}

	public ChatRoom getRoom(String roomName) throws NoSuchRoomException {
		if (rooms.containsKey(roomName)) {
			return rooms.get(roomName);
		} else {
			throw new NoSuchRoomException();
		}
	}

	private ChatRoom findMinRoom() {
		int min = Integer.MAX_VALUE;
		ChatRoom minRoom = rooms.firstEntry().getValue();
		for (ChatRoom chatRoom : rooms.values()) {
			if (chatRoom.numUsers() < min) {
				min = chatRoom.numUsers();
				minRoom = chatRoom;
			}
		}
		return minRoom;
	}


	public void register(String userName) {
		if (rooms.isEmpty()) {
			users.put(userName, new UserRooms(userName));
		} else {
			ChatRoom min = findMinRoom();
			UserRooms userRooms = new UserRooms(userName);
			userRooms.addRoom(min);
			users.put(userName, userRooms);
			min.addUser(userName);
		}
	}


	public void registerAndJoin(String userName, String roomName) {
		ChatRoom chatRoom = rooms.get(roomName);
		UserRooms userRooms = new UserRooms(userName);

		chatRoom.addUser(userName);

		userRooms.addRoom(chatRoom);

		users.put(userName, userRooms);
	}

	public void checkUser(String userName) throws Exception {
		if (users.get(userName) == null) {
			throw new NoSuchUserException();
		}
	}

	public void checkRoom(String roomName) throws Exception {
		if (rooms.get(roomName) == null) {
			throw new NoSuchRoomException();
		}
	}


	public void joinRoom(String userName, String roomName) throws Exception {
		checkUser(userName);
		checkRoom(roomName);

		ChatRoom chatRoom = rooms.get(roomName);
		UserRooms userRooms = users.get(userName);

		chatRoom.addUser(userName);
		userRooms.addRoom(chatRoom);
	}

	public void leaveRoom(String userName, String roomName) throws Exception {
		checkUser(userName);
		checkRoom(roomName);

		ChatRoom chatRoom = rooms.get(roomName);
		UserRooms userRooms = users.get(userName);

		chatRoom.removeUser(userName);
		userRooms.removeRoom(chatRoom);
	}

	public void followFriend(String userName, String friendUserName) throws Exception {
		checkUser(userName);
		checkUser(friendUserName);

		if (rooms.size() != 0) {

			UserRooms userRooms = users.get(userName);
			ArrayList<ChatRoom> friendRooms = users.get(friendUserName).getRooms();


			for (ChatRoom chatRoom : friendRooms) {
				userRooms.addRoom(chatRoom);
				chatRoom.addUser(userName);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Collection<ChatRoom> collection = rooms.values();
		for (ChatRoom chatRoom : collection) {
			sb.append(chatRoom).append('\n');
		}
		return sb.toString();
	}
}
