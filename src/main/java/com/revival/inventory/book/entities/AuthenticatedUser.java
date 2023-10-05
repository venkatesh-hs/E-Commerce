package com.revival.inventory.book.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticatedUser {
    User user;
    String token;
}
