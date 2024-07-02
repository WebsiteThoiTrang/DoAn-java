package com.nhom8.WebsiteThoiTrang;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public enum Role {
    ADMIN(1),
    USER(2),
    HR(3),
    Operations(4),
    IT(5);
    public final long value;
}