import java.util.*;
class RoomScheduler {
    private final Map<String, MeetingRoom> rooms = new HashMap<>();

    public void addMeetingRoom(MeetingRoom room) {
        rooms.put(room.roomId, room);
        System.out.println("Room added: " + room.roomName + ", ID: " + room.roomId);
    }

    public String bookRoom(String roomId, EnumSet<RoomFeature> requiredFeatures) {
        MeetingRoom room = rooms.get(roomId);
        if (room != null && room.hasFeatures(requiredFeatures)) {
            System.out.println("Room " + roomId + " booked successfully.");
            return "Room " + roomId + " booked successfully.";
        } else {
            System.out.println("Room " + roomId + " does not meet the requirements.");
            return "Room " + roomId + " does not meet the requirements.";
        }
    }

    public List<String> listAvailableRooms(EnumSet<RoomFeature> requiredFeatures) {
        List<String> availableRooms = new ArrayList<>();
        for (MeetingRoom room : rooms.values()) {
            if (room.hasFeatures(requiredFeatures)) {
                availableRooms.add(room.roomName);
            }
        }
        System.out.println("Available rooms with " + requiredFeatures + ": " + availableRooms);
        return availableRooms;
    }
}
