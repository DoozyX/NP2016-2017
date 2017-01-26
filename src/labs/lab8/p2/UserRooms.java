package labs.lab8.p2;

import java.util.ArrayList;

class UserRooms {
	private ArrayList<ChatRoom> rooms;
	private String userName;

	public UserRooms(String userName) {
		rooms = new ArrayList<>();
		this.userName = userName;
	}

	public void addRoom(ChatRoom chatRoom) {
		rooms.add(chatRoom);
	}

	public void removeRoom(ChatRoom chatRoom) {
		rooms.remove(chatRoom);
	}

	public ArrayList<ChatRoom> getRooms() {
		return rooms;
	}
}
