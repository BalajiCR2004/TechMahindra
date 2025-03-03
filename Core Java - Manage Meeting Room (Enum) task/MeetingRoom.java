import java.util.*;

public class MeetingRoom {
    String roomId;
    String roomName;
    int capacity;
    EnumSet<RoomFeature> features;

    public MeetingRoom(String roomId, String roomName, int capacity, EnumSet<RoomFeature> features) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.features = features;
    }

    public boolean hasFeatures(EnumSet<RoomFeature> requiredFeatures) {
        return features.containsAll(requiredFeatures);
    }
}