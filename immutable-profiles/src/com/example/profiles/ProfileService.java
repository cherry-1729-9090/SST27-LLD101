
package com.example.profiles;

/**
 * Assembles profiles using the immutable UserProfile and Builder.
 */
public class ProfileService {
    // Returns a fully built immutable profile
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    // Example: create with optional fields
    public UserProfile createFullProfile(String id, String email, String displayName) {
        return new UserProfile.Builder(id, email)
            .withDisplayName(displayName)
            .build();
    }
}
