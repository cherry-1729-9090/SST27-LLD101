import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createFullProfile("u1", "a@b.com", "Charan");
        System.out.println("Profile: " + p.getId() + ", " + p.getEmail() + ", " + p.getDisplayName());
        System.out.println("=> UserProfile is now immutable. No setters available.");
    }
}
